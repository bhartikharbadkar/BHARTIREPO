package com.yebelo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yebelo.model.FetchNumber;
import com.yebelo.repository.FetchNumberRepo;

@Service
public class FectchNumberServiceImpl implements FetchNumberService{

	@Autowired
	FetchNumberRepo fetchNumRepo;
	
	@Override
	public Optional<FetchNumber> isPresent(int categorycode) {
		return fetchNumRepo.existedCategoryCode(categorycode);
	}

	@Override
	public void update(FetchNumber resultFetchNum) {
		fetchNumRepo.save(resultFetchNum);
	}

}
