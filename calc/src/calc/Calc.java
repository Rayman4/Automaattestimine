package calc;

//represents reusable domain service which calculates daily salaries
public class Calc {
	// employee types
	public static final int JUNIOR = 1;
	public static final int SENIOR = 2;
	public static final int SPECIALIST = 3;
	public static final int MINHOURS = 8;
	public static final int MINSPECIALISTHOURS = 9;
	public static final int JUNIORPAYPERHOUR = 10;
	public static final int SENIORPAYPERHOUR = 15;
	public static final int SPECIALISTPAYPERHOUR = 22;
	public static final int OVERTIMEMULTIPLIER = 2;
	public static final int SPECIALISTOVERTIMEMULTIPLIER = 3;
	public static final int JUNIORBONUS = 10;
	public static final int SENIORBONUS = 20;
	public static final int SPECIALISTBONUS = 30;
	public static final int HEROBONUSHOURS = 20;

	// my crappy screen test
	public static void main(final String[] args) {
		//todo
	}

	public static int payJunior(final int hours) {
		int Sum = 0;
		if (hours > MINHOURS) { // if longer than eight hours
			Sum = JUNIORPAYPERHOUR * (hours - MINHOURS) * OVERTIMEMULTIPLIER; // double pay
			Sum += JUNIORPAYPERHOUR * MINHOURS;
		} else {
			Sum += JUNIORPAYPERHOUR * hours;
		}
		return Sum;
	}

	public static int paySenior(final int hours) {
		int Sum = 0;
		if (hours > MINHOURS) { // if longer than eight hours
			Sum = SENIORPAYPERHOUR * (hours - MINHOURS) * OVERTIMEMULTIPLIER; // double pay
			Sum += SENIORPAYPERHOUR * MINHOURS;
		} else {
			Sum += SENIORPAYPERHOUR * hours;
		}
		return Sum;
	}

	public static int paySpecialist(final int hours) {
		int Sum = 0;
		if (hours > MINSPECIALISTHOURS) { // if longer than nine hours
			Sum = SPECIALISTPAYPERHOUR * (hours - MINSPECIALISTHOURS) * SPECIALISTOVERTIMEMULTIPLIER; // triple pay after 9 hours
			Sum += SPECIALISTPAYPERHOUR * MINSPECIALISTHOURS;
		} else {
			Sum += SPECIALISTPAYPERHOUR * hours;
		}
		return Sum;
	}

	public static int pay(final int type, final int hours) {
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

	public static int payHeroBonus(int type, int hours) {
		int Sum = 0;
		if (hours > HEROBONUSHOURS) {
			switch (type) {
			case JUNIOR:
				Sum += JUNIORBONUS;
				break;
			case SENIOR:
				Sum += SENIORBONUS;
				break;
			case SPECIALIST:
				Sum += SPECIALISTBONUS;
				break;
			}
		}
		return Sum;
	}
}