package com.abhi.demo.pcfdemoserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.demo.pcfdemoserver.integration.LetterJobDAO;
import com.abhi.demo.pcfdemoserver.model.LetterJob;
import com.abhi.demo.pcfdemoserver.model.SearchDetailsResponse;
import com.abhi.demo.pcfdemoserver.model.SearchRequest;

@Service
public class LetterJobServiceImpl implements LetterJobService {

	@Autowired
	private LetterJobDAO letterJobDao;

	@Override
	public LetterJob saveJob(SearchRequest srcRequest) {
		return letterJobDao.saveLetterJob(srcRequest);
	}

	@Override
	public LetterJob updateJobStatus(int jobId, int statusId) {
		return letterJobDao.updateJobStatus(jobId, statusId);
	}

	@Override
	public SearchDetailsResponse getSearchDetails(int jobId) {
		return letterJobDao.getSearchDetails(jobId);
	}

}
