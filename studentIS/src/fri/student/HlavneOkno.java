package fri.student;

import javax.swing.*;

public class HlavneOkno {
    private final JFrame okno;
    private final DefaultListModel<Student> zoznam;
    private JList<Student> zoznamStudentovList;
    private JPanel obsahOknaPanel;

    public HlavneOkno() {
        this.zoznam = new DefaultListModel<>();
        this.zoznamStudentovList.setModel(this.zoznam);

        this.okno = new JFrame("IS Študent");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(this.obsahOknaPanel);
        this.okno.pack();

        // testovanie
        this.zoznam.addElement(new Student("Jozko", "Mrkvicka", "5ZYI99"));
        this.zoznam.addElement(new Student("Ferko", "Mrkvicka", "5ZYI99"));
        this.zoznam.addElement(new Student("Jano", "Kalerab", "5ZYI99"));
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
