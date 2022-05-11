package fri.vtipnaAplikacia;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame okno = new JFrame("Vtipna aplikacia");
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        okno.add(new JLabel("Chceš úspešne ukončiť predmet Informatika 2?"));
        okno.pack();
        okno.setVisible(true);
    }
}
