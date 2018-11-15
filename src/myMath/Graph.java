package myMath;

import java.awt.Color;
import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import myMath.Polynom;
/**
 * this class is showing a polynom on a graph.
 * 1.collect data of a polynom.
 * 2.plotting a polynom on a graph.
 * 3.plotting a polynom with it's max and min points on a graph.
 * 
 * @author Netanel Ben-Isahar 204478150
 * @author Daniel Abargel 315660712
 *
 */
public class Graph extends JFrame {
	Polynom polynon;
	double startingPoint;
	double finishPoint;
	DataTable data;
	XYPlot plot;
	Color color;

	/**
	 * this function collecting data of a polynom.
	 * 
	 * @param poly represents the current polynom.
	 * @param startingPoint represents the starting point of the graph as we want to see. 
	 * @param finishPoint represents the finish point of the graph as we want to see.
	 */

	public Graph(Polynom poly,double startingPoint,double finishPoint) {
		this.polynon=poly;
		this.startingPoint=startingPoint;
		this.finishPoint=finishPoint;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 1000);

		this.data = new DataTable(Double.class, Double.class);

		for (double x =startingPoint; x <= finishPoint; x+=0.001)
		{
			double y = this.polynon.f(x);
			this.data.add(x, y);

		}
		this.plot = new XYPlot(data);
		this.plot.add(this.data);

	}
	
	/**
	 * this function getting a collection of data of a polynom and plotting it on a graph.
	 */
	public void plotting()
	{
		this.plot = new XYPlot(this.data);

		getContentPane().add(new InteractivePanel(this.plot));

		LineRenderer lines = new DefaultLineRenderer2D();
		plot.setLineRenderers(data, lines);

		this.color = new Color(0.0f, 0.3f, 1.0f);
		this.plot.getPointRenderers(this.data).get(0).setColor(this.color);
		plot.getLineRenderers(data).get(0).setColor(color);
	}
	 /**
	  * this function getting a collection of data of a polynom and plotting it on a graph.
	  * also it calculate the max and min points of the polynom and adding it to the graph.
	  */

	public void extrema()
	{

		DataTable data1 = new DataTable(Double.class, Double.class);

		Polynom dev=new Polynom(this.polynon);
		dev.derivative();
		int count = 0 ; 
		for (double x = this.startingPoint; x <= this.finishPoint; x+=0.001)
		{
			double y =this.polynon.f(x);

			if(dev.f(x-0.001)*dev.f(x+0.001)<0)
			{
				
				System.out.println("Extreme points number " +count+ ":" + " X value : " + x +" Y value : " + this.polynon.f(x));
				data1.add(x, y);
				x+=0.001;
				count++;
			}
		}
		this.plot = new XYPlot(this.data);
		this.plot.add(data1);

		getContentPane().add(new InteractivePanel(this.plot));

		LineRenderer lines = new DefaultLineRenderer2D();
		plot.setLineRenderers(data, lines);

		this.color = new Color(0.0f, 0.3f, 1.0f);
		this.plot.getPointRenderers(this.data).get(0).setColor(this.color);
		plot.getLineRenderers(data).get(0).setColor(color);
     	plot.getPointRenderers(data1).get(0).setValueVisible(true);
		

	}
}

