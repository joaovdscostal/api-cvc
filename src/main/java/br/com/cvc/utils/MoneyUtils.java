package br.com.cvc.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyUtils {

	public static BigDecimal multiply(BigDecimal valueUnitByAdult, Integer travelDays) {
		return valueUnitByAdult.multiply(new BigDecimal(travelDays));
	}

	public static BigDecimal applyComission(BigDecimal valueTotalByAdult, BigDecimal comission) {
		return valueTotalByAdult.divide(comission, RoundingMode.HALF_UP);
	}

}
