package com.example.demoVentas.domain.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.example.demoVentas.domain.dto.ProductDto;
import com.example.demoVentas.domain.dto.ProductInsertRequestDto;
import com.example.demoVentas.domain.dto.ProductResponseDto;
import com.example.demoVentas.domain.ports.spi.ProductPersistancePort;
import com.example.demoVentas.infrastructure.entity.Product;
import com.example.demoVentas.infrastructure.mapper.ProductMapper;
import com.example.demoVentas.infrastructure.model.ProductModel;
import com.example.demoVentas.infrastructure.repository.ProductRepository;



@Service
public class ProductJpaAdapter implements ProductPersistancePort{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ProductDto insertProduct(ProductInsertRequestDto productInsert) {
		Product product = new Product();
		ProductModel productResponse = new ProductModel();
		
		product.setName(productInsert.getName());
		product.setPrice(productInsert.getPrice());
		product.setStock(productInsert.getStock());
		
		product = productRepository.save(product);
		productResponse.setId(product.getId());
		productResponse.setName(product.getName());
		productResponse.setPrice(product.getPrice());
		productResponse.setStock(product.getStock());
		return ProductMapper.INSTANCE.productModelToProductDto(productResponse);
	}

	@Override
	public List<ProductResponseDto> findAll(int page, int size, String[] sort) {
		List<Order> orders = new ArrayList<>();
		List<Product> products = new ArrayList<>();
		
		if (sort[1].equals("desc")) {
			orders.add(new Order(Sort.Direction.DESC, sort[0]));
		}else {
			orders.add(new Order(Sort.Direction.ASC, sort[0]));
		}
		
		PageRequest paginSort = PageRequest.of(page, size, Sort.by(orders));
		
		Iterable<Product> productList = productRepository.findAll(paginSort);
		
		productList.forEach(products::add);
		
		return ProductMapper.INSTANCE.productToProductResponseDto(products);
	}

	@Override
	public long countProdutcs() {
		return productRepository.count();
	}

	@Override
	public ProductDto getProduct(Integer id) {
		Optional<Product> product = productRepository.findById(id);
		ProductModel productIdResponse = new ProductModel();
		
		productIdResponse.setId(product.get().getId());
		productIdResponse.setName(product.get().getName());
		productIdResponse.setPrice(product.get().getPrice());
		productIdResponse.setStock(product.get().getStock());
		
		return ProductMapper.INSTANCE.productModelToProductDto(productIdResponse);
	}

}
