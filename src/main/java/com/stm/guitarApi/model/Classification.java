package com.stm.guitarApi.model;

public enum Classification {

	ELECTRIC("Electric"),
	ACOUSTIC("Acoustic"),
	CLASICAL("Classical");
	
	private String description;

	private Classification(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
