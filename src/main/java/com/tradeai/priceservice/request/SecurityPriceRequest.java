package com.tradeai.priceservice.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 

public class SecurityPriceRequest {
	
	private String stockId;
	private Double price;
	private String dateOfPrice;

}
