package com.stm.guitarApi.model;

import java.io.Serializable;

public class Manufacturer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private String id;
	
	private String name;
	
	private String formerlyCalled;
	
	private int foundedYear;
	
	private String foundedPlace;
	
	private String founder;
	
	private String headquarters;
	
	private String areaServed;
	
	private String website;
	
	private String logoBase64;

	
	public static Manufacturer newInstance(String id, String name, String formerlyCalled, int foundedYear, String foundedPlace,
			String founder, String headquarters, String areaServed, String website, String logoBase64) {
		return new Manufacturer(id, name, formerlyCalled, foundedYear, foundedPlace, founder, headquarters,
				areaServed, website, logoBase64);
	}
	
	private Manufacturer() {}
	
	private Manufacturer(String id, String name, String formerlyCalled, int foundedYear, String foundedPlace,
			String founder, String headquarters, String areaServed, String website, String logoBase64) {
		super();
		this.id = id;
		this.name = name;
		this.formerlyCalled = formerlyCalled;
		this.foundedYear = foundedYear;
		this.foundedPlace = foundedPlace;
		this.founder = founder;
		this.headquarters = headquarters;
		this.areaServed = areaServed;
		this.website = website;
		this.logoBase64 = logoBase64;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormerlyCalled() {
		return formerlyCalled;
	}

	public void setFormerlyCalled(String formerlyCalled) {
		this.formerlyCalled = formerlyCalled;
	}

	public int getFoundedYear() {
		return foundedYear;
	}

	public void setFoundedYear(int foundedYear) {
		this.foundedYear = foundedYear;
	}

	public String getFoundedPlace() {
		return foundedPlace;
	}

	public void setFoundedPlace(String foundedPlace) {
		this.foundedPlace = foundedPlace;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public String getAreaServed() {
		return areaServed;
	}

	public void setAreaServed(String areaServed) {
		this.areaServed = areaServed;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLogoBase64() {
		return logoBase64;
	}

	public void setLogoBase64(String logoBase64) {
		this.logoBase64 = logoBase64;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Manufacturer [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", formerlyCalled=");
		builder.append(formerlyCalled);
		builder.append(", foundedYear=");
		builder.append(foundedYear);
		builder.append(", foundedPlace=");
		builder.append(foundedPlace);
		builder.append(", founder=");
		builder.append(founder);
		builder.append(", headquarters=");
		builder.append(headquarters);
		builder.append(", areaServed=");
		builder.append(areaServed);
		builder.append(", website=");
		builder.append(website);
		builder.append(", logoBase64=");
		builder.append(logoBase64);
		builder.append("]");
		return builder.toString();
	}

}
