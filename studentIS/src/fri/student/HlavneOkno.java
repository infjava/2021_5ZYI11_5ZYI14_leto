package fri.student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HlavneOkno {
    private final JFrame okno;
    private final DefaultListModel<Student> zoznam;
    private JList<Student> zoznamStudentovList;
    private JPanel obsahOknaPanel;
    private JTextField menoTextField;
    private JTextField priezviskoTextField;
    private JTextField skupinaTextField;
    private JButton pridajButton;
    private JButton odstranButton;
    private JButton upravButton;
    private JButton vyhladajButton;

    public HlavneOkno() {
        this.zoznam = new DefaultListModel<>();
        this.zoznamStudentovList.setModel(this.zoznam);

        this.okno = new JFrame("IS Študent");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(this.obsahOknaPanel);
        this.okno.pack();

        this.okno.getRootPane().setDefaultButton(this.pridajButton);

        this.pridajButton.addActionListener(e -> this.pridajButtonActionPerformed());
    }

    private void pridajButtonActionPerformed() {
        this.zoznam.addElement(
                new Student(
                        this.menoTextField.getText(),
                        this.priezviskoTextField.getText(),
                        this.skupinaTextField.getText()
                )
        );

        this.menoTextField.setText("");
        this.priezviskoTextField.setText("");
        this.skupinaTextField.setText("");

        this.menoTextField.grabFocus();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
