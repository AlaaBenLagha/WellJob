package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pidev.repository.EmployeeBadgeRepository;
import com.pidev.serviceInterface.IReviewEmployeeService;

@Service
public class ReviewEmployeeServiceImpl implements IReviewEmployeeService {
	@Autowired
	EmployeeBadgeRepository employeeBadgeRepository;

}
