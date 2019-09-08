package com.abhi.demo.pcfdemoserver.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abhi.demo.pcfdemoserver.model.LetterJob;
import com.abhi.demo.pcfdemoserver.model.SearchDetailsResponse;
import com.abhi.demo.pcfdemoserver.model.SearchRequest;
import com.abhi.demo.pcfdemoserver.service.LetterJobService;

@RestController
@RequestMapping("/api")
public class LetterJobController {
	@Autowired
	private LetterJobService letterJobService;
	
	@PostMapping("/jobs")
	public ResponseEntity<Object> saveJob(@RequestBody SearchRequest srcRequest) {
		LetterJob savedSearch=letterJobService.saveJob(srcRequest);
		URI location=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedSearch.getLetterId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@PutMapping("/jobs/{jobId}/{statusId}")
	public ResponseEntity<Object> updateJobStatus(@PathVariable("jobId") String jobId, @PathVariable("statusId") String statusId) {
		LetterJob savedSearch=letterJobService.updateJobStatus(Integer.parseInt(jobId),Integer.parseInt(statusId));
		URI location=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("")
				.buildAndExpand(savedSearch.getLetterId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/jobs/{jobId}")
	public ResponseEntity<SearchDetailsResponse> getSearchDetails(@PathVariable("jobId") String jobId) {
		SearchDetailsResponse details=letterJobService.getSearchDetails(Integer.parseInt(jobId));
		if(details==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(details,HttpStatus.FOUND);
	}
	
}
