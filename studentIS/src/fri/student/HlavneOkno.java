package fri.student;

import javax.swing.*;

public class HlavneOkno {
    private final JFrame okno;
    private JList zoznamStudentovList;
    private JPanel obsahOknaPanel;

    public HlavneOkno() {
        this.okno = new JFrame("IS Študent");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(this.obsahOknaPanel);
        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
