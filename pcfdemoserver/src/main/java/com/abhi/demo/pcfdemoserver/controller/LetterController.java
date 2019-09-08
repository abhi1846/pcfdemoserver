package com.abhi.demo.pcfdemoserver.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.demo.pcfdemoserver.model.Letter;
import com.abhi.demo.pcfdemoserver.service.LetterService;

@RestController
@RequestMapping("/api")
@ResponseBody
@CrossOrigin(origins="*")
public class LetterController {

	Logger logger=LoggerFactory.getLogger(LetterController.class);
	private final LetterService letterService;
	
	@Autowired
	public LetterController(LetterService letterService) {
		this.letterService=letterService;
	}
	
	@RequestMapping("/letters")
	public ResponseEntity<List<Letter>> getLetters(){
		logger.info("Invoking the getLetters Service.");
		List<Letter> letters=letterService.getLetters();
		if(letters==null) {
			logger.error("No Letters found");
			return new ResponseEntity<List<Letter>>(HttpStatus.NOT_FOUND);
		}

			return new ResponseEntity<>(letters,HttpStatus.OK);
		
		
	}
}
