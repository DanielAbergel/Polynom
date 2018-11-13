package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonomTest extends Monom {

	static Monom excepted_Monom ; 
	static Monom actual_Monom ;

	@BeforeEach
	void setUp() throws Exception {
		this.excepted_Monom = new Monom(2,3);
		this.actual_Monom = new Monom(2,3);
	}

	@Test
	void testMonom() {
		this.actual_Monom = new Monom();
		this.excepted_Monom = new Monom(0,0);
		if(this.excepted_Monom.get_coefficient() != this.excepted_Monom.get_coefficient())
			fail("the default constructor is not working , the coefficient value isn't zero");
		if(this.excepted_Monom.get_power() != this.excepted_Monom.get_power()) 
			fail("the default constructor is not working ,the power value isn't zero ");

	}

	@Test
	void testMonomDoubleInt() {
		this.actual_Monom = new Monom(2,3);
		this.excepted_Monom = new Monom(2,3);
		if( actual_Monom.get_coefficient() !=  this.excepted_Monom.get_coefficient())
			fail("the constructor is not working , the coefficient value of  actual_Monom isn't the same as excepted_Monom");
		if(this.actual_Monom.get_power() != this.excepted_Monom.get_power()) 
			fail("the constructor is not working ,the power value isn't of actual_Monom isn't the same as excepted_Monom");
	}

	@Test
	void testMonomString() {
		String TheWrongSstr = "0.2*x^-1 1.a5 1a*x^2 x^ 5a";
		String TheOkStr = "0.2*x^1 1.5*x^3 3.0*x^2 x 5";
		String[] arrMonom = TheOkStr.split(" ");
		String[] arrMonomWrong = TheWrongSstr.split(" ");
		for (int i = 0; i < arrMonom.length; i++) {
			try { //Test a valid input
				Monom testOk = new Monom(arrMonom[i]);	
			}
			catch (Exception e)
			{
				fail("There is a valid input that not working");
			}
			try { // Test a wrong input
				Monom testWrong= new Monom(arrMonomWrong[i]);
				fail("There is a invalid input that working");
			}
			catch (Exception e)
			{

			}

		}
		/**
		 * Manual checking
		 */
		this.excepted_Monom = new Monom("2*x^3");
		if( actual_Monom.get_coefficient() !=  this.excepted_Monom.get_coefficient())
			fail("the String constructor is not working ,the coefficient value of  actual_Monom isn't the same as excepted_Monom");
		else if(this.actual_Monom.get_power() != this.excepted_Monom.get_power()) 
			fail("the String constructor is not working ,the power value of actual_Monom isn't the same as excepted_Monom");
	}

	@Test
	void testMonomMonom() {
		//		fail("Not yet implemented");
		Monom testMonom = new Monom(excepted_Monom);
		if( actual_Monom.get_coefficient() != testMonom.get_coefficient())
			fail("the copy constructor is not working , the coefficient value of actual_Monom isn't the same as testMonom");
		else if(this.actual_Monom.get_power() != testMonom.get_power()) 
			fail("the  copy constructor is not working ,the power value isn't of actual_Monom isn't the same as testMonom");
	}

	@Test
	void testDerivative() {
		double excepted_coefficient = (this.actual_Monom.get_coefficient()*this.actual_Monom.get_power());
		int excepted_power = (this.actual_Monom.get_power()-1);
		this.actual_Monom.derivative();
		if(this.actual_Monom.get_coefficient() != excepted_coefficient )
			fail("the Derivative function is not working ,the coefficient value of actual_Monom isn't the same as excepted_coefficient ");
		if(this.actual_Monom.get_power() != excepted_power)
			fail("the Derivative function is not working ,the power value of actual_Monom isn't the same as excepted_power");
	}

	@Test
	void testF() {
		double x = 3 ;
		double excepted_FValue = (this.actual_Monom.get_coefficient() * Math.pow(x, this.actual_Monom.get_power()));
		if(excepted_FValue != this.actual_Monom.f(x))
			fail("The F function is not working the f value is not as the excepted_FValue");
	}

	@Test
	void testAdd() {
		this.actual_Monom.add(new Monom(2,3));
		if(actual_Monom.get_coefficient() != 4)
			fail("The add function is not working well, the coefficient value not as the excepted value  ");
		if(actual_Monom.get_power() != 3 )
			fail("The add function is not working well, the power value not as the excepted value  ");
	}

	@Test
	void testMultiply() {
		double excepted_coefficient = this.actual_Monom.get_coefficient() * 3 ;
		int excepted_power = this.actual_Monom.get_power() + 5 ;
		this.actual_Monom.multiply(new Monom(3,5));
		if(actual_Monom.get_coefficient() != excepted_coefficient)
			fail("The Multiply function is not working well, the coefficient value not as the excepted value  ");
		if(actual_Monom.get_power() != excepted_power )
			fail("The Multiply function is not working well, the power value not as the excepted value  ");

	}

	@Test
	void testIs_equal() {
		boolean ans = this.actual_Monom.is_equal(this.excepted_Monom);
		if(!ans)
			fail("There is problem with the equal function");
	}

	@Test
	void testIs_zero() {
		this.actual_Monom = new Monom(0,3);
		boolean ans = this.actual_Monom.is_zero();
		if(!ans) fail("The Is_Zero function is not working well, coefficient is not 0") ; 
	}

	@Test
	void testGet_power() {
		if(this.actual_Monom.get_power() != 3 )
		fail("Not yet implemented");
	}

	@Test
	void testGet_coefficient() {
		if(this.actual_Monom.get_coefficient() != 2 )
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		this.actual_Monom = new Monom(this.actual_Monom.toString()); 
		if( actual_Monom.get_coefficient() !=  this.excepted_Monom.get_coefficient())
			fail("the constructor is not working , the coefficient value of  actual_Monom isn't the same as excepted_Monom");
		if(this.actual_Monom.get_power() != this.excepted_Monom.get_power()) 
			fail("the constructor is not working ,the power value isn't of actual_Monom isn't the same as excepted_Monom");
		
	}

}
