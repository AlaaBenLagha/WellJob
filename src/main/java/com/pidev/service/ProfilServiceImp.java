package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.ProfilRepository;
import com.pidev.serviceInterface.IProfilService;

@Service
public class ProfilServiceImp implements IProfilService {

	@Autowired
	ProfilRepository profilRepository;
}
