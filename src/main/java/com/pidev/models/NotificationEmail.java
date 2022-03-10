package com.pidev.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEmail implements Serializable {
	private static final long serialVersionUID = 1L; 
    private String subject;
    private String recipient;
    private String body;
}