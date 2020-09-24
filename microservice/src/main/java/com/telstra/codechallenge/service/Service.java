package com.telstra.codechallenge.service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.telstra.codechallenge.model.Account;
import com.telstra.codechallenge.model.RepoResponse;
import com.telstra.codechallenge.model.Repository;
import com.telstra.codechallenge.model.UserAccountDetails;

@Component
public class Service {
	
	@Autowired
	private RestTemplate restTemplate;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Value("${user.repo.base.url}")
	private String usersBaseRepo;
	
	@Value("${hottest.repo.base.url}")
	private String hottestRepoURL;
	
	public Repository[] findHottestRespos(int count) {
		Repository[] results = restTemplate.getForObject(prepareURL(), RepoResponse.class).getItems();
		if (results.length > count) {
			return Arrays.copyOf(results, count);
		}
		return results;
	
	}
	
	public Account[] findUserAccount(int count) {
		Account[] results = restTemplate.getForObject(prepareUserURL(), UserAccountDetails.class).getItems();
		if (results.length > count) {
			return Arrays.copyOf(results, count);
		}
		return results;
	}
	public String prepareURL() {
		StringBuilder builder = new StringBuilder();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -7);
		builder.append(hottestRepoURL).append("?").append("q=created:" + dateFormat.format(cal.getTime()));
		builder.append("&sort=stars").append("&order=desc");
		System.out.println(builder);
		return builder.toString();
	}
	
	public String prepareUserURL() {
		StringBuilder builder = new StringBuilder();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -7);
		builder.append(usersBaseRepo).append("?").append("q=followers:0");
		builder.append("&sort=repositories").append("&order=desc");
		System.out.println(builder);
		return builder.toString();
	}
}
