package com.example.demoVentas.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoVentas.domain.dto.ProductDto;
import com.example.demoVentas.domain.dto.ProductInsertRequestDto;
import com.example.demoVentas.domain.dto.ProductResponseDto;
import com.example.demoVentas.domain.ports.api.ProductServicePort;
import com.example.demoVentas.domain.ports.spi.ProductPersistancePort;

@Service
public class ProductServiceImpl implements ProductServicePort{
	
	@Autowired
	private ProductPersistancePort productPersistancePort;
	
	public ProductServiceImpl(ProductPersistancePort productPersistancePort) {
		this.productPersistancePort = productPersistancePort;
	}

	@Override
	public ProductDto insertProduct(ProductInsertRequestDto productInsert) {
		ProductDto productDto = productPersistancePort.insertProduct(productInsert);
		return productDto;
	}

	@Override
	public List<ProductResponseDto> findAll(int page, int size, String[] sort) {
		
		return productPersistancePort.findAll(page, size, sort);
	}

	@Override
	public long countProdutcs() {
		
		return productPersistancePort.countProdutcs();
	}

	@Override
	public ProductDto getProduct(Integer id) {
		ProductDto productDto = productPersistancePort.getProduct(id);
		return productDto;
	}

}
