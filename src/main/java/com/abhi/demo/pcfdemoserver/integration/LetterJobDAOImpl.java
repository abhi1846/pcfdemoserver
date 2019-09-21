package com.abhi.demo.pcfdemoserver.integration;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abhi.demo.pcfdemoserver.model.LetterJob;
import com.abhi.demo.pcfdemoserver.model.SearchDetails;
import com.abhi.demo.pcfdemoserver.model.SearchDetailsResponse;
import com.abhi.demo.pcfdemoserver.model.SearchRequest;
import com.abhi.demo.pcfdemoserver.repository.LetterJobRepository;

@Component
public class LetterJobDAOImpl implements LetterJobDAO {

	@Autowired
	private LetterJobRepository letterJobRepo;

	@Override
	public LetterJob saveLetterJob(SearchRequest srcRequest) {

		SearchDetails src = new SearchDetails();
		LetterJob job = new LetterJob();
		job.setLetterId(1);
		job.setStatusId(1);
		job.setCreatedBy("Pharmacy User");
		job.setCreatedOn(new Date());
		job.setUpdatedBy("Pharmacy User");
		job.setUpdatedOn(new Date());
		src.setAccountId(srcRequest.getAccountId());
		src.setGroupId(srcRequest.getGroupId());
		src.setAccountName(srcRequest.getAccountName());
		src.setDrugGPI(srcRequest.getDrugGPI());
		src.setDrugName(srcRequest.getDrugName());
		src.setDrugNDC(srcRequest.getDrugNDC());
		src.setFundingType(srcRequest.getFundingType());
		src.setStatusCode(srcRequest.getStatusCode());
		src.setProductType(srcRequest.getProductType());
		src.setNetwork(srcRequest.getNetwork());
		src.setClient(srcRequest.getClient());
		src.setPlanState(srcRequest.getPlanState());
		src.setFormularyType(srcRequest.getFormularyType());
		src.setLetterJob(job);
		job.setSearchDetails(src);

		return letterJobRepo.save(job);

	}

	@Override
	public LetterJob updateJobStatus(int jobId, int statusId) {

		Optional<LetterJob> job = letterJobRepo.findById(jobId);
		job.get().setStatusId(statusId);
		job.get().setUpdatedOn(new Date());
		return letterJobRepo.save(job.get());

	}

	@Override
	public SearchDetailsResponse getSearchDetails(int jobId) {
		SearchDetailsResponse response=new SearchDetailsResponse();
		Optional<LetterJob> job = letterJobRepo.findById(jobId);
		SearchDetails details=job.get().getSearchDetails();
		response.setLetterId(job.get().getLetterId());
		response.setAccountId(details.getAccountId());
		response.setGroupId(details.getGroupId());
		response.setAccountName(details.getAccountName());
		response.setDrugGPI(details.getDrugGPI());
		response.setDrugName(details.getDrugName());
		response.setDrugNDC(details.getDrugNDC());
		response.setFundingType(details.getFundingType());
		response.setStatusCode(details.getStatusCode());
		response.setProductType(details.getProductType());
		response.setNetwork(details.getNetwork());
		response.setClient(details.getClient());
		response.setPlanState(details.getPlanState());
		response.setFormularyType(details.getFormularyType());
		return response;
	}
}
