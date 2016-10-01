package com.myretail.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

/**
 * Created by Raghav on 9/29/2016.
 */
public class Product {



	@Id
    private long id;

    @Transient
    private String name;

    private ProductPrice currentPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("current_price")
    public ProductPrice getCurrentPrice() {
        return currentPrice;
    }

    @JsonProperty("current_price")
    public void setCurrentPrice(ProductPrice currentPrice) {
        this.currentPrice = currentPrice;
    }

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", currentPrice=" + currentPrice + "]";
	}

	

	
    
    
}
