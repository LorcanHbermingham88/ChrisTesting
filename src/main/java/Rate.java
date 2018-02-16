import java.math.BigDecimal;
import java.util.ArrayList;

public class Rate {

	CarParkKind kind;

	public Rate(CarParkKind kind, BigDecimal normalRate, BigDecimal discountedRate, ArrayList<Period> discountPeriods,
			ArrayList<Period> normalPeriods) {

		this.kind = kind;

		if ((normalRate.longValue() == 0)) {
			throw new IllegalArgumentException();
		}

		if ((normalRate.longValue() == discountedRate.longValue())) {
			throw new IllegalArgumentException();
		}

		if ((normalRate.longValue() < 0)) {
			throw new IllegalArgumentException();
		}

		if ((discountedRate.longValue() < 0)) {
			throw new IllegalArgumentException();
		}

		if ((discountedRate.longValue() == 0)) {
			throw new IllegalArgumentException();
		}

		if ((discountedRate.longValue() > normalRate.longValue())) {
			throw new IllegalArgumentException();
		}

		for (int counter = 0; counter < discountPeriods.size(); counter++) {

			Period period = discountPeriods.get(counter);
			if (period.end > 24) {
				throw new IllegalArgumentException();
			}
		}

		for (int counter = 0; counter < normalPeriods.size(); counter++) {

			Period period = normalPeriods.get(counter);
			if (period.end > 24) {
				throw new IllegalArgumentException();
			}
		}
	}
}
