package fri.vtipnaAplikacia;

import javax.swing.*;

public class VtipneOkno extends JFrame {
    public VtipneOkno() {
        super("Vtipna aplikacia");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(new JLabel("Chceš úspešne ukončiť predmet Informatika 2?"));
        this.pack();
    }

    public void zobraz() {
        this.setVisible(true);
    }
}
