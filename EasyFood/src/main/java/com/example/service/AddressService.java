package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.model.Address;
import com.example.model.Hotel;
import com.example.repository.AddressRepository;

@Service
@Transactional
public class AddressService {
	AddressRepository addressRepository;

	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	public List<Address> getAllAddresses(String username) {
		List<Address> list = new ArrayList<Address>();
		for (Address address : addressRepository.findAllByUsername(username)) {
			list.add(address);
		}
		return list;
	}

	public void addAddress(Address a) {
		addressRepository.save(a);
	}

	public void deleteAllAddresses() {
		addressRepository.deleteAll();
	}

	public Address getAddressByAno(int ano) {
	return addressRepository.findByAno(ano);
	}

}
