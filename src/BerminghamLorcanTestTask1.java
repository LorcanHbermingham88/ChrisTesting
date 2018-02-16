
/**
 * Created by Garry Byrne
 * Student Number: C00120055
 */

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Test;

public class BerminghamLorcanTestTask1 {

	ArrayList<Period> discountPeriods = new ArrayList<Period>();
	ArrayList<Period> normalPeriods = new ArrayList<Period>();
	//test 1
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void DiscountPeriodIsNull() {
		ArrayList<Period> normalPeriods = new ArrayList<Period>() {
			{
				add(new Period(10,11));
			}
		};
		ArrayList<Period> discountPeriods = new ArrayList<>();
		Rate testObj = new Rate(CarParkKind.VISITOR,new BigDecimal(5),new BigDecimal(3),null,normalPeriods);
	}
	// test 2
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void NormalPeriodIsNull() {
		ArrayList<Period> discountPeriods = new ArrayList<Period>() {
			{
				add(new Period(10,11));
			}
		};
		ArrayList<Period> normalPeriods = new ArrayList<>();
		Rate testObj = new Rate(CarParkKind.VISITOR,new BigDecimal(5),new BigDecimal(3),discountPeriods,null);
	}
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void PeriodIsNull() {
		ArrayList<Period> discountPeriods = new ArrayList<Period>() {
			{
				add(new Period(10,11));
			}
		};
		ArrayList<Period> normalPeriods = new ArrayList<>();
		Rate testObj = new Rate(CarParkKind.VISITOR,new BigDecimal(5),new BigDecimal(3),null,null);
	}


	@org.junit.Test
	public void calDiscountPeriodEmpty() {
		ArrayList<Period> normalPeriods = new ArrayList<Period>() {
			{
				add(new Period(10,11));
			}
		};
		ArrayList<Period> discountPeriods = new ArrayList<>();
		Rate newR = new Rate(CarParkKind.STUDENT,BigDecimal.valueOf(3),BigDecimal.valueOf(2), discountPeriods,normalPeriods);
		Period periodStay = new Period(0,1);
		assertEquals(BigDecimal.valueOf(0),newR.calculate(periodStay));
	}
}
