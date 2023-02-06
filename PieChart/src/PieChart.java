import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PieChar extends JFrame{

	JPanel menuPane = new JPanel();
	JTextField tf[] = new JTextField[3];
	MyPanel chartPane = new MyPanel();
	
	
	int val[] = {0, 0, 0};
	
	PieChar()
	{
		setTitle("PieChar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		// menuPane
		menuPane.setLayout(new FlowLayout());
		menuPane.setBackground(Color.PINK);
		c.add(BorderLayout.NORTH, menuPane);
		String[] names = {"수영", "스킨스쿠버", "수상스키"};
		
		MyActionListener l = new MyActionListener();
		
		for(int i = 0; i < tf.length; i++)
		{
			tf[i] = new JTextField(10);
			tf[i].addActionListener(l);
			menuPane.add(new JLabel(names[i]));
			menuPane.add(tf[i]);
		}
		
		// chartPane
		c.add(BorderLayout.CENTER, chartPane);
		
		setSize(600, 300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel
	{

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int v = 0, offset = 0;
			
			Color c[] = {Color.RED, Color.GREEN, Color.BLUE};
			
			for(int i = 0; i < val.length; i++)
			{
				g.setColor(c[i]);
				v = (int)(val[i]*3.6);
				g.fillArc(200, 50, 150, 150, offset, v);
				offset += v;
			}
			/*g.setColor(c[0]);
			v = (int)(val[0]*3.6);
			g.fillArc(200, 50, 150, 150, offset, v);
			offset += v;
			
			g.setColor(c[1]);
			v = (int)(val[1]*3.6);
			g.fillArc(200, 50, 150, 150, offset, v);
			offset += v;
			
			g.setColor(c[2]);
			v = (int)(val[2]*3.6);
			g.fillArc(200, 50, 150, 105, offset, v);
			offset += v;*/
		}
		
	}
	
	class MyActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField textf = (JTextField)e.getSource();
			
			for(int i = 0; i < tf.length; i++)
			{
				if(textf == tf[0]) 
				{
					val[i] = Integer.parseInt(tf[i].getText());
					System.out.println(i+","+val[i]);
				}					
			}
			chartPane.repaint();
			
		}
		
	}
	
	public static void main(String[] args) {
		new PieChar();

	}

}
