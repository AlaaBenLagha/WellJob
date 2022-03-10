package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.ReviewCompanyRepository;
import com.pidev.serviceInterface.IReviewService;

@Service
public class ReviewServiceImpl implements IReviewService {
	@Autowired
	ReviewCompanyRepository reviewCompanyRepository;

}
