package myMathTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myMath.Monom;
import myMath.Polynom;
import myMath.Polynom_able;
/**
 *@author Netanel-Ben-Isahar
 *@author Daniel Abergel
 * This class is JUnit testing for Polynom class . 
 */
class PolynomTest {

	private static Polynom excepted_Polynom ; 
	private static Polynom actual_Polynom;

	@BeforeEach
	void setUp() throws Exception 
	{
		excepted_Polynom = new Polynom();	
		actual_Polynom = new Polynom();	
	}
	/**
	 * test Polynom(Polynom) constructor 
	 * valid and invalid inputs.
	 */
	@Test
	void testPolynomPolynom() {
		Polynom test = new Polynom() ; 
		excepted_Polynom.add(new Monom(3,2));
		test.add(new Monom(3,2));
		actual_Polynom = new Polynom(test);
		boolean ans = actual_Polynom.equals(excepted_Polynom) ;
		if(!ans) fail("testing vaild input Polynom(Polynom)");
		test.add(new Monom(3,2));
		actual_Polynom = new Polynom(test);
		ans = actual_Polynom.equals(excepted_Polynom) ;
		if(ans) fail("testing invaild input Polynom(Polynom)");
	}

	@Test
	void testPolynom() {
		actual_Polynom = new Polynom() ;
		if(!actual_Polynom.isZero()) fail("Polynom() constructor not working");
	}

	/**
	 * testing Polynom(String) constructor 
	 * in the test , there is 2 inputs , valid polynoms and invalid polynoms inputs.
	 * the test check 2  strings one is represent a valid inputs , and the other invalid inputs.
	 * then split with the char '/' , and check if the string its working and make a polynom .
	 * otherwise its fail 
	 */
	@Test
	void testPolynomString() {
		String ValidInput = "2*x + 9*x^1/9*x + 9*x^0 + 0/x^3 + 4*X^-0 + 9*x^2/-3*x - 9*x - 4"; // valid inputs
		String[] ValidInputArray = ValidInput.split("/");

		for (int i = 0; i < ValidInputArray.length; i++) {
			try 
			{
				actual_Polynom = new Polynom(ValidInputArray[i]);
			}
			catch (Exception e) 
			{
				fail("testing vaild input Polynom(String)");
			}
		}
		String inValidInput = "2*x^-1 + 9*x^1/9*xx + 9*x^0 + 0/x^3 + 4*X^0 + 9*x^2 + a/-3*xa"; // invalid inputs
		String[] inValidInputArray = inValidInput.split("/");
		for (int i = 0; i < inValidInputArray.length; i++) {
			try 
			{
				actual_Polynom = new Polynom(inValidInputArray[i]);
				fail("testing invaild input Polynom(String)");
			}
			catch (Exception e) 
			{

			}
		}
		//checking toString 
		excepted_Polynom = new Polynom();
		excepted_Polynom.add(new Monom(3,2));
		excepted_Polynom.add(new Monom(-3,3));
		try {
			actual_Polynom = new Polynom(excepted_Polynom.toString());}
		catch (Exception e) {
			fail("toString test not working well ");
		};
	}
	/**
	 * testing F function with the web site :  https://www.symbolab.com/
	 */
	@Test
	void testF() {
		actual_Polynom = new Polynom(); 
		actual_Polynom.add(new Monom(1,0));
		if (actual_Polynom.f(22) != 1)  fail("F() not working well"); // test a number polynom (exsample y = 1 )
		actual_Polynom.add(new Monom(1,3));
		if (actual_Polynom.f(10) != 1001)  fail("F() not working well"); 
		actual_Polynom = new Polynom(); 
		if(actual_Polynom.f(3) != 0) fail("F() not working well"); // test zero polynom
	}
	
	/**
	 * testing add(Polynom_able) 
	 */
	@Test
	void testAddPolynom_able() {
		actual_Polynom = new Polynom("2*x^3 + 3*x^1 - 4");
		Polynom test =new Polynom("3*x^1 + 4");
		excepted_Polynom=new Polynom("2*x^3 + 6*x^1");
		actual_Polynom.add(test);
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Add(Polynom_able) not working well");
		actual_Polynom = new Polynom("2*x^3 + 3*x^1 - 4");
		test=new Polynom("3*x^4");
		excepted_Polynom=new Polynom("3*x^4 + 2*x^3 + 3*x^1 - 4");
		actual_Polynom.add(test);
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Add(Polynom_able) not working well");
	}
	/**
	 * testing add(Monom) 
	 */
	@Test
	void testAddMonom() {
		actual_Polynom = new Polynom("2*x^3 + 3*x^1 - 4");
		Monom test =new Monom("3*x^1");
		excepted_Polynom=new Polynom("2*x^3 + 6*x^1 - 4");	
		actual_Polynom.add(test);
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Add(Monom) not working well");
		actual_Polynom = new Polynom("2*x^3 + 3*x^1 - 4");
		test=new Monom("3*x^4");
		excepted_Polynom=new Polynom("3*x^4 + 2*x^3 + 3*x^1 - 4");
		actual_Polynom.add(test);
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Add(Monom) not working well");
	}
	/**
	 * testing Subtract(Polynom) 
	 */
	@Test
	void testSubstract() {
		actual_Polynom = new Polynom("2*x^3 + 3*x^1 - 4");
		Polynom test =new Polynom("3*x^1 - 4");
		excepted_Polynom=new Polynom("2*x^3");	
		actual_Polynom.substract(test);
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Substract(Polynom) not working well");
		actual_Polynom = new Polynom("2*x^3 + 3*x^1 - 4");
		test=new Polynom("3*x^4 - 2*x^1");
		excepted_Polynom=new Polynom("-3*x^4 + 2*x^3 + 5*x^1 - 4");
		actual_Polynom.substract(test);
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Substract(Polynom) not working well");	
		}
	
	/**
	 * testing Multiply(Polynom) 
	 */
	@Test
	void testMultiply() {
		actual_Polynom = new Polynom("3*X^4 - 1*X^3 + 1*X^2 - 5");
		Polynom test =new Polynom("-1*X^2 + 5");
		excepted_Polynom=new Polynom("-3*X^6 + 1*X^5 + 14*X^4 - 5*X^3 + 10*X^2 - 25");	
		actual_Polynom.multiply(test);
		if(!actual_Polynom.equals(excepted_Polynom))
			fail(" Multiply(Polynom) not working well");

	}
	/**
	 * testing Equals(Polynom_able) 
	 */
	@Test
	void testEqualsPolynom_able() {
		actual_Polynom = new Polynom("3*X^4 - 1*X^3 + 1*X^2 - 5");	
		excepted_Polynom=new Polynom("3*X^4 - 1*X^3 + 1*X^2 - 5");	
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Equals(Polynom_able)  not working well");
		excepted_Polynom=new Polynom("3*X^4 - 1*X^3 + 1*X^2 + 5");
		if(actual_Polynom.equals(excepted_Polynom))
			fail("Equals(Polynom_able)  not working well");
	}
	/**
	 * testing Is_Zero() 
	 */
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
	/**
	 * testing Root function with the web site :  https://www.symbolab.com/
	 * 
	 */
	@Test
	void testRoot() {
		actual_Polynom.add(new Monom(1,2));
		actual_Polynom.add(new Monom(-4,0)); // x^2 -4 ---- >> the roots is -2 / +2
		double RootPositive = actual_Polynom.root(0, 3, 0.001);
		double RootNegative = actual_Polynom.root(-3, 0, 0.001);
		RootNegative = Math.abs(RootNegative);
		assertEquals(RootPositive, RootNegative);

	}
	/**
	 * testing copy() 
	 */
	@Test
	void testCopy() {
		Polynom_able returnedPolynom = new Polynom();
		returnedPolynom = actual_Polynom.copy();
		boolean ans = returnedPolynom.isZero();
		if(!ans)fail("Copy() not working well");

	}
	/**
	 * testing Derivative() function with the web site :  https://www.symbolab.com/ 
	 */
	@Test
	void testDerivative() {
		actual_Polynom = new Polynom("3*X^4 - 1*X^3 + 1*X^2 - 5");	
		actual_Polynom.derivative();
		excepted_Polynom=new Polynom("12*X^3 - 3*X^2 + 2*X^1");
		if(!actual_Polynom.equals(excepted_Polynom))
			fail("Derivative() not working well");
	}
	/**
	 * testing area() function with the web site :  https://www.symbolab.com/ 
	 */
	@Test
	void testArea() {
		actual_Polynom = new Polynom("3*X^4 - 1*X^3 + 1*X^2 - 5");
		if(actual_Polynom.area(0, 4, 0.0001)!=556.1711343900323)
			fail("area() not working well");

	}
	/**
	 * testing union() 
	 * checking if its union zeros after derivative couples time.
	 */
	@Test
	void testZero_union() {
		actual_Polynom = new Polynom("3*X^4 - 1*X^3 + 1*X^2 - 5");
		excepted_Polynom=new Polynom("0");

		if(!actual_Polynom.derivative().derivative().derivative().derivative().derivative().equals(excepted_Polynom))
			fail("Zero_union() not working well");
	}

}