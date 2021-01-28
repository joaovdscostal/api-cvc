package br.com.cvc.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PriceDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal adult;
	private BigDecimal child;

	public BigDecimal getAdult() {
		return adult;
	}

	public void setAdult(BigDecimal adult) {
		this.adult = adult;
	}

	public BigDecimal getChild() {
		return child;
	}

	public void setChild(BigDecimal child) {
		this.child = child;
	}

	public static PriceDTO of(BigDecimal adult, BigDecimal child) {
		PriceDTO price = new PriceDTO();
		price.setAdult(adult);
		price.setChild(child);
		return price;
	}

}

