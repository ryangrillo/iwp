package com.innerWorkings.models;

import java.util.List;

public class InputObject {
	private List<Job> jobs;

	public InputObject() {}

	public InputObject(List<Job> jobs) {
		super();
		this.jobs = jobs;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "InputObject [jobs=" + jobs + "]";
	}
	
	
}
