package com.tradeai.priceservice.datamodel;

import java.io.Serializable;
import java.sql.Date;





public class PriceCompositeKey implements Serializable {
	
    private String stockId;
 
    private Date dateOfPrice;
    
    public PriceCompositeKey() {
    	
    }
 
    // default constructor
 
    public PriceCompositeKey(String stockId, Date dateOfPrice) {
        this.stockId = stockId;
        this.dateOfPrice = dateOfPrice;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfPrice == null) ? 0 : dateOfPrice.hashCode());
		result = prime * result + ((stockId == null) ? 0 : stockId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceCompositeKey other = (PriceCompositeKey) obj;
		if (dateOfPrice == null) {
			if (other.dateOfPrice != null)
				return false;
		} else if (!dateOfPrice.equals(other.dateOfPrice))
			return false;
		if (stockId == null) {
			if (other.stockId != null)
				return false;
		} else if (!stockId.equals(other.stockId))
			return false;
		return true;
	}
    
    
    
 
    // equals() and hashCode()
}   




