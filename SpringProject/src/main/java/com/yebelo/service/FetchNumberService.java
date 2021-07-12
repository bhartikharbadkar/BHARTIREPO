package com.yebelo.service;

import java.util.Optional;

import com.yebelo.model.FetchNumber;

public interface FetchNumberService {

	Optional<FetchNumber> isPresent(int categorycode);

	void update(FetchNumber resultFetchNum);

}
