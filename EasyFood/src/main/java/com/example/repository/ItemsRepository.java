package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Items;

@Repository
public interface ItemsRepository extends CrudRepository<Items, Integer> {

	List<Items> findAllByHno(int hno);
}
