package com.abhi.demo.pcfdemoserver.model;

public class SearchRequest {
	private int accountId;
	private String accountName;
	private String groupId;
	private String drugName;
	private String drugNDC;
	private String drugGPI;
	private String fundingType;
	private String statusCode;
	private String productType;
	private String network;
	private String client;
	private String planState;
	private String formularyType;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDrugNDC() {
		return drugNDC;
	}
	public void setDrugNDC(String drugNDC) {
		this.drugNDC = drugNDC;
	}
	public String getDrugGPI() {
		return drugGPI;
	}
	public void setDrugGPI(String drugGPI) {
		this.drugGPI = drugGPI;
	}
	public String getFundingType() {
		return fundingType;
	}
	public void setFundingType(String fundingType) {
		this.fundingType = fundingType;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getPlanState() {
		return planState;
	}
	public void setPlanState(String planState) {
		this.planState = planState;
	}
	public String getFormularyType() {
		return formularyType;
	}
	public void setFormularyType(String formularyType) {
		this.formularyType = formularyType;
	}
	
}
