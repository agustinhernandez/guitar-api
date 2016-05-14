package com.stm.guitarApi.request;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class ManufacturerRequest extends AbstractGuitarApiRequest {

	private static final long serialVersionUID = 1L;

	
	@NotBlank
	@Length(max=50)
	private String name;
	
	@Length(max=100)
	private String formerlyCalled;
	
	@Digits(fraction=0, integer=4)
	private Integer foundedYear;
	
	@Length(max=100)
	private String foundedPlace;
	
	@Length(max=100)
	private String founder;
	
	@Length(max=100)
	private String headquarters;
	
	@Length(max=100)
	private String areaServed;
	
	@Length(max=100)
	private String website;
	
	@Length(max=100)
	private String logoBase64;

	
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

	public Integer getFoundedYear() {
		return foundedYear;
	}

	public void setFoundedYear(Integer foundedYear) {
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
		builder.append("ManufacturerRequest [name=");
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
