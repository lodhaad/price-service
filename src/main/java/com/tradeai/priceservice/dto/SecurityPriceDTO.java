package com.tradeai.priceservice.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class SecurityPriceDTO {
	
	private String stockId;
	private Double price;
	private Date dateOfPrice;

}
