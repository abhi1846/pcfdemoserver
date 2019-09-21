package com.abhi.demo.pcfdemoserver.service;

import com.abhi.demo.pcfdemoserver.model.LetterJob;
import com.abhi.demo.pcfdemoserver.model.SearchDetailsResponse;
import com.abhi.demo.pcfdemoserver.model.SearchRequest;

public interface LetterJobService {

	LetterJob saveJob(SearchRequest srcRequest);

	LetterJob updateJobStatus(int jobId, int statusId);

	SearchDetailsResponse getSearchDetails(int jobId);

}
