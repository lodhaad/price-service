package com.tradeai.priceservice.response;






public class SecurityPriceResponse {
	
	private String stockId;
	private Double price;
	private String dateOfPrice;
	
	
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDateOfPrice() {
		return dateOfPrice;
	}
	public void setDateOfPrice(String dateOfPrice) {
		this.dateOfPrice = dateOfPrice;
	}
	
	

}
