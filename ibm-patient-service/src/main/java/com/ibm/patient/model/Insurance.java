package com.ibm.patient.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("insurances")
public class Insurance {

	@Id
	private String insuranceId;
	private String packageName;
	private String type;
	private Double amount;

	public Insurance() {
		super();
	}

	public Insurance(String insuranceId, String packageName, String type, Double amount) {
		super();
		this.insuranceId = insuranceId;
		this.packageName = packageName;
		this.type = type;
		this.amount = amount;
	}

	public String getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", packageName=" + packageName + ", type=" + type + ", amount="
				+ amount + "]";
	}

}
