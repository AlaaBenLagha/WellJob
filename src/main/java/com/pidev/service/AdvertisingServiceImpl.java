package com.pidev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.Advertising;
import com.pidev.models.Offre;
import com.pidev.repository.AdvertisingRepository;
import com.pidev.repository.OffreRepository;
import com.pidev.serviceInterface.IAdvertisingService;

@Service
public class AdvertisingServiceImpl implements IAdvertisingService{
	@Autowired
	AdvertisingRepository advertisingRepository;
	@Autowired
	OffreRepository offreRepository;

	@Override
	public List<Advertising> getAllAdvertising() {
		return (List<Advertising>) advertisingRepository.findAll();
	}

	@Override
	public Advertising addAdvertising(Advertising ad, Long idOffre) {
		Offre offre = offreRepository.findById(idOffre).orElse(null);
		ad.setOffre(offre);
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
