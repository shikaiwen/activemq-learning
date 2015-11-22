package activemq;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberTest {

	// 60 ·ÖÈó
	public static void main(String[] args) {
		
		
		BigDecimal USD_TO_RMB = new BigDecimal(6.13);
		BigDecimal RMB_TO_USD = new BigDecimal(1).divide(USD_TO_RMB).setScale(2, RoundingMode.HALF_UP);
		
//		BigDecimal result = new BigDecimal(6000).multiply(new BigDecimal(6.13)).setScale(0, RoundingMode.HALF_DOWN);
		
//		long longVal = new BigDecimal(60 *1000).multiply(RMB_TO_USD).setScale(0, RoundingMode.HALF_DOWN).longValue();
//		System.out.println(longVal);
		
//		double a = 0.06;
//		System.out.println(a + 0.01);
	}
}
