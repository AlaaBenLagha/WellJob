package com.pidev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.models.Profil;
import com.pidev.services.IProfilService;

@RestController
@RequestMapping("profil")
public class ProfilController {
	
	@Autowired
	IProfilService iprofilService;
	
	@PostMapping("/add-profil")
	@ResponseBody
	public Profil addProfil(@RequestBody Profil p) {
		Profil pf = iprofilService.addProfil(p);
		return pf;
	}
	
	@GetMapping("/list-profils")
	@ResponseBody
	public List<Profil> listProfils(){
		return iprofilService.retrieveAllProfils();
	}
	
	@GetMapping("/Max-score-profil")
	@ResponseBody
	public List<Profil> listMAXProfils(){
		return iprofilService.MaxScoreProfil();
	}
	
	@GetMapping("/Search-profil")
	@ResponseBody
	public List<Profil> listSearchProfil(){
		return iprofilService.SearchProfil();
	}

}
