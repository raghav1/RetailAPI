package com.myretail.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Raghav on 9/29/2016.
 */
public class ProductPrice {

    private float value;

    private String currencyCode;

   
	public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @JsonProperty("currency_code")
    public String getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("currency_code")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

	@Override
	public String toString() {
		return "ProductPrice [value=" + value + ", currencyCode=" + currencyCode + "]";
	}

	
    
}
