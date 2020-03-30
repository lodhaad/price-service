package com.tradeai.priceservice.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradeai.priceservice.datamodel.SecurityPrice;
import com.tradeai.priceservice.dto.SecurityPriceDTO;
import com.tradeai.priceservice.request.SecurityPriceRequest;
import com.tradeai.priceservice.response.SecurityPriceResponse;
import com.tradeai.priceservice.service.SecurityPriceService;

@RestController
@RequestMapping ("/price")
public class PriceController {
	
	@Autowired
	private SecurityPriceService service;
	
	
	@GetMapping (path="/health" )
	
	public String health() {
		
		return "Good health";
		
	}
	
	
	@GetMapping (path="/{stockId}/date/{dateOfPrice}" )
			


	
	public ResponseEntity<SecurityPriceResponse> getPrice(@PathVariable("stockId") String stockId, 
			@PathVariable("dateOfPrice") String dateOfPrice) throws ParseException {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		
		SecurityPriceDTO priceList = service.getSecurityPriceForDate(stockId, dateOfPrice);
		
		SecurityPriceResponse response = new SecurityPriceResponse();
		
		if (priceList != null  ) {
			
			response.setStockId(priceList.getStockId());
			response.setPrice(priceList.getPrice());
			response.setDateOfPrice( df.format(priceList.getDateOfPrice()));

			
		}
		
		else {
			
			System.out.println("nothing");
		}

		
		
		

		
		return new ResponseEntity<SecurityPriceResponse>(response, HttpStatus.OK);
		
	}
	
	
	@GetMapping (path="/{stockId}" )
	
	public ResponseEntity<List<SecurityPriceResponse>> getAllPriceForSecurity(@PathVariable("stockId") String stockId){
		

		List<SecurityPriceResponse> response = new ArrayList<SecurityPriceResponse>();
		
		List<SecurityPriceDTO> listOfPrices = service.getSecurityPrices(stockId);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		listOfPrices.stream().forEach(element -> {
			
			SecurityPriceResponse priceResponse = new SecurityPriceResponse();
			
			priceResponse.setStockId(element.getStockId());
			priceResponse.setPrice(element.getPrice());
			priceResponse.setDateOfPrice(format.format(element.getDateOfPrice()));
			response.add(priceResponse);
			
		});
		



		
		return new ResponseEntity<List<SecurityPriceResponse>>(response, HttpStatus.OK);
		
	}
	
	
	@PostMapping 

	
	public ResponseEntity<SecurityPriceResponse> savePriceForSecurityForDate(
			@RequestBody SecurityPriceRequest request){
		
		ModelMapper mapper = new ModelMapper();
		SecurityPriceDTO dto = mapper.map(request, SecurityPriceDTO.class);
		
		dto = service.setNewSecurityPriceForDate(dto);
		
		SecurityPriceResponse response = mapper.map(dto, SecurityPriceResponse.class);
		
			
		return new ResponseEntity<SecurityPriceResponse>(response, HttpStatus.OK);
		

	}
	
	
	@PostMapping ( path="/bulk")
	
	public ResponseEntity<List<SecurityPriceResponse>> savePriceForSecuritiesForAGivenDate(@RequestBody
			List<SecurityPriceRequest> listOfSecurities){
		



		



		
		//return new ResponseEntity<List<SecurityPriceResponse>>(response, HttpStatus.OK);
		
		return null;
		
	}
	
	
	
	
		
	
	

}
