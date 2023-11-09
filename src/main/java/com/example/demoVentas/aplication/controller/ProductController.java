package com.example.demoVentas.aplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoVentas.domain.dto.ProductDto;
import com.example.demoVentas.domain.dto.ProductInsertRequestDto;
import com.example.demoVentas.domain.dto.ProductResponseDto;
import com.example.demoVentas.domain.ports.api.ProductServicePort;

//method = {RequestMethod.POST, RequestMethod.GET}
@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductServicePort productServicePort;
	
	@PostMapping
	public ResponseEntity<ProductDto> postProduct(@Valid @RequestBody ProductInsertRequestDto productInsertRequest){
		ResponseEntity<ProductDto> response = null;
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		ProductDto productResponse = productServicePort.insertProduct(productInsertRequest);
		
		response = new ResponseEntity<ProductDto>(productResponse, headers, HttpStatus.OK);
		
		return response;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable Integer id){
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		ProductDto productDto = productServicePort.getProduct(id);
		
		return new ResponseEntity<ProductDto>(productDto, headers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<ProductResponseDto>> getProducts(
			@RequestParam(required = false, defaultValue = "0") String page,
			@RequestParam(required = false, defaultValue = "20") String size,
			@RequestParam(required = false, defaultValue = "id,desc") String [] sort){
		
		List<ProductResponseDto> productResponseDto;
		int pageInt = Integer.valueOf(page);
		int sizeInt = Integer.valueOf(size);
		
		
		long numberRows =productServicePort.countProdutcs();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Elements", String.valueOf(numberRows));
		
		productResponseDto = productServicePort.findAll(pageInt, sizeInt, sort);
		
		return new ResponseEntity<Iterable<ProductResponseDto>>(productResponseDto, headers, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
}
