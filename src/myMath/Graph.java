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

public class Graph extends JFrame {
	Polynom polynon;
	double startingPoint;
	double finishPoint;
	DataTable data;
	XYPlot plot;
	Color color;


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
	public void extrema()
	{

		DataTable data1 = new DataTable(Double.class, Double.class);

		Polynom dev=new Polynom(this.polynon);
		dev.derivative();

		for (double x = this.startingPoint; x <= this.finishPoint; x+=0.001)
		{
			double y =this.polynon.f(x);

			if(dev.f(x-0.001)*dev.f(x+0.001)<0)
			{
				System.out.println(this.polynon.f(x));
				data1.add(x, y);
				x+=0.001;
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

	}
}

