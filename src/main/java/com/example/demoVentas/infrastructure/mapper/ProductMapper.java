package com.example.demoVentas.infrastructure.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demoVentas.domain.dto.ProductDto;
import com.example.demoVentas.domain.dto.ProductResponseDto;
import com.example.demoVentas.infrastructure.entity.Product;
import com.example.demoVentas.infrastructure.model.ProductModel;

@Mapper
public interface ProductMapper {
	
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	ProductDto productModelToProductDto(ProductModel productModel);
	
	List<ProductResponseDto> productToProductResponseDto(List<Product> productLit);
	
}
