package com.example.demoVentas.domain.ports.api;

import java.util.List;

import com.example.demoVentas.domain.dto.ProductDto;
import com.example.demoVentas.domain.dto.ProductInsertRequestDto;
import com.example.demoVentas.domain.dto.ProductResponseDto;

public interface ProductServicePort {
	
	ProductDto insertProduct(ProductInsertRequestDto productInsert);
	List<ProductResponseDto> findAll(int page, int size, String[]sort);
	ProductDto getProduct(Integer id);
	long countProdutcs();
	
}
