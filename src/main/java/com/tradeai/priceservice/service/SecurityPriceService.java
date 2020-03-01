package com.tradeai.priceservice.service;





import java.text.ParseException;
import java.util.List;

import com.tradeai.priceservice.datamodel.SecurityPrice;
import com.tradeai.priceservice.dto.SecurityPriceDTO;


public interface SecurityPriceService {
	
	public SecurityPriceDTO getSecurityPriceForDate (String securityId, String date) throws ParseException;
	
	public List<SecurityPriceDTO> getSecurityPrices(String securityId);
	
	public SecurityPriceDTO setNewSecurityPriceForDate(SecurityPriceDTO dto); 
	

}
