package calc;

//represents reusable domain service which calculates daily salaries
public class Calc {
	// employee types
	public static final int JUNIOR = 1;
	public static final int SENIOR = 2;
	public static final int SPECIALIST = 3;

	// my crappy screen test
	public static void main(final String[] args) {
		Calc calc = new Calc();
		System.err.println(calc.pay(SPECIALIST, 3) + " should be 66");
	}

	private int payJunior(final int hours) {
		int Sum = 0;
		if (hours > 8) { // if longer than eight hours
			Sum = 10 * (hours - 8) * 2; // double pay
			Sum += 10 * 8;
		} else {
			Sum += 10 * hours;
		}
		return Sum;
	}

	private int paySenior(final int hours) {
		int Sum = 0;
		if (hours > 8) { // if longer than eight hours
			Sum = 15 * (hours - 8) * 2; // double pay
			Sum += 15 * 8;
		} else {
			Sum += 15 * hours;
		}
		return Sum;
	}

	private int paySpecialist(final int hours) {
		int Sum = 0;
		if (hours > 9) { // if longer than nine hours
			Sum = 22 * (hours - 9) * 3; // triple pay after 9 hours
			Sum += 22 * 9;
		} else {
			Sum += 22 * hours;
		}
		return Sum;
	}

	protected int pay(final int type, final int hours) {
		int Sum = 0;
		switch (type) {
		case JUNIOR:
			Sum += payJunior(hours);
			break;
		case SENIOR:
			Sum += paySenior(hours);
			break;
		case SPECIALIST:
			Sum += paySpecialist(hours);
			break;
		}
		Sum += payHeroBonus(type, hours);
		return Sum;
	}

	private int payHeroBonus(int type, int hours) {
		int Sum = 0;
		if (hours > 20) {
			switch (type) {
			case JUNIOR:
				Sum += 10;
				break;
			case SENIOR:
				Sum += 20;
				break;
			case SPECIALIST:
				Sum += 30;
				break;
			}
		}
		return Sum;
	}
}