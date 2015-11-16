package calc;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTest {

	@Test
	public void JuniorTests() {
		assertEquals(60, Calc.pay(1, 6));
		assertEquals(120, Calc.pay(1, 10));
		assertEquals(350, Calc.pay(1, 21));
	}
	
	@Test
	public void SeniorTests() {
		assertEquals(90, Calc.pay(2, 6));
		assertEquals(180, Calc.pay(2, 10));
		assertEquals(530, Calc.pay(2, 21));
	}

	@Test
	public void SpecialistTests() {
		assertEquals(132, Calc.pay(3, 6));
		assertEquals(264, Calc.pay(3, 10));
		assertEquals(1020, Calc.pay(3, 21));
	}
}
