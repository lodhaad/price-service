package com.tradeai.priceservice.data;


import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tradeai.priceservice.datamodel.SecurityPrice;

public interface SecurityPriceRepository extends CrudRepository<SecurityPrice, String> {
	
	public SecurityPrice findByStockIdAndDateOfPrice(String stockId, Date dateOfPrice);
	
	public List<SecurityPrice> findByStockId(String stockId);

}
