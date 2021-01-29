package com.cybertek;

import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivedqeuriesApplication {

	@Autowired
	RegionRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DerivedqeuriesApplication.class, args);
	}

	@PostConstruct
	public void testRegions(){
		System.out.println("-----Regions start----");

		System.out.println("find By Country :" + repository.findByCountry("Canada"));

		System.out.println("findByCountryContaining :" + repository.findByCountryContaining("United"));

		System.out.println("findByCountryContainingOrderByCountry :" + repository.findByCountryContainingOrderByCountry("Canada"));

		System.out.println("findTop2ByCountry :" + repository.findTop2ByCountry("Canada"));


	}
}
