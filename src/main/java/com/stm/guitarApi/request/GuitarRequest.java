package com.stm.guitarApi.request;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.stm.guitarApi.model.Classification;

public class GuitarRequest  implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	@Length(max=50)
	private String model;
	
	@NotNull
	@Digits(fraction=0, integer=4)
	private Integer year;
	
	@NotNull
	private Classification classification;
	
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

	public int getYear() {
		return year;
	}

	public Classification getClassification() {
		return classification;
	}

	public String getManufacturerId() {
		return manufacturerId;
	}

	public String getBodyType() {
		return bodyType;
	}

	public String getNeckJoint() {
		return neckJoint;
	}

	public int getScaleMm() {
		return scaleMm;
	}

	public String getBodyWood() {
		return bodyWood;
	}

	public String getNeckWood() {
		return neckWood;
	}

	public String getFretboardWood() {
		return fretboardWood;
	}

	public String getBridge() {
		return bridge;
	}

	public String getPickup() {
		return pickup;
	}

	public String getImageBase64() {
		return imageBase64;
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
