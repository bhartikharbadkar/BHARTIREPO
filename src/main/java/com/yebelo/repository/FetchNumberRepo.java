package com.yebelo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yebelo.model.FetchNumber;

public interface FetchNumberRepo extends JpaRepository<FetchNumber, Integer>{

	@Query("from FetchNumber f where f.categoryCode=?1 ")
	Optional<FetchNumber> existedCategoryCode(int categorycode);

}
