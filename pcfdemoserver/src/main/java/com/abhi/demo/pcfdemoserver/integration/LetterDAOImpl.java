package com.abhi.demo.pcfdemoserver.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abhi.demo.pcfdemoserver.model.Letter;
import com.abhi.demo.pcfdemoserver.repository.LetterRepository;

@Component
public class LetterDAOImpl implements LetterDAO {
	@Autowired
	private LetterRepository letterRepo;
	@Override
	public List<Letter> getLetters() {
		
		return letterRepo.findAll();
	}
	
}
