package myMath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Netanel Ben-Isahar 204478150
 * @author Daniel Abargel 315660712
 *
 */

public class Polynom implements Polynom_able{

	private ArrayList<Monom> monomList;
	/**
	 * copy constructor
	 * @param p Represents Polynom On which we want to make the copy.
	 * 
	 */
	public Polynom(Polynom p) 
	{
		Polynom copyP=new Polynom();
		Iterator <Monom> itercopyP = p.iteretor();
		while(itercopyP.hasNext())
		{
			Monom temp=itercopyP.next();
			copyP.add(new Monom(temp.get_coefficient(),temp.get_power()));
		}
		this.monomList = copyP.monomList ;
	}

	/** 
	 * this constructor is the default constructor it build a new polynom and add the zero polynom to it
	 * 
	 */
	public Polynom()
	{
		this.monomList=new ArrayList<Monom>() ;
		this.monomList.add(new Monom(0,0));
	}
	/** 
	 * 
	 *this constructor is getting a string like f(x) = a_1*X^b_1 + a_2*X^b_2 ... a_n*Xb_n than presents a polynom.
	 *it deals with many kind of cases of polynoms and throw exceptions when it gets invalid strings.
	 * @param s represent a polynom that written as a string
	 */
	public Polynom(String s)
	{
		s=s.toUpperCase();
		this.monomList=new ArrayList<Monom>() ;
		String [] first_split =s.split (" ");
		this.monomList.add(new Monom(first_split[0]));
		for(int i=1;i<first_split.length;i=i+2)
		{
			this.add(new Monom(first_split[i]+first_split[i+1]));
		}
		this.monomList.add(new Monom(0,0));
		this.zero_union();
	}

	/**
	 * 
	 * this function is getting an argument x calculate the polynom with that x.
	 * @param x represent the x axis position
	 */
	public double f(double x) {
		double sum=0;
		Iterator<Monom> iterMon=iteretor();
		while(iterMon.hasNext())
		{
			Monom temp= iterMon.next();
			sum=sum+temp.f(x);
		}
		return sum;
	}
	/**
	 * 
	 * this function is adding the argument polynom to the current polynom.
	 * @param p1 represent the polynom that we want to add to the current polynom
	 */
	@Override
	public void add(Polynom_able p1) {
		// TODO Auto-generated method stub
		Iterator<Monom> iterP1=p1.iteretor();
		while(iterP1.hasNext())
		{
			Monom temp= iterP1.next();
			this.add(temp);
		}

	}
	/**
	 *
	 * this function adding a monom to the polynom. 
	 * if the polynom alredy has a monom with the same power as in the argument monom it adding it together.
	 * in the end of the function it sort the polynom by the power and make a zero union.
	 *  @param m1 represnt the monom that we want to add to our polynom.
	 */
	@Override
	public void add(Monom m1) {
		// TODO Auto-generated method stub
		Monom_Comperator comp=new Monom_Comperator();
		Iterator<Monom> iterMon=this.iteretor();
		while(iterMon.hasNext())
		{
			Monom temp=iterMon.next();

			if (comp.compare(temp, m1)==0)
			{
				temp.add(m1);
				this.monomList.sort(comp);
				this.zero_union();
				return;
			}

		}

		this.monomList.add(new Monom(m1));
		this.monomList.sort(comp);
		this.zero_union();

	}
	/**
	 * 
	 * this function is substruct the argument polynom from the current polynom.
	 * it substruct by multiple every monom with -1 and then adding with the add(monom)
	 * function.
	 * @param p1 represent the polynom that we want to substract to the current polynom
	 */
	@Override
	public void substract(Polynom_able p1) 
	{
		// TODO Auto-generated method stub
		Iterator <Monom> iterP1=p1.iteretor();
		while(iterP1.hasNext())
		{
			Monom tempP1=iterP1.next();
			this.add(new Monom(-1*tempP1.get_coefficient(),tempP1.get_power()));
		}

		this.zero_union();

	}

	/**
	 * 
	 * this function is multiply two polynoms by multiplyevery two monoms and setting it in a new polynom.
	 * in the and of the function we changing the pointer of this polynom to the address of the new polynom.
	 * @param p1  represent the polynom that we want to multiply with the current polynom
	 */
	@Override
	public void multiply(Polynom_able p1) {
		// TODO Auto-generated method stub
		Iterator <Monom> iterCurrent=this.iteretor();
		Iterator <Monom> iterP1=p1.iteretor();
		Polynom result=new Polynom();
		while(iterCurrent.hasNext())
		{
			Monom tempCurrent=iterCurrent.next();
			iterP1=p1.iteretor();
			while(iterP1.hasNext())
			{
				Monom tempP1=iterP1.next();
				result.add(new Monom(tempCurrent.get_coefficient()*tempP1.get_coefficient(),tempCurrent.get_power()+tempP1.get_power()));

			}
		}
		this.monomList=result.monomList;
	}
	/**
	 *  this function is a boolean function that compare two polynoms. it use the comperator class.
	 * @param p1 represent the polynom that we want to compare with the current polynom.
	 * @return true if both polynoms are equal otherwise false.
	 */
	@Override
	public boolean equals(Polynom_able p1) {
		// TODO Auto-generated method stub
		Iterator <Monom> iterCurrent=this.iteretor();
		Iterator <Monom> iterP1=p1.iteretor();
		while(iterCurrent.hasNext()&&iterP1.hasNext())
		{
			if(!iterCurrent.next().is_equal(iterP1.next()))
				return false;

		}
		if(iterP1.hasNext()||iterCurrent.hasNext())
			return false;
		return true;
	}

	/**
	 * this function is a boolean function that check every monom in the polynom and
	 *  return true if all the monoms coefficient is zero. 
	 * @return true if it is the zero polynom otherwise false.
	 */
	@Override
	public boolean isZero() {
		// TODO Auto-generated method stub
		Iterator <Monom> iterCurrent=this.iteretor();
		while(iterCurrent.hasNext())
		{
			if(iterCurrent.next().get_coefficient()!=0)
				return false;
		}
		return true;
	}
	/**
	 *  this function find the root of the polynon between two points(one above the  x axis and one below it) by 
	 * using the bisection method. 
	 * the function returns 'x' so that f(x) less than eps (close enough to  zero) 
	 * @param x0 represent the first position on the x axis.
	 * @param x1 represent the second position on the x axis
	 * @param eps represent the epsilon.
	 * @return the value of x between x0-x1 that is the root of the polynom
	 */
	@Override
	public double root(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
		if(this.f(x0)*this.f(x1)>0)
			throw new RuntimeException("invalid arguments: f(x0)*f(x1)>0");
		if(this.f(x0)==0)
			return x0;
		if(this.f(x1)==0)
			return x1;
		if(Math.abs(x0-x1)<eps)
			return ((x0+x1)/2);
		double middle=(x0+x1)/2;
		if(this.f(x0)*this.f(middle)<0)
			return root(x0,middle,eps);
		else
			return root(middle,x1,eps);

	}
	/**
	 * this function getting a polynom and make a deep copy of it and returns the copy polynom
	 * @return a new polynom after a deep copy.
	 */
	@Override
	public Polynom_able copy() {
		// TODO Auto-generated method stub
		Polynom_able copyP=new Polynom();
		Iterator <Monom> itercopyP=this.iteretor();
		while(itercopyP.hasNext())
		{
			Monom temp=itercopyP.next();
			copyP.add(new Monom(temp.get_coefficient(),temp.get_power()));
		}

		return copyP;
	}
	/**
	 * 
	 * this function is getting a polynom and derivative it.
	 * in the and of the function it make a zero union.
	 * @return the polynom after derivative.
	 */
	@Override
	public Polynom_able derivative() {
		// TODO Auto-generated method stub
		Iterator <Monom> iterCurrent=this.iteretor();	
		while(iterCurrent.hasNext())
		{
			iterCurrent.next().derivative();
		}

		this.zero_union();
		return this;
	}
	/**
	 * this function is calculate the area of polynom between two points by using Riman's integral.
	 * the function splits the area to ((x1-x0)/eps) rectangles and summing the are of them.
	 * @param x0 represent the first position on the x axis.
	 * @param x1 represent the second position on the x axis
	 * @param eps represent the epsilon.
	 * @return the approximated area above the x-axis below this Polynom and between the [x0,x1] range.
	 */
	@Override
	public double area(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
		double numOfslices=Math.abs((x1-x0)/eps);
		double sum=0;
		double x=x0;
		for(int i=0;i<numOfslices;++i)
		{
			if(this.f(x)>0)
				sum=sum+this.f(x)*eps;
			x=x+eps;
		}

		return sum;
	}
	/**
	 * this function is calculate the area of polynom between two points by using Riman's integral.
	 * the function splits the area to ((x1-x0)/eps) rectangles and summing the area of them. 
	 * @param x0 represent the first position on the x axis.
	 * @param x1 represent the second position on the x axis
	 * @return the approximated area below the x-axis, above this Polynom and between the [x0,x1] range.
	 */
	public double areaAboveGraphBelowX(double x0, double x1)
	{
		double eps=0.01;
		double numOfslices=Math.abs((x1-x0)/eps);
		double sum=0;
		double x=x0;
		for(int i=0;i<numOfslices;++i)
		{
			if(this.f(x)<0)

				sum=sum+this.f(x)*eps;
			x=x+eps;
		}

		return Math.abs(sum);
	}

	/**
	 * this function is delete all of the zero monoms from the polynom and adding one zero monom in the end.
	 */
	public void zero_union()
	{
		Iterator <Monom> iterCurrent=this.iteretor();	
		while(iterCurrent.hasNext())
		{

			if(iterCurrent.next().is_zero())
			{
				iterCurrent.remove();

			}
		}
		this.monomList.add(new Monom(0,0));
	}
	/**
	 * this function defines an iterator for a polynom.
	 * @return  an Iterator (of Monoms) over this Polynom.
	 * 
	 */
	@Override
	public Iterator<Monom> iteretor() {
		// TODO Auto-generated method stub

		return monomList.iterator();
	}
	/**
	 * this function is printing the current polynom.
	 * @return a string that represents the polynom.
	 */
	public String toString() {
		String ans = "";
		Iterator<Monom> it= this.monomList.iterator();
		while(it.hasNext()) {
			ans += it.next().toString() + " ";
		}
		return ans;
	}


}
