package com.abhi.demo.pcfdemoserver.integration;

import com.abhi.demo.pcfdemoserver.model.LetterJob;
import com.abhi.demo.pcfdemoserver.model.SearchDetailsResponse;
import com.abhi.demo.pcfdemoserver.model.SearchRequest;

public interface LetterJobDAO {

	LetterJob saveLetterJob(SearchRequest srcRequest);

	LetterJob updateJobStatus(int jobId, int statusId);

	SearchDetailsResponse getSearchDetails(int jobId);

}
