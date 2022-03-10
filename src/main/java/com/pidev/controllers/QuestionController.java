package com.pidev.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pidev.models.AttemptedQuiz;
import com.pidev.models.NotificationEmail;
import com.pidev.models.Question;
import com.pidev.models.Quiz;
import com.pidev.models.QuizResultResponse;
import com.pidev.models.User;
import com.pidev.repository.AttemptedQuizRepository;
import com.pidev.repository.UserRepository;
import com.pidev.service.AuthService;
import com.pidev.service.MailContentBuilder;
import com.pidev.service.MailService;
import com.pidev.service.VoteService;
import com.pidev.serviceInterface.QuestionService;
import com.pidev.serviceInterface.QuizService;
import com.pidev.serviceInterface.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/question/")

public class QuestionController {
	
	@Autowired 
	QuestionService questionService;
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	QuizService quizService;
	
	@Autowired
	UserService usersService;
	
	@Autowired
	AttemptedQuizRepository attemptedQuizRepo;
	
	@Autowired
    MailService mailService;
	
	@Autowired
    AuthService authService;
	
	
	@Autowired
	MailContentBuilder mailContentBuilder;
	
  
	
	

	@PostMapping(value="/add-questions",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	@PutMapping(value="/update-questions",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	@GetMapping("/{quizId}")
	public ResponseEntity<?> getAllQuestion(@PathVariable("quizId") Long quizId) throws Exception{
		Quiz quiz=this.quizService.getQuizById(quizId);
		Set<Question> question=quiz.getQuestion();
		List<Question> listOfQuestions=new ArrayList<>(question);
		if(listOfQuestions.size()>Integer.parseInt(quiz.getNumberOfQuestions())) {
			listOfQuestions=listOfQuestions.subList(0,Integer.parseInt(quiz.getNumberOfQuestions())+1);
		}
		return ResponseEntity.ok(listOfQuestions);
	}
	
	@GetMapping("/admin/{quizId}")
	public ResponseEntity<?> getAllQuestionForAdmin(@PathVariable("quizId") Long quizId) throws Exception{
		System.out.println("quiz to be fetch with id :"+quizId);
		Quiz quiz=this.quizService.getQuizById(quizId);
		Set<Question> question=quiz.getQuestion();
		List<Question> listOfQuestions=new ArrayList<>(question);
		return ResponseEntity.ok(listOfQuestions);
	}
	
	@GetMapping("/ById/{quesId}")
	public Question getQuestion(@PathVariable("quesId") Long quesId) throws Exception {
		Question question=this.questionService.getQuestionById(quesId);
		System.out.println("Question content is:"+question.getContent());
		return this.questionService.getQuestionById(quesId);
	}
	
	@DeleteMapping("/{quesId}")
	public void deleteQuestion(@PathVariable("quesId") Long quesId) throws Exception{
		this.questionService.deletequestion(quesId);
	}
	
	
	
	
	
	
	
	@PostMapping("/evaluate-quiz")
	public ResponseEntity<?> evaluateQuiz(@RequestBody List<Question> questions){
		System.out.println(questions);
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=null;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		
		
		//set attempted quiz to specific user
		Optional<User> theUser=this.userRepository.findByUsername(username);
		AttemptedQuiz attemptedQuiz=new AttemptedQuiz();
	    attemptedQuiz.setUsername(username);
	    attemptedQuizRepo.save(attemptedQuiz);
		Integer correctAnswers=0;
		double marksObtained = 0;
		double score3 = 0;
		Integer attempted=0;
		for(Question theQues:questions) {
			try {
				Question question=this.questionService.getQuestionById(theQues.getQuesId());
				
				//set specific question attended by user in his/her attempted quiz so it can access limited number of time to quiz
				if(theQues.getGivenAnswer().trim().equals(question.getAnswer().trim())) {
					correctAnswers=correctAnswers+1;
					attempted=attempted+1;
				}
				else {
					attempted=attempted+1;
				}
				double marksObtainedPerQuestion=Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
				marksObtained=correctAnswers*marksObtainedPerQuestion;
				
				
				//set a list to questions in users attempted quiz
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	
		//Resultat Quiz
		
		QuizResultResponse result=new QuizResultResponse();
		
		
		result.setCorrectAnswers(correctAnswers);
		result.setAttempted(attempted);
		result.setMarksObtained(marksObtained);
		result.setQuestions(questions);
		
		// Affectation de score
		User user= usersService.findUser(username);
		double score = user.getScore();
		double score2 = result.getMarksObtained();
		score3 = score + score2;
		user.setScore(score3);
		usersService.save(user);
		
		// Affectation De Quiz for User in Attempted Quiz Table
		Long ids = questions.get(0).getQuiz().getQid();
		attemptedQuiz.setQuizId(ids);
		attemptedQuizRepo.save(attemptedQuiz);
		
		
		
		// Message Obtenu par rapport au note du test
		String feedbackQuiz = null;
		if (Double.parseDouble(questions.get(0).getQuiz().getMaxMarks()) == marksObtained) {
			feedbackQuiz=("Perfect Test your are doing very well");
		}else if (Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/2 <= (marksObtained)   &   Double.parseDouble(questions.get(0).getQuiz().getMaxMarks()) != marksObtained  ) {
			feedbackQuiz=("Good Job  ");
			
		}else {
			feedbackQuiz=("U didnt pass the Quiz test u need to improve ");
			
		}
		
		
		// Envoi de Mail
		String message = mailContentBuilder.build("                                                                                                                                                        |||                 Hello " + username + "  You have Passe The Quiz Test  "+ "                                                                                                                                                        |||                 Number Of Question Attempted " + attempted + "                                                                                                                                                        |||                 Number Of Correct Answers : "  + correctAnswers  + "                                                                                                                                                        |||                 Marks Obtained :  "+ marksObtained  + "                                                                                                                                                        |||                 Your Total score is "  + score3  + "                                                                                                                                                        |||                 " + feedbackQuiz +  "                                                                                                                                                        ");
sendQuizNotifcation(message, theUser.get() );


		
		return ResponseEntity.ok(result);
		
		
	}
	
	

	public void sendQuizNotifcation(String message, User user ) {
        mailService.sendMail(new NotificationEmail(" Quiz Validated ", user.getEmail(), message));
    }

	
	
	
	

	
	
	
	
	
	

}
