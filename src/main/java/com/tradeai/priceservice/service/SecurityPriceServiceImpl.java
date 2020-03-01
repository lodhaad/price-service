package com.tradeai.priceservice.service;



import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradeai.priceservice.data.SecurityPriceRepository;
import com.tradeai.priceservice.datamodel.SecurityPrice;
import com.tradeai.priceservice.dto.SecurityPriceDTO;

@Service
public class SecurityPriceServiceImpl implements SecurityPriceService {
	
	@Autowired
	private SecurityPriceRepository repository; 

	@Override
	public SecurityPriceDTO getSecurityPriceForDate(String securityId, String date) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		
		java.util.Date utilDate = dateFormat.parse(date);
		



		SecurityPrice price = repository.findByStockIdAndDateOfPrice(securityId,new Date(utilDate.getTime()));
		ModelMapper mapper = new ModelMapper();
		SecurityPriceDTO priceDto = mapper.map(price, SecurityPriceDTO.class);
		return priceDto;
	}

	@Override
	public List<SecurityPriceDTO> getSecurityPrices(String securityId) {
		



		List<SecurityPrice> prices = repository.findByStockId(securityId);
		
		List <SecurityPriceDTO> pricesDTO = new ArrayList<SecurityPriceDTO>();
		
		ModelMapper mapper = new ModelMapper();
		
		
		for (SecurityPrice price: prices) {
			
			SecurityPriceDTO dto = mapper.map (price, SecurityPriceDTO.class);
			pricesDTO.add(dto);
			
		}
		
		return pricesDTO;
	}

	@Override
	public SecurityPriceDTO setNewSecurityPriceForDate(SecurityPriceDTO dto) {
		
		
		ModelMapper mapper = new ModelMapper();
		SecurityPrice price = mapper.map(dto, SecurityPrice.class);
		
		price = repository.save(price);
		
		dto = mapper.map(price,SecurityPriceDTO.class);
		
		return dto;

		
	}



}
