package com.stm.guitarApi.model;

import java.io.Serializable;

public class Guitar implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private String id;
	
	private String model;
	
	private int year;
	
	private Classification classification;
	
	private Manufacturer manufacturer;
	
	private String bodyType;
	
	private String neckJoint;
	
	private int scaleMm;
	
	private String bodyWood;
	
	private String neckWood;
	
	private String fretboardWood;
	
	private String bridge;
	
	private String pickup;
	
	private String imageBase64;

	
	public static Guitar newInstance(String model, int year, Classification classification, Manufacturer manufacturer,
			String bodyType, String neckJoint, int scaleMm, String bodyWood, String neckWood, String fretboardWood,
			String bridge, String pickup, String imageBase64) {
		return new Guitar(model, year, classification, manufacturer, bodyType, neckJoint, scaleMm, bodyWood, 
				neckWood, fretboardWood, bridge, pickup, imageBase64);
	}
	
	private Guitar() {}
	
	private Guitar(String model, int year, Classification classification, Manufacturer manufacturer,
			String bodyType, String neckJoint, int scaleMm, String bodyWood, String neckWood, String fretboardWood,
			String bridge, String pickup, String imageBase64) {
		super();
		this.model = model;
		this.year = year;
		this.classification = classification;
		this.manufacturer = manufacturer;
		this.bodyType = bodyType;
		this.neckJoint = neckJoint;
		this.scaleMm = scaleMm;
		this.bodyWood = bodyWood;
		this.neckWood = neckWood;
		this.fretboardWood = fretboardWood;
		this.bridge = bridge;
		this.pickup = pickup;
		this.imageBase64 = imageBase64;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
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
		builder.append("Guitar [id=");
		builder.append(id);
		builder.append(", model=");
		builder.append(model);
		builder.append(", year=");
		builder.append(year);
		builder.append(", classification=");
		builder.append(classification);
		builder.append(", manufacturer=");
		builder.append(manufacturer);
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
