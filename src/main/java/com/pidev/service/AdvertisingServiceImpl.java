package com.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.Advertising;
import com.pidev.repository.AdvertisingRepository;

import com.pidev.serviceInterface.IAdvertisingService;

@Service
public class AdvertisingServiceImpl implements IAdvertisingService{
	@Autowired
	AdvertisingRepository advertisingRepository;

	@Override
	public List<Advertising> getAllAdvertising() {
		return (List<Advertising>) advertisingRepository.findAll();
	}

	@Override
	public Advertising addAdvertising(Advertising ad) {
		return advertisingRepository.save(ad);
	}

	@Override
	public void deleteAdvertising(Long id) {
		advertisingRepository.deleteById(id);
		
	}

	@Override
	public Advertising updateAdvertising(Advertising ad, Long id) {
		ad.setIdAd(id);
		return advertisingRepository.save(ad);
	}

	@Override
	public Advertising getAdvertising(Long id) {
		return advertisingRepository.findById(id).get();
	}

	//get by title
	@Override
	public List<Advertising> retrieveAdvertisingByTitle(String titleAd) {
		return advertisingRepository.retrieveAdvertisingByTitle(titleAd);
	}

	
}
