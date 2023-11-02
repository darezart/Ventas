package com.example.demoVentas.domain.ports.spi;

import java.util.List;

import com.example.demoVentas.domain.dto.ProductDto;
import com.example.demoVentas.domain.dto.ProductInsertRequestDto;
import com.example.demoVentas.domain.dto.ProductResponseDto;

public interface ProductPersistancePort {
	
	ProductDto insertProduct(ProductInsertRequestDto productInsert);
	List<ProductResponseDto> findAll(int page, int size, String[]sort);
	ProductDto getProduct(Integer id);
	long countProdutcs();
}
