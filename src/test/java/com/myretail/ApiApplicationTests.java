package com.myretail;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiApplicationTests {


	 @Autowired
	    private MockMvc mvc;
	

	 private String URI="http://localhost:8080/products/";

		@Test
	    public void getValidProductInfo() throws Exception {
	        mvc.perform(MockMvcRequestBuilders.get(URI+13860428).accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType("application/json;charset=UTF-8"))
	                .andExpect(jsonPath("$.id",notNullValue()))
	                .andExpect(jsonPath("$.name",notNullValue()))
	        .andExpect(jsonPath("$.current_price.value",notNullValue()))
	        .andExpect(jsonPath("$.current_price.currency_code",notNullValue()));
	        
	    }
	    @Test
	    public void getCorrectProductInfo() throws Exception {
	        mvc.perform(MockMvcRequestBuilders.get(URI+13860428).accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType("application/json;charset=UTF-8"))
	                .andExpect(jsonPath("$.id",is(13860428)))
	                .andExpect(jsonPath("$.name",is("The Big Lebowski (Blu-ray)")))
	    	        .andExpect(jsonPath("$.current_price.value",is(13.49)))
	    	        .andExpect(jsonPath("$.current_price.currency_code",is("USD")));
	    }
	
	
	    @Test
	    public void getInValidProductName() throws Exception {
	        mvc.perform(MockMvcRequestBuilders.get(URI+16483589).accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isNotFound());
	    }
	
	    @Test
	    public void getInCorrectProductId() throws Exception {
	        mvc.perform(MockMvcRequestBuilders.get(URI+16483589531L).accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isNoContent());
	    }


}