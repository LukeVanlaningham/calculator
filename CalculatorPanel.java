import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.event.MouseEvent;
import java.awt.Canvas;
import java.util.ArrayList;
public class CalculatorPanel extends Canvas implements MouseListener{
	private int mouseX, mouseY;
	private boolean mouseClicked;
	private String entry;
	private double xMax,yMax,xMin,yMin,intStart,intEnd,DyDx;
	private boolean isgraph;
	public CalculatorPanel()
	{
		mouseClicked = false;
		entry = "";
		mouseX = mouseY = 0;
		isgraph = false;
		xMax = 10;
		xMin = -10;
		yMax = 10;
		yMin = -10;
		intStart = -999;
		intEnd = -999;
		DyDx = -999;
		addMouseListener(this);
	}
	public void mouseClicked(MouseEvent e)
	{
		mouseClicked = true;
		mouseX=e.getX();
		mouseY=e.getY();
		repaint();
	}
	public void paint(Graphics window)
	{
		if(isgraph==false)
		{
			window.setColor(Color.WHITE);
			window.fillRect(0,0,900,700);
			window.setColor(Color.BLACK);
			window.drawRect(0, 200, 13*50, 100);
			window.drawRect(0, 200, 10*50, 100);
			window.drawRect(0, 200, 14*50, 100);
			window.drawRect(0, 200, 15*50, 100);
			window.drawRect(0, 300, 13*50, 100);
			window.drawRect(0, 300, 14*50, 100);
			window.drawRect(0, 300, 15*50, 100);
			window.drawRect(0, 200, 11*50, 100);
			window.drawRect(0, 200, 12*50, 100);
			for(int i = 0;i<14;i++)
			{
			window.drawRect(50*i, 0,100, 100);
			window.drawRect(50*i, 100, 100, 100);
			}
			window.setFont(new Font("TAHOMA",Font.BOLD,12));
			window.drawString("0", 25, 50);
			window.drawString("1", 75, 50);
			window.drawString("2", 125, 50);
			window.drawString("3", 175, 50);
			window.drawString("4", 225, 50);
			window.drawString("5", 275, 50);
			window.drawString("6", 325, 50);
			window.drawString("7", 375, 50);
			window.drawString("8", 425, 50);
			window.drawString("9", 475, 50);
			window.drawString(".", 525, 50);
			window.drawString("(x)", 575, 50);
			window.drawString("ln()", 615, 50);
			window.drawString("xMax", 660, 50);
			window.drawString("yMax", 710, 50);
			window.drawString("^", 575, 150);
			window.drawString("-", 25, 150);
			window.drawString("/", 75, 150);
			window.drawString("*", 125, 150);
			window.drawString("+", 175, 150);
			window.drawString(")", 225, 150);
			window.drawString("(",275, 150);
			window.drawString("Sin()", 315, 150);
			window.drawString("cos()", 365, 150);
			window.drawString("tan()", 415, 150);
			window.drawString("pi", 475, 150);
			window.drawString("e", 525, 150);
			window.drawString("^", 575, 150);
			window.drawString("log()", 610, 150);
			window.drawString("enter", 510, 250);
			window.drawString("clear", 560, 250);
			window.drawString("graph", 610, 250);
			window.drawString("xMin", 660, 150);
			window.drawString("yMin", 710, 150);
			window.drawString("int strt", 655, 250);
			window.drawString("int end", 705, 250);
			window.drawString("dy/dx", 655, 350);
			window.drawString("dy/dx x value = "+DyDx, 5, 320);
			window.drawString("Integral starts at "+intStart, 5, 340);
			window.drawString("Integral ends at "+intEnd, 5, 360);
			window.drawString("Xmin = "+xMin, 200, 320);
			window.drawString("Xmax = "+xMax, 300, 320);
			window.drawString("Ymin = "+yMin,200, 340);
			window.drawString("Ymax = "+yMax,300, 340);

			if(mouseX>12*50&&mouseX<13*50&&mouseY>200&&mouseY<300)
			{
				boolean hm = false;
				String Test = entry;
				try {
					entry = entry.replace("x", "2");
					calculate();
					entry = Test;
					isgraph = true;
					paint(window);
				}
				catch(Exception e)
				{
					entry = Test;
					hm = true;
					window.drawString("ERROR", 250, 250);
					isgraph = false;

				}
				
			}
			if(mouseX>11*50&&mouseX<12*50&&mouseY>200&&mouseY<300)
			{
				entry = "";
			}
			
			if(mouseX>10*50&&mouseX<11*50&&mouseY>200&&mouseY<300)
			{
				try 
				{
					window.drawString(String.valueOf(calculate()), 250, 250);
				}
				catch(Exception e)
				{
					window.drawString("ERROR", 250, 250);
				}
				

			}
			if(mouseX>13*50&&mouseX<14*50&&mouseY<100)
			{
				xMax = calculate();
				mouseX = 1000000;
				paint(window);
			}
			if(mouseX>13*50&&mouseX<14*50&&mouseY>100&&mouseY<200)
			{			
				xMin = calculate();
				mouseX = 1000000;
				paint(window);
			}
			if(mouseX>14*50&&mouseX<15*50&&mouseY<100)
			{			
				yMax = calculate();
				mouseX = 1000000;
				paint(window);
			}
			if(mouseX>14*50&&mouseX<15*50&&mouseY>100&&mouseY<200)
			{			
				yMin = calculate();
				mouseX = 1000000;
				paint(window);
			}
			if(mouseX>13*50&&mouseX<14*50&&mouseY>200&&mouseY<300)
			{
				intStart = calculate();
				mouseX = 1000000;
				paint(window);
			}
			if(mouseX>13*50&&mouseX<14*50&&mouseY>300&&mouseY<400)
			{
				DyDx = calculate();
				mouseX = 1000000;
				paint(window);
			}
			if(mouseX>14*50&&mouseX<15*50&&mouseY>200&&mouseY<300)
			{
				intEnd = calculate();
				mouseX = 1000000;
				paint(window);
			}
			if(mouseClicked)
			{
				Entry(window);
			}
		}
		if(isgraph == true)
		{
			window.setColor(Color.WHITE);
			window.fillRect(0, 0, 800,600);
			String tempEntry = entry;
			int prevX = 0;
			int prevY = 0;
			int prevXLine = 0;
			int prevYLine = 0;
			double prevRealY = 0;
			window.setColor(Color.BLACK);
			window.drawRect(750, 550, 50, 50);
			window.drawString("esc",765, 575);
			// y axis
			int xzero = (int) ((-xMin*800)/(xMax-xMin));
			 window.drawLine(xzero, 0, xzero, 600);
			 // x axis
			 int yzero = (int) ((-600*yMax)/(yMin-yMax));
			window.drawLine(0, yzero, 800, yzero);
			 window.drawLine(0, 0, 800, 0);
			 window.drawLine(0, 0, 0, 600);
			 window.drawLine(0, 600, 800, 600);
			 window.drawLine(800, 0, 800, 600);
			 entry = entry.replace("x", String.valueOf(DyDx+.001));
			 double y2 = calculate();
			 entry = tempEntry;
			 entry = entry.replace("x", String.valueOf(DyDx-.001));
			 double y1 = calculate();
			 double slope = (y2-y1)/.002;
			 entry = tempEntry;
			 entry = entry.replace("x",String.valueOf(DyDx));
			 double point = calculate();
			 entry = tempEntry;
			 double yInt = point-slope*DyDx;
			window.drawString("dy/dx ="+slope, 5, 20);
			double integral = 0;
			boolean lol = false;
			for(double i = 0;i<800;i++)
			{
				double realX = i*(xMax-xMin)/800+xMin;
				
				entry = entry.replace("x", String.valueOf(realX));
				double realY = calculate();
				int pixelY =   (int) (((realY-yMax)*600)/(yMin-yMax));
				int pixelX = (int) i;
				double realYLine = (slope*realX+yInt);
				int pixelYLine = (int) (((realYLine-yMax)*600)/(yMin-yMax));
				window.drawLine(prevX, prevY, pixelX, pixelY);
				window.drawLine(prevXLine, prevYLine, pixelX, pixelYLine);
				if(realX<=intEnd&&realX>=intStart)
				{
					if(realY >0&&lol)
					{
						window.fillRect(pixelX, pixelY, 1, yzero-pixelY);
						integral+=((xMax-xMin)/800)*(realY+prevRealY)/2;
					}
					if(realY < 0&&lol)
					{
						window.fillRect(pixelX, yzero,1, pixelY-yzero);
						integral+=((xMax-xMin)/800)*(realY+prevRealY)/2;
					}
					if(!lol)
					{
						lol = true;
					}
				}
				entry = tempEntry;
				prevXLine = pixelX;
				prevYLine = pixelYLine;
				prevX = pixelX;
				prevY = pixelY;
				prevRealY = realY;
            } 
			window.drawString("integral = "+integral, 5, 40);
			if(mouseX>750&&mouseY>550)
			{
				isgraph = false;
				paint(window);
			}
		}
		
	}
	public double calculate()
	{

		ArrayList<String> partition = new ArrayList<String>();
		boolean isop = false;
		partition.add("");

		for(int i = 0;i<entry.length();i++)
		{
			if(((entry.charAt(i)>47&&entry.charAt(i)<58)||entry.charAt(i)==46)&&isop==false)
			{
				partition.set(partition.size()-1,partition.get(partition.size()-1)+entry.charAt(i));
			}
			if(((entry.charAt(i)>47&&entry.charAt(i)<58)||entry.charAt(i)==46)&&isop)
			{
				partition.add(entry.charAt(i)+"");
				isop = false;
			}
			if(entry.charAt(i)<46||entry.charAt(i)==47||entry.charAt(i)>57)
			{
				
				partition.add(entry.charAt(i)+"");
				if(entry.charAt(i)==99)
				{
					partition.set(partition.size()-1,"cos");
					i+=2;
					isop = true;
					continue;
				}
				if(entry.charAt(i)==115)
				{
					partition.set(partition.size()-1,"sin");
					i+=2;
					isop = true;
					continue;
				}
				if(entry.charAt(i)==116)
				{
					partition.set(partition.size()-1,"tan");
					i+=2;
					isop = true;
					continue;
				}
				if(entry.charAt(i)==108)
				{
					if(entry.charAt(i+1)==110)
					{
						partition.set(partition.size()-1, "ln");
						i+=1;
						isop = true;
						continue;
					}
					if(entry.charAt(i+1)==111)
					{
						partition.set(partition.size()-1,"log");
						i+=2;
						isop = true;
						continue;
					}
				}
				if(entry.charAt(i)==112)
				{
					partition.set(partition.size()-1, String.valueOf(Math.PI));
					i+=1;
					isop = true;
					continue;
				}
				if(entry.charAt(i)==101)
				{
					partition.set(partition.size()-1, String.valueOf(Math.E));
					isop = true;
					continue;
				}
				isop = true;
			}
			}
	
			while(partition.indexOf("")!=-1)
			{
				partition.remove(0);
			}
		
						
		
			while(partition.indexOf("(")!=-1)
		{
				if(partition.indexOf("(")!=0)
				{
					char important = partition.get(partition.indexOf("(")-1).charAt(partition.get(partition.indexOf("(")-1).length()-1);
					if(important>47&&important<58)
					{

						partition.add(partition.indexOf("("),"*");
					}
				}
			
			int open =partition.indexOf("(")+1;
			int opencount = 1;
			int closedcount = 0;
			ArrayList<String> newcalculate = new ArrayList<String>();
			while(opencount!=closedcount)
			{
				if(partition.get(open).equals("("))
					opencount++;
				if(partition.get(open).equals(")"))
					closedcount++;
				if(closedcount==opencount)
				{
					continue;
				}
				newcalculate.add(partition.get(open));
				open++;
			}

			String tempEntry = entry;
			String newEntry = "";
			for(int i = 0;i<newcalculate.size();i++)
			{
				newEntry+=newcalculate.get(i);
			}
			entry = newEntry;
			double num = calculate();
			int x =partition.indexOf("(");

			partition.set(x,String.valueOf(num));
			entry = tempEntry;
			for(int i = x+1;i<open;i++)
			{
				partition.remove(x+1);
			}
			partition.remove(x+1);
		}
			while(partition.indexOf("cos")!=-1)
			{
				int cos = partition.indexOf("cos");
				String result = String.valueOf(Math.cos(Double.parseDouble(partition.get(cos+1))));
				partition.set(cos, result);
				partition.remove(cos+1);
			}
			while(partition.indexOf("sin")!=-1)
			{
				int sin = partition.indexOf("sin");
				String result = String.valueOf(Math.sin(Double.parseDouble(partition.get(sin+1))));
				partition.set(sin, result);
				partition.remove(sin+1);
			}
			while(partition.indexOf("tan")!=-1)
			{
				int tan = partition.indexOf("tan");
				String result = String.valueOf(Math.tan(Double.parseDouble(partition.get(tan+1))));
				partition.set(tan, result);
				partition.remove(tan+1);
			}
			while(partition.indexOf("log")!=-1)
			{
				int log = partition.indexOf("log");
				String result = String.valueOf(Math.log(Double.parseDouble(partition.get(log+1)))/Math.log(10));
				partition.set(log, result);
				partition.remove(log+1);
			}
			while(partition.indexOf("ln")!=-1)
			{
				int ln = partition.indexOf("ln");
				String result = String.valueOf(Math.log(Double.parseDouble(partition.get(ln+1))));
				partition.set(ln, result);
				partition.remove(ln+1);
			}
			while(partition.indexOf("^")!=-1)
			{
				int exp = partition.indexOf("^");
				String result = String.valueOf(Math.pow(Double.parseDouble(partition.get(exp-1)),Double.parseDouble(partition.get(exp+1))));
				partition.set(exp, result);
				partition.remove(exp+1);
				partition.remove(exp-1);
			}
		while(partition.indexOf("*")!=-1&&partition.indexOf("/")!=-1)
		{
			int multiply = partition.indexOf("*");
			int divide = partition.indexOf("/");
			if(multiply<divide)
			{
				String result = String.valueOf((Double.parseDouble(partition.get(multiply-1))*Double.parseDouble(partition.get(multiply+1))));
				partition.set(multiply, result);
				partition.remove(multiply+1);
				partition.remove(multiply-1);
			}
			if(divide<multiply)
			{
				String result = String.valueOf((Double.parseDouble(partition.get(divide-1))/Double.parseDouble(partition.get(divide+1))));
				partition.set(divide, result);
				partition.remove(divide+1);
				partition.remove(divide-1);
			}
		}
		while(partition.indexOf("*")!=-1)
		{
			int multiply = partition.indexOf("*");
			String result = String.valueOf((Double.parseDouble(partition.get(multiply-1))*Double.parseDouble(partition.get(multiply+1))));
			partition.set(multiply, result);
			partition.remove(multiply+1);
			partition.remove(multiply-1);
		}
		while(partition.indexOf("/")!=-1)
				{
			int divide = partition.indexOf("/");

			String result = String.valueOf((Double.parseDouble(partition.get(divide-1))/Double.parseDouble(partition.get(divide+1))));
			partition.set(divide, result);
			partition.remove(divide+1);
			partition.remove(divide-1);
				}
		while(partition.indexOf("+")!=-1&&partition.indexOf("-")!=-1)
		{
			int add = partition.indexOf("+");
			int  subtract= partition.indexOf("-");
			if(add<subtract)
			{
				String result = String.valueOf((Double.parseDouble(partition.get(add-1))+Double.parseDouble(partition.get(add+1))));
				partition.set(add, result);
				partition.remove(add+1);
				partition.remove(add-1);
			}
			if(subtract<add)
			{
				String result = String.valueOf((Double.parseDouble(partition.get(subtract-1))-Double.parseDouble(partition.get(subtract+1))));
				partition.set(subtract, result);
				partition.remove(subtract+1);
				partition.remove(subtract-1);
			}
		}
		while(partition.indexOf("+")!=-1)
		{
	int add = partition.indexOf("+");
	String result = String.valueOf((Double.parseDouble(partition.get(add-1))+Double.parseDouble(partition.get(add+1))));
	partition.set(add, result);
	partition.remove(add+1);
	partition.remove(add-1);
		}		
		while(partition.indexOf("-")!=-1)
		{
	int subtract = partition.indexOf("-");
	boolean what = false;
	if(subtract==0)
	{
		what = true;
		partition.set(subtract,"-"+partition.get(subtract+1));
		partition.remove(subtract+1);
	}
	if(!what)
	{
		String result = String.valueOf((Double.parseDouble(partition.get(subtract-1))-Double.parseDouble(partition.get(subtract+1))));
		partition.set(subtract, result);
		partition.remove(subtract+1);
		partition.remove(subtract-1);	
	}
	
		}
		return Double.parseDouble(partition.get(0));
		/*entry +="&";
		double valueOne = 0;
		double valueTwo = 0;
		double decimal = 0.0;
		ArrayList<String> ops = new ArrayList<String>();
		ops.add("+");
		ops.add("/");
		ops.add("*");
		ops.add("-");
		ops.add("(");
		ops.add(")");
		

		String op = "";
		ArrayList<Double> list = new ArrayList<Double>();
		for(int i= 0;i<entry.length();i++)
		{

			if(entry.charAt(i)>47&&entry.charAt(i)<58)
			{
				list.add((double) Character.getNumericValue(entry.charAt(i)));
			}
			if(entry.charAt(i)<48)
			{
				if(entry.charAt(i)==46)
				{
					int j = i+1;
				while(entry.charAt(j)>47&&entry.charAt(j)<58)
				{
					j++;
				}
				decimal = j-i-1;
				continue;
				}
				if(valueOne == 0)
				{
					for(int j = 0;j<list.size();j++)
					{
						valueOne+=list.get(list.size()-1-j)*Math.pow(10,j);
					}
					valueOne/=Math.pow(10, decimal);
					decimal = 0;
					
				}
				if(valueOne!=0&&valueTwo == 0)
				{
					for(int j = 0;j<list.size();j++)
					{
						valueTwo+=list.get(list.size()-1-j)*Math.pow(10,j);
					}
					valueTwo/=Math.pow(10, decimal);
					decimal = 0;

				}
				if(valueOne !=0&&valueTwo!=0)
				{
					if(ops.indexOf(op)==0)
					{
						valueOne= valueOne+valueTwo;
					}
					if(ops.indexOf(op)==1)
					{
						valueOne= valueOne/valueTwo;
					}
					if(ops.indexOf(op)==2)
					{
						valueOne= valueOne*valueTwo;
					}
					if(ops.indexOf(op)==3)
					{
						valueOne= valueOne-valueTwo;
					}
					
					valueTwo = 0;
				}
				op = String.valueOf(entry.charAt(i));
				list.clear();
			}

		}
		entry = entry.replace("&", "");
		return valueOne;*/
	}
	public void Entry(Graphics window)
	{
		String[] operations = new String[26];
		operations[0] = "0";
		operations[1] = "1";
		operations[2] = "2";
		operations[3] = "3";
		operations[4] = "4";
		operations[5] = "5";
		operations[6] = "6";
		operations[7] = "7";
		operations[8] = "8";
		operations[9] = "9";
		operations[10] = ".";
		operations[11] = "(x)";
		operations[12] = "ln(";
		operations[13] = "-";
		operations[14] = "/";
		operations[15] = "*";
		operations[16] = "+";
		operations[17] = ")";
		operations[18] = "(";
		operations[19] = "sin(";
		operations[20] = "cos(";
		operations[21] = "tan(";
		operations[22] = "pi";
		operations[23] = "e";
		operations[24] = "^";
		operations[25] = "log(";



		for(int i = 0;i<13;i++)
		{
			
			if(mouseX>50*i&&mouseX<50*i+50&&mouseY<100)
			{	
				entry+=operations[i];
			}
			if(mouseX>50*i&&mouseX<50*i+50&&mouseY>100&&mouseY<200)
			{				
				entry+=operations[i+13];
			}
		}
		window.drawString(entry, 10, 250);

	}

	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
}
