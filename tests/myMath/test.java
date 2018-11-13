package myMath;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Monom a =new Monom(2,3); ///build the monom 2*x^3.
		System.out.println(a.toString());

		Monom b =new Monom(4,2);/// just one more monom for camparing.
		System.out.println(b.toString());

		Monom c = new Monom("4*x^2");///build a monom from a string.
		System.out.println(c.toString());

		Monom d = new Monom(a);///copying Monom a.
		System.out.println(d.toString());

		Monom e = new Monom(0,0);///the zero monom.
		System.out.println(e.toString());

		Monom z = new Monom(1,3);///just one more monom for later.

		a.derivative();///this function derivative the a monom.
		System.out.println(a);

		System.out.println(a.f(2));/// this function calc the value of a (after the derivative) with x=2.

		a.add(c);///this function add the monom c to monom a (they have the same power).
		System.out.println(a.toString());

		a.multiply(c);///this function multiply monom a whith nonom c.
		System.out.println(a.toString());

		System.out.println(c.is_equal(a));///check if the monom c is equal to monom a - false.
		System.out.println(c.is_equal(b));///check if the monom c is equal to monom b - true.

		System.out.println(a.is_zero());///check if the monom a is zero - false.
		System.out.println(e.is_zero());///check if the monom e is zero - true.

		Polynom g=new Polynom(); /// build the zero polynom
		System.out.println(g.toString());

		Polynom h=new Polynom("3*x^4 - 2*x^3 + x^2 - 5");/// build the the (3*x^4 - 2*x^3 + x^2 - 5) polynom.
		System.out.println(h.toString());

		Polynom i=new Polynom("-x^2 + 5");/// build the the (-x^2 + 5) polynom.
		System.out.println(i.toString());

		Polynom j =new Polynom("-x^2 + 5");
		System.out.println(j.toString());

		Polynom l = new Polynom(j);
		System.out.println(l.toString());

		System.out.println(h.f(2));///calc the h polynom with argument x=2.

		h.add(i);///adding the i polynom to the h polynom.
		System.out.println(h.toString());

		h.add(z);/// adding the monom z to polynom h.
		System.out.println(h.toString());

		h.substract(i);///substruct the i polynom from the h polynom.
		System.out.println(h.toString());

		h.multiply(i);
		System.out.println(h.toString());

		System.out.println(i.equals(h));/// check if polynom h is equal to i - false.
		System.out.println(i.equals(j));/// check if polynom j is equal to i - true.

		System.out.println(h.isZero());///check if the h polynom is equal to zero - false.
		System.out.println(g.isZero());///check if the g polynom is equal to zero - true.

		System.out.println(i.root(1, 5, 0.0001));///check the root of polynom i between x=1 to x=5 with eps=0.0001.

		Polynom_able k=i.copy();///copying the i polynom to the k polynom_able.
		System.out.println(k.toString());

		h.derivative();///this function derivative polynom h.
		System.out.println(h.toString());

		System.out.println(i.area(-3, 4, 0.0001));///calc the area above the x axis between x=-3 to x=3 with eps= 0.0001.
		
		
	}


}
