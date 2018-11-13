package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PolynomTest {

	static Polynom excepted_Polynom ; 
	static Polynom actual_Polynom;

	@BeforeEach
	void setUp() throws Exception 
	{
		excepted_Polynom = new Polynom();	
		actual_Polynom = new Polynom();	;
	}

	@Test
	void testPolynomPolynom() {
		Polynom test = new Polynom() ; 
		excepted_Polynom.add(new Monom(3,2));
		test.add(new Monom(3,2));
		actual_Polynom = new Polynom(test);
		boolean ans = actual_Polynom.equals(excepted_Polynom) ;
		if(!ans) fail("Not yet implemented");
		test.add(new Monom(3,2));
		actual_Polynom = new Polynom(test);
		ans = actual_Polynom.equals(excepted_Polynom) ;
		if(ans) fail("Not yet implemented");
	}

	@Test
	void testPolynom() {
		actual_Polynom = new Polynom() ;
		if(!actual_Polynom.isZero()) fail("Not yet implemented");
	}

	@Test
	void testPolynomString() {
		String ValidInput = "2*x + 9*x^1/2x + 9*x^0 + 0/x^3 + 4*X^";
		String[] ValidInputArray = ValidInput.split("/");
		try {
			for (int i = 0; i < ValidInputArray.length; i++) {
				actual_Polynom = new Polynom(ValidInputArray[i]);
			}
		} catch (Exception e) {
			// TODO: handle exception
			fail("Not yet implemented");
		}
	}

	@Test
	void testF() {
//		fail("Not yet implemented");
	}

	@Test
	void testAddPolynom_able() {
	//	fail("Not yet implemented");
	}

	@Test
	void testAddMonom() {
//		fail("Not yet implemented");
	}

	@Test
	void testSubstract() {
//		fail("Not yet implemented");
	}

	@Test
	void testMultiply() {
//		fail("Not yet implemented");
	}

	@Test
	void testEqualsPolynom_able() {
//		fail("Not yet implemented");
	}

	@Test
	void testIsZero() {
		actual_Polynom.add(new Monom(0,4));
		boolean ans = actual_Polynom.isZero() ; 
		if(!ans) fail("The isZero function not working well ");
		actual_Polynom = new Polynom(); 
		actual_Polynom.add(new Monom(3,1));
		ans = actual_Polynom.isZero();
		if(ans) fail("The isZero function not working well ");
	}

	@Test
	void testRoot() {
//		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
//		fail("Not yet implemented");
	}

	@Test
	void testDerivative() {
//		fail("Not yet implemented");
	}

	@Test
	void testArea() {
//		fail("Not yet implemented");
	}

	@Test
	void testZero_union() {
//		fail("Not yet implemented");
	}

	@Test
	void testIteretor() {
//		fail("Not yet implemented");
	}

	@Test
	void testToString() {
//		fail("Not yet implemented");
	}

}
