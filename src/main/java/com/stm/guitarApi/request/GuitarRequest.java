package com.stm.guitarApi.request;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class GuitarRequest  implements Serializable {

	private static final String CLASSIFICATION_PATTERN = "ACOUSTIC|ELECTRIC|CLASICAL";

	private static final long serialVersionUID = 1L;

	@NotBlank
	@Length(max=50)
	private String model;
	
	@NotNull
	@Digits(fraction=0, integer=4)
	private Integer year;
	
	@NotNull
	@Pattern(regexp=CLASSIFICATION_PATTERN)
	private String classification;
	
	@NotBlank
	private String manufacturerId;
	
	@Length(max=100)
	private String bodyType;
	
	@Length(max=100)
	private String neckJoint;
	
	private int scaleMm;
	
	@Length(max=100)
	private String bodyWood;
	
	@Length(max=100)
	private String neckWood;
	
	@Length(max=100)
	private String fretboardWood;
	
	@Length(max=100)
	private String bridge;
	
	@Length(max=100)
	private String pickup;
	
	private String imageBase64;

	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public String getNeckJoint() {
		return neckJoint;
	}

	public void setNeckJoint(String neckJoint) {
		this.neckJoint = neckJoint;
	}

	public int getScaleMm() {
		return scaleMm;
	}

	public void setScaleMm(int scaleMm) {
		this.scaleMm = scaleMm;
	}

	public String getBodyWood() {
		return bodyWood;
	}

	public void setBodyWood(String bodyWood) {
		this.bodyWood = bodyWood;
	}

	public String getNeckWood() {
		return neckWood;
	}

	public void setNeckWood(String neckWood) {
		this.neckWood = neckWood;
	}

	public String getFretboardWood() {
		return fretboardWood;
	}

	public void setFretboardWood(String fretboardWood) {
		this.fretboardWood = fretboardWood;
	}

	public String getBridge() {
		return bridge;
	}

	public void setBridge(String bridge) {
		this.bridge = bridge;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GuitarRequest [model=");
		builder.append(model);
		builder.append(", year=");
		builder.append(year);
		builder.append(", classification=");
		builder.append(classification);
		builder.append(", manufacturerId=");
		builder.append(manufacturerId);
		builder.append(", bodyType=");
		builder.append(bodyType);
		builder.append(", neckJoint=");
		builder.append(neckJoint);
		builder.append(", scaleMm=");
		builder.append(scaleMm);
		builder.append(", bodyWood=");
		builder.append(bodyWood);
		builder.append(", neckWood=");
		builder.append(neckWood);
		builder.append(", fretboardWood=");
		builder.append(fretboardWood);
		builder.append(", bridge=");
		builder.append(bridge);
		builder.append(", pickup=");
		builder.append(pickup);
		builder.append(", imageBase64=");
		builder.append(imageBase64);
		builder.append("]");
		return builder.toString();
	}

}
