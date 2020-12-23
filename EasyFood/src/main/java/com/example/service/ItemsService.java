package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.model.Items;
import com.example.repository.ItemsRepository;

@Service
@Transactional
public class ItemsService {
	ItemsRepository itemsRepository;
	public ItemsService(ItemsRepository itemsRepository) {
		this.itemsRepository=itemsRepository;
	}
	public void addItems(Items items) {
		itemsRepository.save(items);		
	}
	public List<Items> getAllItemsByHno(int hno) {
		List<Items> itemsList =new ArrayList<Items>();
		for(Items items:itemsRepository.findAllByHno(hno)) {
			itemsList.add(items);
		}
		return itemsList;
	}
	

}
