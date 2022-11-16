package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pidev.repository.EmployeeBadgeRepository;
import com.pidev.serviceInterface.IEmployeeBadgeService;

@Service
public class EmployeeBadgeServiceImpl implements IEmployeeBadgeService {
	
	@Autowired
	EmployeeBadgeRepository employeeBadgeRepository;

}
