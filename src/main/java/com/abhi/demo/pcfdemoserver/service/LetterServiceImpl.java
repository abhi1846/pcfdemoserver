package com.abhi.demo.pcfdemoserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.demo.pcfdemoserver.integration.LetterDAO;
import com.abhi.demo.pcfdemoserver.model.Letter;

@Service
public class LetterServiceImpl implements LetterService {
	private LetterDAO letterDao;

	@Autowired
	public LetterServiceImpl(LetterDAO letterDao) {
		this.letterDao = letterDao;
	}

	@Override
	public List<Letter> getLetters() {
		return letterDao.getLetters();
	}

}
