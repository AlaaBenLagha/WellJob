package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.OptionRepository;
import com.pidev.serviceInterface.IOptionService;

@Service
public class OptionServiceImpl implements IOptionService {
	@Autowired
	OptionRepository optionRepository;

}
