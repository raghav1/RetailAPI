package com.myretail.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jayway.jsonpath.JsonPath;
import com.myretail.domain.Product;
import com.myretail.repository.ProductRepository;


/**
 * Created by Raghav on 9/29/2016.
 */
@RestController
@RequestMapping("/products")
public class ProductController extends BaseController {
	private final static  Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Value("${target.external.api}")
	private String externalApi;
	
	@Value("${resource.name.value}")
	private String pathName;

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product getProductDetails(@PathVariable long id) {
		logger.info("Geting information from Mongodb for productId: "  +id);
		Product product = productRepository.findOne(id);

		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(externalApi.replace("{product_id}", Long.toString(product.getId())),
				String.class);
		// response parsing for name extraction
		product.setName(JsonPath.read(response, pathName));	
		logger.info("Sending the response for productId: " +id+ " Response Body is:" +product.toString());
		return product;
	}
	// Method to update the record
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	   public Product updateProductDetails(@PathVariable long id, @RequestBody Product product){
	      product.setId(id);
	      return productRepository.save(product);
	   }
	/* To Delete the API

	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   public void deleteProduct(@PathVariable long id){
	      productRepository.delete(id);
	   }

*/
	
}
