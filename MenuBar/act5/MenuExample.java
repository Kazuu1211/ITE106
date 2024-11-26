
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

public class MenuExample {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("My Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new JMenuItem("New"));
        fileMenu.add(new JMenuItem("Open"));

        JMenuItem closeItem = new JMenuItem("Close");
        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "Got an ActionEvent at " + new Date(e.getWhen()) +
                        " from " + e.getSource().getClass().getName(),
                        "Event Info",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        fileMenu.add(closeItem);

        JMenu editMenu = new JMenu("Edit");
        editMenu.add(new JMenuItem("Undo"));
        editMenu.add(new JMenuItem("Redo"));
        editMenu.add(new JMenuItem("Cut"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.setJMenuBar(menuBar);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
