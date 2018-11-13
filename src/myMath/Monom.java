package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 *
 *@author Netanel Ben-Isahar 204478150
 *@author Daniel Abargel 315660712
 *
 */
public class Monom implements function{
	/**
	 *  default constructor
	 *  make a zeroMonom
	 */
	public Monom() {
		this(0,0);
	}
	/**
	 * constructor
	 * @param a Represents the coefficient
	 * @param b Represents the power
	 */

	public Monom(double a, int b){

		this.set_coefficient(a);
		this.set_power(b);
	}
	/**
	 * 
	 * 
	 * There will be an Exception when the input doesn't from the format coefficient*x^power (if the power/coefficient It will not be written 1 but an empty field)
	 * Explanation : The function accepts a string, and checks whether the string contains the 'x' character.
	 * Depending on whether the 'x' character is present or not, the function adds a complement by the  format.
	 * Then, it runs the split function on the string.
	 * And calculates the coefficient, and the power and And with the values received monom creates
	 * @param s Represents the monom is written as a string
	 */
	public Monom(String s)
	{
		s = s.toUpperCase();
		if(s.contains("X")&&s.charAt(s.length()-1)!='X'&&!s.contains("^"))
			throw new RuntimeException("you put invalid string that present a polynom");
		if((s.contains("X"))&&(s.indexOf("X")>1)&&(s.charAt(s.indexOf("X")-1)!='*'))
			throw new RuntimeException("you put invalid string that present a polynom");
		if(!s.contains("X"))
		{
			s=s+"*X^0";
		}
		else
			if(s.indexOf("X")==0)
				s="1*"+s;
			else
				if(s.indexOf("X")==1)
					s=s.charAt(0)+"1*"+s.substring(1);
		if(s.charAt(s.length()-1)=='X')
			s=s+"^1";
		String [] sec_split=s.split("X");
		double coefficient = Double.parseDouble(sec_split[0].substring(0, sec_split[0].length()-1));
		int power = Integer.parseInt(sec_split[1].substring(1));
		if(power<0)
		{
			throw new RuntimeException("power cannot be a negative number");

		}

		this.set_coefficient(coefficient);
		this.set_power(power);

	}
	/**
	 * 
	 * deep copy constructor
	 * @param ot Represents a Monom that we want to copy
	 */

	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	/**
	 * doing the derivative  on the Monom.
	 */

	public void derivative()
	{
		this._coefficient=this._power*this._coefficient;
		this._power=this._power-1;
	}
	/**
	 * @param x Represents the x axis position
	 * @return The function value in x position
	 */

	@Override
	public  double f(double x)
	{
		return this._coefficient*Math.pow(x, this._power);
	}
	/**
	 * this function adding a monom to the current monom. 
	 * If powers are not equal, an error message will be printed
	 * @param mon1 Represents the monom that we want to add to the monom.
	 * 
	 */

	public void add(Monom mon1)
	{
		if(this._power==mon1._power)
			this._coefficient=this._coefficient+mon1._coefficient;
		else
			System.out.println("you can't add 2 monoms with different power");
	}
	/**
	 *  Multiplication between monoms.
	 * @param mon1 Represents the monom that we want to multiply to the monom on which we work
	 *
	 */
	public void multiply(Monom mon1)
	{
		this._coefficient=this._coefficient*mon1._coefficient;
		this._power=this._power+mon1._power;
	}
	/**
	 * 
	 * @param a Represents the monum that we want to compare to the monom we work on.
	 * @return true if there equal , otherwise false .
	 */
	public boolean is_equal(Monom a)
	{
		if(this.get_coefficient()!=a.get_coefficient()||this.get_power()!=a.get_power())
			return false;
		return true;
	}
	/**
	 * Check if this is the ZeroMonom
	 * @return true if its the ZeroMonom ,otherwise false
	 */
	public boolean is_zero()
	{
		return(this._coefficient==0);
	}


	//****************** Private Methods and Data *****************

	public int get_power() {
		// TODO Auto-generated method stub

		return this._power;
	}
	public double get_coefficient() {
		// TODO Auto-generated method stub
		return this._coefficient;
	}
	private void set_coefficient(double a){


		this._coefficient = a;
	}
	/**
	 *	if the power lower than zero , throw's RuntimeException
	 * @param p Represents the power of the monom
	 */
	private void set_power(int p) {
		if(p<0)
		{
			throw new RuntimeException("power cannot be a negative number");

		}
		this._power = p;
	}

	private double _coefficient; 
	private int _power;

	public String toString() {
		return this._coefficient + "*X^" + this._power ;
	}
} 

