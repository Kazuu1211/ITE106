import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

public class MenuActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(MenuExample.frame,
            "Got an Action Event at " + new Date(e.getWhen())
			+ " from " + e.getSource().getClass()
        );
    }
}
