package snippet;
/**
 * Linear Regression
 *    solution:y[] = a*x[] + b
 *
 *        2018.04: rongtao
 */
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Line {
	public static void main(String[] args) {
		Random r = new Random();
		float guaidian = r.nextFloat()*10f+90f;
		float x[] = {10,20,30,40,50,60,70};//访问量
		float y[] = {r.nextFloat()*10f+90f,r.nextFloat()*10f+90f,r.nextFloat()*10f+90f,
				r.nextFloat()*10f+90f,r.nextFloat()*10f+90f,r.nextFloat()*10f+90f,guaidian};//响应率
		
		float x1[] = {70,150};//访问量
		float y1[] = {guaidian,80f - r.nextFloat()*10f};//响应率

		MyJFrame jf = new MyJFrame("Linear Regression",1024,800);

		/*line slope, line intercept, squared error*/
		float solution[] = new linearRegression(x,y).normalEquation();
		float solution1[] = new linearRegression(x1,y1).normalEquation();

		/* lineColor, lineWidth,  X, Y, pointColor, pointWidth, slope, intercept*/
		jf.add(new myJPanel(3,2,x,y,2,6,solution[0],solution[1],1,5,x1,y1,3,8,solution1[0],solution1[1]));
//		jf.add(new myJPanel(1,5,x,y,3,8,solution1[0],solution1[1]));

		System.out.println("y = "+solution[0]+"*x +"+solution[1]);
		System.out.println("y1 = "+solution1[0]+"*x1 +"+solution1[1]);
		float chaX = (solution[1] - solution1[1])/(solution1[0] - solution[0]);
		float chaY = solution[0]*chaX + solution[1];
		System.out.println("俩者的交叉点的x(访问量) = "+chaX+";y(响应率) ="+chaY);

		jf.setVisible(true);
	}
}
/**
 *  JFrame : main window
 *
 */
class MyJFrame extends JFrame
{
	private Toolkit toolkit; 

	MyJFrame(String title, int width, int height)
	{
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		toolkit = getToolkit();  
		Dimension size = toolkit.getScreenSize();  
		setLocation((size.width/2 - getWidth())/2, (size.height - getWidth())/2); 
	}
}
/**
 *  JPanel: for drawing
 *
 */
class myJPanel extends JPanel
{
	private int lineColor, lineWidth;
	private int pointColor, pointWidth;
	private int  numpoint;
	private float x[], y[], minx=99999, miny=99999, maxx=0, maxy=0;
	private float slope, intercept;
	private int bndr = 80;
	
	private int lineColor1, lineWidth1;
	private int pointColor1, pointWidth1;
	private int  numpoint1;
	private float x1[], y1[];
	private float slope1, intercept1;

	myJPanel(int lc, int lw, float x[], float y[], int pc, int pw, 
			float slope, float intercept,int lc1, int lw1, float x1[], float y1[], int pc1, int pw1, 
			float slope1, float intercept1)/*xielv, jiejv*/
	{
		this.lineColor = lc;
		this.lineWidth = lw;
		this.pointColor = pc;
		this.pointWidth = pw;
		this.x = x;
		this.y = y;
		this.slope = slope;
		this.intercept = intercept;
		this.numpoint = x.length<y.length?x.length:y.length;
		
		this.lineColor1 = lc1;
		this.lineWidth1 = lw1;
		this.pointColor1 = pc1;
		this.pointWidth1 = pw1;
		this.x1 = x1;
		this.y1 = y1;
		this.slope1 = slope1;
		this.intercept1 = intercept1;
		this.numpoint1 = x1.length<y1.length?x1.length:y1.length;
		getArea();
	}
	/**
	 *  painting
	 *
	 */
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;  


		/* linear regression line */
		g2d.setColor(getLineColor(lineColor));  
		g2d.setStroke(getLineWidth(lineWidth)); 
		g2d.drawLine((int)((x[0]-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
				getHeight()-bndr-
				(int)((x[0]*slope+intercept-miny)*1.0f
						/(maxy-miny)*(getHeight()-bndr*2)),
				(int)((x[numpoint-1]-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
				getHeight()-bndr-
				(int)((x[numpoint-1]*slope+intercept-miny)*1.0f
						/(maxy-miny)*(getHeight()-bndr*2))
				); 

		/* Axis */
		g2d.setColor(getLineColor(4));  
		g2d.setStroke(getLineWidth(1)); 
		/* Vertical axis */
		g2d.drawLine((int)((0-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
				getHeight()-bndr- (int)((miny-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2)),
				(int)((0-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
				getHeight()-bndr- (int)((maxy-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2))
				);
		/* Horizontal axis */
		g2d.drawLine((int)((0)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
				getHeight()-bndr- (int)((0-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2)),
				(int)((maxx-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
				getHeight()-bndr- (int)((0-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2))
				);

		/* point */
		g2d.setColor(getLineColor(pointColor));  
		g2d.setStroke(getLineWidth(pointWidth));
		for(int i = 0; i < numpoint; i++)
		{
			g2d.drawLine((int)((x[i]-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
					getHeight()-bndr-(int)((y[i]-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2)),
					(int)((x[i]-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
					getHeight()-bndr-(int)((y[i]-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2)));
		}
//----2---	
		/* linear regression line */
		g2d.setColor(getLineColor(lineColor1));  
		g2d.setStroke(getLineWidth(lineWidth1)); 
		g2d.drawLine((int)((x1[0]-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
				getHeight()-bndr-
				(int)((x1[0]*slope1+intercept1-miny)*1.0f
						/(maxy-miny)*(getHeight()-bndr*2)),
				(int)((x1[numpoint1-1]-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
				getHeight()-bndr-
				(int)((x1[numpoint1-1]*slope1+intercept1-miny)*1.0f
						/(maxy-miny)*(getHeight()-bndr*2))
				); 

		/* Axis */
		g2d.setColor(getLineColor(4));  
		g2d.setStroke(getLineWidth(1)); 
		/* Vertical axis */
		g2d.drawLine((int)((0-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
				getHeight()-bndr- (int)((miny-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2)),
				(int)((0-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
				getHeight()-bndr- (int)((maxy-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2))
				);
		/* Horizontal axis */
		g2d.drawLine((int)((0)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
				getHeight()-bndr- (int)((0-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2)),
				(int)((maxx-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
				getHeight()-bndr- (int)((0-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2))
				);

		/* point */
		g2d.setColor(getLineColor(pointColor1));  
		g2d.setStroke(getLineWidth(pointWidth1));
		for(int i = 0; i < numpoint1; i++)
		{
			g2d.drawLine((int)((x1[i]-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
					getHeight()-bndr-(int)((y1[i]-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2)),
					(int)((x1[i]-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
					getHeight()-bndr-(int)((y1[i]-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2)));
		}

	}
	/* get raypath line width */  
	public BasicStroke getLineWidth(int dim)
	{  
		BasicStroke tmp = new BasicStroke(dim);  
		return tmp;  
	}  
	/* get raypath line color */  
	public Color getLineColor(int dim)
	{ 
		if(dim==1)return Color.RED;  
		else if(dim==2)return Color.BLUE;  
		else if(dim==3)return Color.GREEN;  
		else if(dim==4)return Color.BLACK;  
		else if(dim==5)return Color.GRAY;  
		else if(dim==6)return Color.YELLOW;  
		else if(dim==7)return Color.PINK;  
		else if(dim==8)return Color.CYAN;  
		else if(dim==9)return Color.MAGENTA;  
		else if(dim==10)return Color.ORANGE;  
		else return Color.BLACK;  
	} 
	/* get drawing area */
	void getArea()
	{
		for(int i=0;i<numpoint;i++)
		{
			if(minx > x[i])
				minx = x[i];
			if(miny > y[i])
				miny = y[i];
			if(maxx < x[i])
				maxx = x[i];
			if(maxy < y[i])
				maxy = y[i];
		}
		for(int i=0;i<numpoint1;i++)
		{
			if(minx > x1[i])
				minx = x1[i];
			if(miny> y1[i])
				miny = y1[i];
			if(maxx < x1[i])
				maxx = x1[i];
			if(maxy < y1[i])
				maxy = y1[i];
		}
	}
}
/**
 *  linear regression calculation
 *
 */
class linearRegression
{
	private float x[], y[];
	private int numpoint=0;
	linearRegression(float x[], float y[])
	{
		this.x = x;
		this.y = y;
		this.numpoint = x.length<y.length?x.length:y.length;
	}
	float[] normalEquation()
	{
		/*line slope, line intercept, squared error*/
		float solution[] = new float[3];
		float SumX=0,SumY=0,SumXY=0,SumXX=0,SumYY=0,SumXAndSumY,SumXAndSumX,SumYAndSumY;

		for(int i=0;i< numpoint;i++) 
		{
			SumX=SumX+x[i];      
			SumY=SumY+y[i];   
			SumXY=SumXY+x[i]*y[i];
			SumXX=SumXX+x[i]*x[i];
			SumYY=SumYY+y[i]*y[i]; 
		}

		SumXAndSumY=SumX*SumY;  
		SumXAndSumX=SumX*SumX;   
		SumYAndSumY=SumY*SumY;   

		if((numpoint*SumXX-SumXAndSumX)>0)
		{
			/* line slope */
			solution[0] = (numpoint*SumXY-SumXAndSumY)/(numpoint*SumXX-SumXAndSumX);  
			/* line intercept */
			solution[1] = (SumY-solution[0]*SumX)/numpoint;  //intercept
		}

		if((numpoint*SumXX-SumXAndSumX)*(numpoint*SumYY-SumYAndSumY)>0)
			/* squared error */
			solution[2]=(numpoint*SumXY-SumXAndSumY)*(numpoint*SumXY-SumXAndSumY)
			/((numpoint*SumXX-SumXAndSumX)*(numpoint*SumYY-SumYAndSumY));//R^2

		System.out.println("squared error: "+solution[2]);
		return solution;
	}

}
