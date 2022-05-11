package fri.vtipnaAplikacia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KlikNaJasne implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Tak by si sa mal začať učiť!!!");
        System.exit(0);
    }
}
