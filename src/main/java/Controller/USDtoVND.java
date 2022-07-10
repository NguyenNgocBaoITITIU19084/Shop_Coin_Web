package Controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class USDtoVND {

	public  String USDtoVND(float USD) {
		final DecimalFormat df = new DecimalFormat("0.00");
		double ChangerFixed = 22000;
		double VND = USD * ChangerFixed;
		
        return df.format(VND);
	}

}
