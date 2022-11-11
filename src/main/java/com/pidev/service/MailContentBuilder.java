package com.pidev.service;

import lombok.AllArgsConstructor;

import java.nio.charset.StandardCharsets;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Service
@AllArgsConstructor
public class MailContentBuilder {
	
    private final TemplateEngine templateEngine;

    public String build(String message) {
    	
    	
        Context context = new Context();
        context.setVariable("message", message);
        

        return templateEngine.process("mailTemplate", context);
    }
	
	
	  
	 
}
