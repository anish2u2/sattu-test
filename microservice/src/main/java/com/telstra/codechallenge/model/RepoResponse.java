package com.telstra.codechallenge.model;

public class RepoResponse {

	private String total_count;
	private boolean incomplete_results;
	private Repository[] items;
	public String getTotal_count() {
		return total_count;
	}
	public void setTotal_count(String total_count) {
		this.total_count = total_count;
	}
	public boolean isIncomplete_results() {
		return incomplete_results;
	}
	public void setIncomplete_results(boolean incomplete_results) {
		this.incomplete_results = incomplete_results;
	}
	public Repository[] getItems() {
		return items;
	}
	public void setItems(Repository[] items) {
		this.items = items;
	}
	
	
}
