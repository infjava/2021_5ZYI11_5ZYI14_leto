package fri.student;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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

        DocumentListener textFieldChangeListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                HlavneOkno.this.textFieldUpdate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                HlavneOkno.this.textFieldUpdate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                HlavneOkno.this.textFieldUpdate();
            }
        };

        this.menoTextField.getDocument().addDocumentListener(textFieldChangeListener);
        this.priezviskoTextField.getDocument().addDocumentListener(textFieldChangeListener);
        this.skupinaTextField.getDocument().addDocumentListener(textFieldChangeListener);

        this.textFieldUpdate();
    }

    private void textFieldUpdate() {
        boolean niecoPrazdne = this.menoTextField.getText().isEmpty()
                || this.priezviskoTextField.getText().isEmpty()
                || this.skupinaTextField.getText().isEmpty();

        this.pridajButton.setEnabled(!niecoPrazdne);
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
