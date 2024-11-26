
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloWorld {
    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloWorld!");
        frame.setSize(220, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton button = new JButton("HelloWorld!");
        
        MyActionListener listener = new MyActionListener();
        button.addActionListener(listener);
		
		frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(button);
        frame.setVisible(true);
      
    }
}
