package com.telstra.codechallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.codechallenge.model.Account;
import com.telstra.codechallenge.model.Repository;
import com.telstra.codechallenge.service.Service;

@RestController
public class HottestRepoController {

	@Autowired
	private Service service;

	@GetMapping(path = "/hottestRepo.json", produces = MediaType.APPLICATION_JSON_VALUE)
	public Repository[] findHottestRepo(@RequestParam int count) {

		return service.findHottestRespos(count);
	}
	
	@GetMapping(path = "/userAccountWithNoFollowers.json", produces = MediaType.APPLICATION_JSON_VALUE)
	public Account[] findUsersWithNoFollowers(@RequestParam int count) {

		return service.findUserAccount(count);
	}
	
}
