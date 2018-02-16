import java.util.ArrayList;
import java.math.BigDecimal;

/**
 * Created by Garry Byrne on 08/02/2018. Student Number: C00120055
 */

public class Period {

	int start;
	int end;

	Period(int start, int end) {
		setStart(start);
		setEnd(end);
	}

	boolean overlaps(ArrayList<Period> discountPeriods, ArrayList<Period> normalPeriods) {

		ArrayList<Integer> overLaps = new ArrayList<Integer>();
		for (int counter = 0; counter < normalPeriods.size(); counter++) {
			Period period = (Period) normalPeriods.get(counter);
			overLaps.add(period.start);
			while ((period.start < period.end)) {
				overLaps.add(period.start + 1);
			}

			overLaps.add(period.end);
		}

		return true;
	}

	public int duration() {
		return this.end - this.start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}