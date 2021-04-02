import javax.swing.JFrame;
public class runCalculator extends JFrame{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	public runCalculator()
	{
		super("Calculator");
		setSize(WIDTH,HEIGHT);
		getContentPane().add(new CalculatorPanel());
		
		setVisible(true);

	}
	public static void main(String[] Args)
	{
		runCalculator run = new runCalculator();
		
	}
}
