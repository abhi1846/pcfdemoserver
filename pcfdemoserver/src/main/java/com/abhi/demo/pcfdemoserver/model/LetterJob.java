package com.abhi.demo.pcfdemoserver.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class LetterJob {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobId;
	private int letterId;
	private int statusId;
	private String createdBy;
	private String updatedBy;
	private Date createdOn;
	private Date updatedOn;
	
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="letterJob")
	//@JoinColumn(name ="JOB_ID")
	private SearchDetails searchDetails;
	
	public LetterJob() {
		
	}
	

	public LetterJob(int letterId, int statusId, String createdBy, String updatedBy, Date createdOn,
			Date updatedOn) {
		super();
		this.letterId = letterId;
		this.statusId = statusId;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}


	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getLetterId() {
		return letterId;
	}

	public void setLetterId(int letterId) {
		this.letterId = letterId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}


	public SearchDetails getSearchDetails() {
		return searchDetails;
	}


	public void setSearchDetails(SearchDetails searchDetails) {
		this.searchDetails = searchDetails;
	}

}
