package myMath;

import java.awt.Color;
import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.Plot;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import myMath.Polynom;

public class GARLTest extends JFrame {
	public GARLTest() {
		Polynom poly=new Polynom("0.2*x^4 - 1.5*x^3 + 3.0*x^2 - x - 5");
		Polynom divPoly=new Polynom("0.2*x^4 - 1.5*x^3 + 3.0*x^2 - x - 5");
		divPoly.derivative();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 800);
		DataTable dataPoint = new DataTable(Double.class, Double.class);
		DataTable data = new DataTable(Double.class, Double.class);
		for (double x = -1; x <= 5; x+=0.001) {
			double y = poly.f(x);
			data.add(x, y);
			if(divPoly.f(x-0.001)* divPoly.f(x+0.001) < 0) 
				{
				
				dataPoint.add(x,poly.f(x));
				System.out.println(x);
				
				}
		}
		

	
		XYPlot plot = new XYPlot(data);
		plot.add(dataPoint);

	
		getContentPane().add(new InteractivePanel(plot));
		
		LineRenderer lines = new DefaultLineRenderer2D();
		plot.setLineRenderers(data, lines);
		Color color = new Color(0.0f, 0.3f, 1.0f);
		plot.getPointRenderers(data).get(0).setColor(color);
		plot.getLineRenderers(data).get(0).setColor(color);
	}
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GARLTest frame = new GARLTest();
		frame.setVisible(true);
	}

}
