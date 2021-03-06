package com.braga.workshop.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.braga.workshop.domain.Address;
import com.braga.workshop.domain.User;
import com.braga.workshop.repositories.AddressRepository;
import com.braga.workshop.repositories.UserRepository;
import com.braga.workshop.services.exceptions.DataBaseException;
import com.braga.workshop.services.exceptions.ResourceNotFoundException;


@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {	
		String cep = obj.getAddress().getCep();
		Address address = addressRepository.findById(cep).orElseGet(() ->{
			Address newAddress = addressService.consultCep(cep);
			addressRepository.save(newAddress);
			return newAddress;
		});
		obj.setAddress(address);		
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try
		{
		User entity = repository.getById(id);
		updateData(entity, obj);		
		return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}

}
