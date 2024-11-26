import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloWorld {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello World!");
		frame.setSize(220, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(null);
		
		JButton button = new JButton("HelloWorld!");
		button.addActionListener(new MyActionListener());
		button.setLocation(30, 30);
		button.setSize(150, 100);
		contentPane.add(button);
		                                   
		frame.setVisible(true);
	}
}  
