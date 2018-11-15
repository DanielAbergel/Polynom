package myMathExamples;

import myMath.Graph;
import myMath.Polynom;

public class RunningExampleGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polynom PolynomTestGraph = new Polynom("0.2*x^4 - 1.5*x^3 + 3.0*x^2 - x - 5"); 
		Graph frame = new Graph(PolynomTestGraph,-2.0,6.0);
		frame.setVisible(true);
		frame.extrema();
		System.out.println("the area below x axis is :" + PolynomTestGraph.areaAboveGraphBelowX(-2, 6));
	}

}
