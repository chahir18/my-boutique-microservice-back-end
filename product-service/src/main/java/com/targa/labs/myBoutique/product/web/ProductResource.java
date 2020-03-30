package com.targa.labs.myBoutique.product.web;
import com.targa.labs.myBoutique.commons.dto.ProductDto;
import com.targa.labs.myBoutique.product.service.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import static com.targa.labs.myBoutique.commons.utils.Web.API;
import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping(API+"/products")
public class ProductResource {
	private final ProductService productService;

	@GetMapping
	public List<ProductDto> findAll(){
		return this.productService.findAll();
	}


	@GetMapping("/category/{cat_name}")
	public List<ProductDto> findAllByCategory(@PathVariable String cat_name){
		return this.productService.findByCategory(cat_name);
	}


	@GetMapping("/{id}")
	public ProductDto findById(@PathVariable Long id) {
		return this.productService.findById(id);
	}

	@PostMapping
	public ProductDto create(ProductDto productDto) {
		return this.productService.create(productDto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.productService.findById(id);
	}




}
