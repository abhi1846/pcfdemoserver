package com.abhi.demo.pcfdemoserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.demo.pcfdemoserver.model.SearchDetails;

@Repository
public interface SearchDetailsRepository extends JpaRepository<SearchDetails, Integer> {

}
