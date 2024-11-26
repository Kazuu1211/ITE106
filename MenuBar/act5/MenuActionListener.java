
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MenuActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(MenuExample.frame,
            "Got an ActionEvent at " + new Date(e.getWhen()) +
            " from " + e.getSource().getClass());
    }
}
