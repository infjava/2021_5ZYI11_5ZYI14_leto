package fri.vtipnaAplikacia;

import javax.swing.*;
import java.awt.*;

public class VtipneOkno {
    private final JFrame okno;

    public VtipneOkno() {
        this.okno = new JFrame("Vtipna aplikacia");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(new JLabel("Chceš úspešne ukončiť predmet Informatika 2?"), BorderLayout.NORTH);
        this.okno.add(new JButton("Jasné"), BorderLayout.WEST);
        this.okno.add(new JButton("Nie"), BorderLayout.EAST);
        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
