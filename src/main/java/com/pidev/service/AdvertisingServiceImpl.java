package com.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.repository.AdvertisingRepository;

import com.pidev.serviceInterface.IAdvertisingService;

@Service
public class AdvertisingServiceImpl implements IAdvertisingService{
	@Autowired
	AdvertisingRepository advertisingRepository;
}
