package com.pidev.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.io.IOException;
import com.lowagie.text.DocumentException;
import com.pidev.models.Collaboration;
import com.pidev.serviceInterface.ICollaborationService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/collaboration")
public class CollaborationRestController {
	
	@Autowired
	ICollaborationService collaborationService;
	
		//http://localhost:8082/SpringMVC/collaboration/addcollab
		@PostMapping("/addcollab")
		@ResponseBody	
		public void addCollab(@Valid @RequestBody Collaboration collaboration) {
			collaborationService.addCollaboration(collaboration);		

		}
		
		//http://localhost:8082/SpringMVC/collaboration/getallcollaborations
		@GetMapping("/getallcollaborations")
		@ResponseBody
		public List<Collaboration> GetCollaboration() {
			return collaborationService.GetAllCollaborations();

		}
		
		//http://localhost:8082/SpringMVC/collaboration/getcollaboration/
		@GetMapping("/getcollaboration/{id}")
		@ResponseBody
		public Collaboration GetCollaboration(@PathVariable("id")  Long id) {
			return collaborationService.getCollaboration(id);

		}
		
		//http://localhost:8082/SpringMVC/collaboration/deletecollaboration/
		@DeleteMapping("/deletecollaboration/{id}")
		@ResponseBody
		public void deleteCollaboration(@PathVariable("id")  Long id) {
			collaborationService.deleteCollaboration(id);

		}
		
		//http://localhost:8082/SpringMVC/collaboration/updatecollaboration/
		@PutMapping("/updatecollaboration/{id}")
		@ResponseBody
		public Collaboration updateCollaboration(@RequestBody Collaboration collaboration, @PathVariable("id")  Long id) {
			return collaborationService.updateCollaboration(collaboration, id);

		}
		
		//http://localhost:8082/SpringMVC/collaboration/getcollaborationby/
		@GetMapping("/getcollaborationby/{collaboratedWith}")
		@ResponseBody
		public List<Collaboration> retrieveAdvertisingByEntreprise(@PathVariable("collaboratedWith") String collaboratedWith) {
			return collaborationService.retrieveAdvertisingByEntreprise(collaboratedWith);
			
		}
		
		//http://localhost:8082/SpringMVC/collaboration/export/excel
		@GetMapping("/export/excel")
		public void exportToExcel(HttpServletResponse response) throws IOException, java.io.IOException {
		    response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		 
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=collaboratiosn_" + currentDateTime + ".xlsx";
	    response.setHeader(headerKey, headerValue);
	     
	    List<Collaboration> listCollaborations = collaborationService.GetAllCollaborations();
	     
	    ExcelExporter excelExporter = new ExcelExporter(listCollaborations);
	     
	    excelExporter.export(response);    
		}  
		
		//http://localhost:8082/SpringMVC/collaboration/getRateStat
//		@GetMapping("/getRateStat")
//		@ResponseBody
//	    public  List<Collaboration> statistic  () {
//			return collaborationService.statistic();
//		}
		
//		@GetMapping("/search")
//		@ResponseBody
//		public List<Collaboration> findAllByOrPredicate(@RequestParam String search) {
//		    Specification<Collaboration> spec = resolveSpecification(search);
//		    return collaborationService.GetAllCollaborations(spec);
//		}
//
//		protected Specification<Collaboration> resolveSpecification(String searchParameters) {
//		    CollaborationSpecificationsBuilder builder = new CollaborationSpecificationsBuilder();
//		    String operationSetExper = Joiner.on("|")
//		      .join(SearchOperation.SIMPLE_OPERATION_SET);
//		    Pattern pattern = Pattern.compile(
//		      "(\\p{Punct}?)(\\w+?)("
//		      + operationSetExper 
//		      + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
//		    Matcher matcher = pattern.matcher(searchParameters + ",");
//		    while (matcher.find()) {
//		        builder.with(matcher.group(1), matcher.group(2), matcher.group(3), 
//		        matcher.group(5), matcher.group(4), matcher.group(6));
//		    }
//		    
//		    return builder.build();
//		}

}
