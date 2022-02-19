package com.braga.workshop.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.braga.workshop.domain.Address;

@FeignClient( name = "viacep", url = "https://viacep.com.br/ws")
public interface AddressService {
	
	@RequestMapping ( method = RequestMethod.GET, value = "/{cep}/json/")	
	Address consultCep(@PathVariable("cep") String cep);

}
