
/**
 * Created by Garry Byrne
 * Student Number: C00120055
 */

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Test;

public class ByrneGarryTestTask1 {

	ArrayList<Period> discountPeriods = new ArrayList<Period>();
	ArrayList<Period> normalPeriods = new ArrayList<Period>();

	public void setup() {
		Period discountPeriod = new Period(8, 9);
		discountPeriods.add(discountPeriod);

		Period normalPeriod = new Period(10, 11);
		normalPeriods.add(normalPeriod);
	}

	// Test 1 Greater than 0
	@org.junit.Test
	public void normalRateGraterThanZero() {
		new Rate(CarParkKind.STAFF, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 2 normalRate ==0
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalRateEqualZero() {
		new Rate(CarParkKind.STAFF, new BigDecimal(0), new BigDecimal(0), discountPeriods, normalPeriods);
	}

	// Test 3 Max Value
	@org.junit.Test
	public void normalRateMaxValue() {
		new Rate(CarParkKind.STAFF, new BigDecimal(Integer.MAX_VALUE), new BigDecimal(1), discountPeriods,
				normalPeriods);
	}

	// Test 4 normalRate > discountRate
	@org.junit.Test
	public void normalRateGreaterThanDiscountRate() {
		new Rate(CarParkKind.STAFF, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 5 normalRate < discountRate
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalRateLessThanDiscountRate() {
		new Rate(CarParkKind.STAFF, new BigDecimal(1), new BigDecimal(2), discountPeriods, normalPeriods);
	}

	// Test 6 normalRate == discountRate
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalRateEqualDiscountRate() {
		new Rate(CarParkKind.STAFF, new BigDecimal(1), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 7 normalRate < 0
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalRateLessThanZero() {
		new Rate(CarParkKind.STAFF, new BigDecimal(-1), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 8 normalRate Invalid Argument
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalRateInvalidArgument() {
		new Rate(CarParkKind.STAFF, new BigDecimal("tr"), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 9 discountRate Greater than Zero
	@org.junit.Test
	public void discountRateGreaterThanZero() {
		new Rate(CarParkKind.STUDENT, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 10 discountRate Max Value-1
	@org.junit.Test
	public void discountRateMaxMinusOne() {
		new Rate(CarParkKind.STUDENT, new BigDecimal(Integer.MAX_VALUE), new BigDecimal((Integer.MAX_VALUE) - 1),
				discountPeriods, normalPeriods);
	}

	// Test 11 discountRate < 0
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void discountRateLessThanZero() {
		new Rate(CarParkKind.STUDENT, new BigDecimal(2), new BigDecimal(-2), discountPeriods, normalPeriods);
	}

	// Test 12 discountRate == 0
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void discountRateEqualZero() {
		new Rate(CarParkKind.STUDENT, new BigDecimal(2), new BigDecimal(0), discountPeriods, normalPeriods);
	}

	// Test 13 discountRate Invalid Argument
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void discountRateInvalidArgument() {
		new Rate(CarParkKind.STUDENT, new BigDecimal(2), new BigDecimal("TR"), discountPeriods, normalPeriods);
	}

	// Test 14 Kind is Valid
	@org.junit.Test
	public void kindIsValid() {
		new Rate(CarParkKind.STUDENT, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 15 normalPeriod Max
	@org.junit.Test
	public void normalPeriodMax() {
		ArrayList<Period> discountPeriods = new ArrayList<>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>() {
			{
				add(new Period(0, 24));
			}
		};
		new Rate(CarParkKind.VISITOR, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 16 normalPeriod Empty
	@org.junit.Test
	public void normalPeriodEmpty() {
		ArrayList<Period> normalPeriods = new ArrayList<>();
		ArrayList<Period> discountPeriods = new ArrayList<Period>() {
			{
				add(new Period(1, 2));
			}
		};
		new Rate(CarParkKind.VISITOR, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 17 normalPeriod Min
	@org.junit.Test
	public void normalPeriodMin() {
		ArrayList<Period> normalPeriods = new ArrayList<Period>() {
			{
				add(new Period(0, 1));
			}
		};
		ArrayList<Period> discountPeriods = new ArrayList<>();
		new Rate(CarParkKind.VISITOR, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 18 normalPeriod 3 hours
	@org.junit.Test
	public void normalPeriod3Hours() {
		ArrayList<Period> normalPeriods = new ArrayList<Period>() {
			{
				add(new Period(11, 13));
			}
		};
		ArrayList<Period> discountPeriods = new ArrayList<>();
		new Rate(CarParkKind.VISITOR, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 19 normalPeriod No Overlap
	@org.junit.Test
	public void normalPeriodNoOverlap() {
		ArrayList<Period> normalPeriods = new ArrayList<Period>() {
			{
				add(new Period(11, 13));
			}
		};
		ArrayList<Period> discountPeriods = new ArrayList<Period>() {
			{
				add(new Period(10, 11));
			}
		};
		new Rate(CarParkKind.VISITOR, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 20 normalPeriod Overlap with DiscountPeriod
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalPeriodOverlapDiscountPeriod() {
		ArrayList<Period> normalPeriods = new ArrayList<Period>() {
			{
				add(new Period(11, 13));
			}
		};
		ArrayList<Period> discountPeriods = new ArrayList<Period>() {
			{
				add(new Period(11, 12));
			}
		};
		new Rate(CarParkKind.VISITOR, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 21 normalPeriod Overlap with Itself
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalPeriodOverlapItself() {
		ArrayList<Period> normalPeriods = new ArrayList<Period>() {
			{
				add(new Period(11, 13));
				add(new Period(12, 14));
			}
		};
		ArrayList<Period> discountPeriods = new ArrayList<Period>() {
			{
				add(new Period(10, 11));
			}
		};
		new Rate(CarParkKind.VISITOR, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 22 normalPeriod Over 24 Hours(25)
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalPeriodOver24Hours() {
		ArrayList<Period> normalPeriods = new ArrayList<Period>() {
			{
				add(new Period(23, 25));
			}
		};
		ArrayList<Period> discountPeriods = new ArrayList<Period>() {
			{
				add(new Period(10, 11));
			}
		};
		new Rate(CarParkKind.VISITOR, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 23 discountPeriod Max
	@org.junit.Test
	public void discountPeriodMax() {
		ArrayList<Period> normalPeriods = new ArrayList<>();
		ArrayList<Period> discountPeriods = new ArrayList<Period>() {
			{
				add(new Period(0, 24));
			}
		};
		new Rate(CarParkKind.MANAGEMENT, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 24 discountPeriod Min
	@org.junit.Test
	public void discountPeriodMin() {
		ArrayList<Period> normalPeriods = new ArrayList<>();
		ArrayList<Period> discountPeriods = new ArrayList<Period>() {
			{
				add(new Period(0, 1));
			}
		};
		new Rate(CarParkKind.MANAGEMENT, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 25 discountPeriod 3 hours
	@org.junit.Test
	public void discountPeriod3Hours() {
		ArrayList<Period> normalPeriods = new ArrayList<>();
		ArrayList<Period> discountPeriods = new ArrayList<Period>() {
			{
				add(new Period(10, 12));
			}
		};
		new Rate(CarParkKind.MANAGEMENT, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 26 discountPeriod Empty
	@org.junit.Test
	public void discountPeriodEmpty() {
		ArrayList<Period> normalPeriods = new ArrayList<Period>() {
			{
				add(new Period(1, 2));
			}
		};
		ArrayList<Period> discountPeriods = new ArrayList<>();
		new Rate(CarParkKind.MANAGEMENT, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 27 discountPeriod No Overlap
	@org.junit.Test
	public void discountPeriodNoOverlap() {
		ArrayList<Period> normalPeriods = new ArrayList<Period>() {
			{
				add(new Period(11, 13));
			}
		};
		ArrayList<Period> discountPeriods = new ArrayList<Period>() {
			{
				add(new Period(10, 11));
			}
		};
		new Rate(CarParkKind.MANAGEMENT, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 28 discountPeriod Overlap NormalPeriod
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void discountPeriodOverlapNormalPeriod() {
		ArrayList<Period> normalPeriods = new ArrayList<Period>() {
			{
				add(new Period(11, 13));
			}
		};
		ArrayList<Period> discountPeriods = new ArrayList<Period>() {
			{
				add(new Period(11, 12));
			}
		};
		new Rate(CarParkKind.MANAGEMENT, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 29 discountPeriod Overlap Itself
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void discountPeriodOverlapItself() {
		ArrayList<Period> normalPeriods = new ArrayList<Period>() {
			{
				add(new Period(11, 13));
				add(new Period(12, 14));
			}
		};
		ArrayList<Period> discountPeriods = new ArrayList<Period>() {
			{
				add(new Period(10, 11));
			}
		};
		new Rate(CarParkKind.MANAGEMENT, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}

	// Test 30 discountPeriod Over 24 hours(25)
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void discountPeriodOver24Hours() {
		ArrayList<Period> normalPeriods = new ArrayList<Period>() {
			{
				add(new Period(10, 11));
			}
		};
		ArrayList<Period> discountPeriods = new ArrayList<Period>() {
			{
				add(new Period(23, 25));
			}
		};
		new Rate(CarParkKind.MANAGEMENT, new BigDecimal(2), new BigDecimal(1), discountPeriods, normalPeriods);
	}
}
