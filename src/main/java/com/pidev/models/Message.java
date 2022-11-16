package com.pidev.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name ="message")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdMessage;
	
	@Temporal(TemporalType.DATE)
	private Date DateSend;
	
	@Temporal(TemporalType.DATE)
	private Date DAteRead;
	
	private String Text;
	
	
	@ManyToOne
	private Conversation conversation;
	
	@ManyToOne
	private ConversationPart conversationPart;
	
	
	
	
}
