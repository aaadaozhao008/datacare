package snippet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Optional;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Linear Regression
 *    solution:y[] = a*x[] + b
 *
 *        2018.04: rongtao
 */
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class LineNew {
	static Random r = new Random();
	/**
	 * 
	 * @param a
	 * @return roll出一个 a--(a+jia)之间的数
	 */
	public static double rollJia(double a,double jia) {
		return Math.floor(r.nextDouble()*jia+a);
	}
	/**
	 * @param a
	 * @return roll出一个 (a-jian)--a 之间的数
	 */
	public static double rollJian(double a,double jian) {
		return Math.floor(a - r.nextDouble()*jian);
	}
	/**
	 * 拆分 x y (x,y 必须等长)
	 * @param x
	 * @param y
	 * @param mean
	 * @param evaluate
	 * @return 0=大众的x,1=大众的y,2=大众的x,3=大众的y
	 */
	public static List<List<Double>> getSplit(double x[] ,double y[],double mean,double evaluate){
		List<Double> xList1 = new ArrayList<>();
		List<Double> yList1 = new ArrayList<>();
		List<Double> xList2 = new ArrayList<>();
		List<Double> yList2 = new ArrayList<>();
		int length = x.length;
//		double max = mean + evaluate;//取 平均值-标准差  到 平均值+标准差 之间的; 
//		double min = mean - evaluate;
		double min = mean - evaluate/2;//比平均值-标准差的一半 大 分为一组;
		for (int i = 0; i < length; i++) {
//			if(y[i] >= min&&y[i] <= max) {
			if(y[i] >= min) {
				yList1.add(y[i]);
				xList1.add(x[i]);
			}else {
				yList2.add(y[i]);
				xList2.add(x[i]);
			}
		}
		List<List<Double>> dad = new ArrayList<>();
		dad.add(xList1);
		dad.add(yList1);
		dad.add(xList2);
		dad.add(yList2);
		return dad;
	}
	public static void main(String[] args) {
		int bei = 100;
		double x[] = new double[100*bei];//访问量
		for (int j = 0; j < 100*bei; j++) {
			x[j] = j+1;
		}
		double y[] = new double[100*bei];//访问量
		for (int j = 0; j < 100*bei; j++) {
			if(j < 60*bei)
				y[j] = rollJia(85,10);
//				if(j%20 == 0)y[j] = rollJia(20,15);
			else if(j < 68*bei)y[j] = rollJia(70,15);
			else if(j < 76*bei)y[j] = rollJia(55,15);
			else if(j < 84*bei)y[j] = rollJia(44,15);
			else if(j < 92*bei)y[j] = rollJia(25,15);
			else y[j] = rollJia(0,25);
		}
		draw2(x, y,10);
//		draw1(x, y);
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @param duanshu
	 *  如果刚好正除 截几段 = duanshu
	 *  否则 截几段 = duanshu + 1;
	 */
	public static void draw2(double x[],double y[],int duanshu) {
		int length = x.length;
		int jiekai = length/duanshu;
		int last = length - duanshu*jiekai;
		double normalx[] = new double[jiekai];
		double normaly[] = new double[jiekai];
		double lastx[] = new double[last];
		double lasty[] = new double[last];
		List<MyData> list = new ArrayList<>();
		MyData data ;
		for (int j = 0; j < duanshu; j++) {
			normalx = Arrays.copyOfRange(x, j, (j+1)*jiekai);
			normaly = Arrays.copyOfRange(y, j, (j+1)*jiekai);
			double solution[] = new Linear2Regression(normalx,normaly).normalEquation();
			data = new MyData(normalx, normaly, solution[0], solution[1],solution[2]);
			list.add(data);
		}
		if(last > 0) {
			lastx = Arrays.copyOfRange(x, duanshu*jiekai, length);
			lasty = Arrays.copyOfRange(y, duanshu*jiekai, length);
			double solution[] = new Linear2Regression(lastx,lasty).normalEquation();
			data = new MyData(lastx, lasty, solution[0], solution[1],solution[2]);
			list.add(data);
		}
		double max = list.stream().map(MyData::getSqError).distinct().max((e1, e2) -> e1.compareTo(e2)).get();
		System.out.println("max===>"+max);
		double a = 0;//加速度
		for (int i = 0; i < list.size() - 1; i++) {
			MyData myData = list.get(i);
			MyData myData1 = list.get(i+1);
			a = (myData1.getSlope()-myData.getSlope())/jiekai;
			System.out.println(i+"==>"+(i+1)+"的加速度:"+1000000*a);//方便看 乘以1000000
		}
		for (MyData d : list) {
			if(max == d.getSqError()) {
				d.setLineColor(1);
				d.setLineWidth(4);
				d.setPointColor(5);
				d.setPointWidth(2);
			}
		}
		My2JFrame jf = new My2JFrame("Linear Regression",1024,800);
		/* lineColor, lineWidth,  X, Y, pointColor, pointWidth, slope, intercept*/
		jf.add(new MyDrawJPanel(list));
		jf.setVisible(true);
	}
	public static void draw1(double x[],double y[]) {
		System.out.println("------样本------");
		for (int j = 0; j < y.length; j++) {
			System.out.print(y[j]+",");
			if(j%10 == 0)System.out.println();
		}
		System.out.println();
		System.out.println("------样本------");
		//求y的平均值
		double mean = StatUtils.mean(y);
		double min = StatUtils.min(y);
		double max = StatUtils.max(y);
		System.out.println("平均值="+mean);
		//求y的标准差
		StandardDeviation standardDeviation =new StandardDeviation();
		double evaluate = standardDeviation.evaluate(y);
		System.out.println("标准差="+evaluate);
		//求y的变异系数
		double bian = evaluate/mean;
		System.out.println("变异系数="+bian);
		//分成俩组 1个标准差左右的 属于一组 其他的分为另一组;
		List<List<Double>> split = getSplit(x, y, mean, evaluate);
		double[] x1 = split.get(0).stream().mapToDouble(i->i).toArray();
		double[] y1 = split.get(1).stream().mapToDouble(i->i).toArray();
		double[] x2 = split.get(2).stream().mapToDouble(i->i).toArray();
		double[] y2 = split.get(3).stream().mapToDouble(i->i).toArray();
		
		My2JFrame jf = new My2JFrame("Linear Regression",1024,800);
		
		/*line slope, line intercept, squared error*/
		double solution1[] = new Linear2Regression(x1,y1).normalEquation();
		double[] solution2 = new double[2];
		if(x2.length > 0) {
			solution2 = new Linear2Regression(x2,y2).normalEquation();
		}
		/* lineColor, lineWidth,  X, Y, pointColor, pointWidth, slope, intercept*/
		jf.add(new My2JPanel(3,2,x1,y1,2,6,solution1[0],solution1[1],1,5,x2,y2,3,8,solution2[0],solution2[1]));
//		jf.add(new My2JPanel(1,5,x,y,3,8,solution1[0],solution1[1]));
		double chaX = (solution1[1] - solution2[1])/(solution2[0] - solution1[0]);
		double chaY = solution1[0]*chaX + solution1[1];
		if (max < 85) {//1.响应率全部偏低
			System.out.println("该服务器目前响应率普遍偏低.无法预测最大请求量");
		}else if(min >= 85 && max < 100) {//2.二响应率全部偏低
			System.out.println("该服务器目前响应率普遍偏高.无法预测最大请求量");
		}else {
			if (bian < 0.2) {//3.波动小(出现了个别极端的响应率)
				System.out.println("该服务器波动较小.无法预测最大请求量");
			} else {
				//4.拐点前前的响应率有一个低于平均值 ,那么结果也无效
				for (int j = 0; j < x.length; j++) {
					if(x[j] < chaX) {
						if(y[j] <chaY) {
							System.out.println("该服务器出现曲线波动.无法预测最大请求量");
							break;
						}
					}else {
						break;
					}
				}
				//5.曲线性的结果;
				System.out.println("该服务器波的最大访问量 = " + chaX + ";此时的响应率 =" + chaY);
			} 
		}
		jf.setVisible(true);
	}
}
/**
 *  JFrame : main window
 *
 */
class My2JFrame extends JFrame
{
	private Toolkit toolkit; 

	My2JFrame(String title, int width, int height)
	{
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		toolkit = getToolkit();  
		Dimension size = toolkit.getScreenSize();  
		setLocation((size.width/2 - getWidth())/2, (size.height - getWidth())/2); 
	}
}
class MyData {
	private double x[], y[];
	private double slope, intercept,sqError;
	private int lineColor = 2, lineWidth = 3;
	private int pointColor = 4, pointWidth = 2;
	private int numpoint;
	public MyData(double[] x, double[] y, double slope, double intercept,double sqError) {
		super();
		this.x = x;
		this.y = y;
		this.slope = slope;
		this.intercept = intercept;
		this.sqError = sqError;
		this.numpoint = x.length<y.length?x.length:y.length;
	}
	
	public double getSqError() {
		return sqError;
	}

	public int getNumpoint() {
		return numpoint;
	}
	public int getLineColor() {
		return lineColor;
	}
	public void setLineColor(int lineColor) {
		this.lineColor = lineColor;
	}
	public int getLineWidth() {
		return lineWidth;
	}
	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}
	public int getPointColor() {
		return pointColor;
	}
	public void setPointColor(int pointColor) {
		this.pointColor = pointColor;
	}
	public int getPointWidth() {
		return pointWidth;
	}
	public void setPointWidth(int pointWidth) {
		this.pointWidth = pointWidth;
	}
	public double[] getX() {
		return x;
	}
	public void setX(double[] x) {
		this.x = x;
	}
	public double[] getY() {
		return y;
	}
	public void setY(double[] y) {
		this.y = y;
	}
	public double getSlope() {
		return slope;
	}
	public void setSlope(double slope) {
		this.slope = slope;
	}
	public double getIntercept() {
		return intercept;
	}
	public void setIntercept(double intercept) {
		this.intercept = intercept;
	}
}
/**
 *  JPanel: for drawing
 *
 */
class My2JPanel extends JPanel
{
	private int lineColor, lineWidth;
	private int pointColor, pointWidth;
	private int  numpoint;
	private double x[], y[], minx=99999, miny=99999, maxx=0, maxy=0;
	private double slope, intercept;
	private int bndr = 80;
	
	private int lineColor1, lineWidth1;
	private int pointColor1, pointWidth1;
	private int  numpoint1;
	private double x1[], y1[];
	private double slope1, intercept1;

	My2JPanel(int lc, int lw, double x[], double y[], int pc, int pw, 
			double slope, double intercept,int lc1, int lw1, double x1[], double y1[], int pc1, int pw1, 
			double slope1, double intercept1)/*xielv, jiejv*/
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
class MyDrawJPanel extends JPanel
{
	private double minx=99999, miny=99999, maxx=0, maxy=0;
	private int bndr = 100;
	private List<MyData> list;
	MyDrawJPanel(List<MyData> list)/*xielv, jiejv*/
	{
		this.list = list;
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
		for (MyData myData : list) {
			/* linear regression line */
			int lineColor = myData.getLineColor();
			int lineWidth = myData.getLineWidth();
			g2d.setColor(getLineColor(lineColor));  
			g2d.setStroke(getLineWidth(lineWidth)); 
			double[] x = myData.getX();
			if(x.length == 0) continue;
			double[] y = myData.getY();
			double slope = myData.getSlope();
			double intercept = myData.getIntercept();
			int numpoint = myData.getNumpoint();
			g2d.drawLine((int)((x[0]-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
					getHeight()-bndr-
					(int)((x[0]*slope+intercept-miny)*1.0f
							/(maxy-miny)*(getHeight()-bndr*2)),
					(int)((x[numpoint-1]-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
					getHeight()-bndr-
					(int)((x[numpoint-1]*slope+intercept-miny)*1.0f
							/(maxy-miny)*(getHeight()-bndr*2))
					); 

			/* Axis 轴 */
			g2d.setColor(getLineColor(4));  
			g2d.setStroke(getLineWidth(1)); 
			/* Vertical 	垂直线 axis */
			g2d.drawLine((int)((0-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
					getHeight()-bndr- (int)((miny-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2)),
					(int)((0-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
					getHeight()-bndr- (int)((maxy-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2))
					);
			/* Horizontal 水平位置 axis */
			g2d.drawLine((int)((0)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
					getHeight()-bndr- (int)((0-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2)),
					(int)((maxx-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
					getHeight()-bndr- (int)((0-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2))
					);

			/* point */
			g2d.setColor(getLineColor(myData.getPointColor()));  
			g2d.setStroke(getLineWidth(myData.getPointWidth()));
			for(int i = 0; i < numpoint; i++)
			{
				g2d.drawLine((int)((x[i]-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
						getHeight()-bndr-(int)((y[i]-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2)),
						(int)((x[i]-minx)*1.0f/(maxx-minx)*(getWidth()-bndr*2))+bndr,
						getHeight()-bndr-(int)((y[i]-miny)*1.0f/(maxy-miny)*(getHeight()-bndr*2)));
			}
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
		for (MyData myData : list) {
			double[] x = myData.getX();
			double[] y = myData.getY();
			for(int i=0 ; i < myData.getNumpoint();i++)
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
		}
	}
}
/**
 *  linear regression calculation
 *
 */
class Linear2Regression
{
	private double x[], y[];
	private int numpoint=0;
	Linear2Regression(double x[], double y[])
	{
		this.x = x;
		this.y = y;
		this.numpoint = x.length<y.length?x.length:y.length;
	}
	double[] normalEquation()
	{
		/*line slope, line intercept, squared error*/
		double solution[] = new double[3];
		double SumX=0,SumY=0,SumXY=0,SumXX=0,SumYY=0,SumXAndSumY,SumXAndSumX,SumYAndSumY;

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
			/* line slope 斜度 */
			solution[0] = (numpoint*SumXY-SumXAndSumY)/(numpoint*SumXX-SumXAndSumX);  
			/* line intercept  截距*/
			solution[1] = (SumY-solution[0]*SumX)/numpoint;  //intercept
		}

		if((numpoint*SumXX-SumXAndSumX)*(numpoint*SumYY-SumYAndSumY)>0)
			/* squared error 均方误差 */
			solution[2]=(numpoint*SumXY-SumXAndSumY)*(numpoint*SumXY-SumXAndSumY)
			/((numpoint*SumXX-SumXAndSumX)*(numpoint*SumYY-SumYAndSumY));//R^2

		System.out.println("squared error: "+solution[2]);
		return solution;
	}

}
