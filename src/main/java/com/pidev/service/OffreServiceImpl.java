package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pidev.repository.OffreRepository;
import com.pidev.serviceInterface.IOffreService;

@Service
public class OffreServiceImpl implements IOffreService{
	@Autowired
	OffreRepository offreRepository;
	
}
