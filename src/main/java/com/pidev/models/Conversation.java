package com.pidev.models;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name ="conversation")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Conversation implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdConversation;
	
	@ManyToMany(mappedBy="conversations", cascade = CascadeType.ALL )
	private Set<MessageBox> messageBoxs;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="conversation")
	private Set<ConversationPart> conversationParts;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="conversation")
	private Set<Message> messages;
	
	
	
}
