package com.myretail;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.myretail.controller.ProductController;
import com.myretail.domain.Product;
import com.myretail.repository.ProductRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
//@TestPropertySource(locations="classpath:test.properties")
public class ApiControllerTests {
	
	@Autowired
    MockMvc mockMvc;
	
	@MockBean
	ProductRepository productRepository;
	
	@Test
	public void testValidURL() throws Exception{
		given(productRepository.findOne(1L)).willReturn(new Product());
		mockMvc.perform(get("/products/13860428")).andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void testWrongURL() throws Exception{
		given(productRepository.findOne(1L)).willReturn(new Product());
		mockMvc.perform(get("/prod/13860428")).andExpect(status().is4xxClientError());
	}
	
	@Test
	public void testInvalidURL() throws Exception{
		given(productRepository.findOne(1L)).willReturn(new Product());
		mockMvc.perform(get("/prod/138604215328")).andExpect(status().is4xxClientError());
	}
	

}