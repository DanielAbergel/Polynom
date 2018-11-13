package myMath;


public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polynom aba=new Polynom("0.2*x^4 - 1.5*x^3 + 3.0*x^2 - x - 5"); 

		Graph frame = new Graph(aba,-2.0,6.0);
		frame.setVisible(true);
		frame.plotting();
		frame.extrema();
		//		Polynom ama=new Polynom(aba);
		//		ama.derivative();
	}

}
