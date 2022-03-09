package com.pidev.serviceInterface;

import java.util.List;

import com.pidev.models.Advertising;

public interface IAdvertisingService {

	List<Advertising> getAllAdvertising();
	Advertising addAdvertising(Advertising Article);
	void deleteAdvertising(Long id);
	Advertising updateAdvertising(Advertising Article , Long id);
	Advertising getAdvertising(Long id);
	List<Advertising> retrieveAdvertisingByTitle(String titleAd);
}
