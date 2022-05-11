package fri.vtipnaAplikacia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VtipneOkno {
    private final JFrame okno;

    public VtipneOkno() {
        this.okno = new JFrame("Vtipna aplikacia");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(new JLabel("Chceš úspešne ukončiť predmet Informatika 2?"), BorderLayout.NORTH);

        JPanel tlacitka = new JPanel();
        tlacitka.setLayout(new GridLayout());

        JButton jasne = new JButton("Jasné");
        jasne.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Tak by si sa mal začať učiť!!!");
            System.exit(0);
        });
        tlacitka.add(jasne, BorderLayout.WEST);

        tlacitka.add(new JButton("Nie"), BorderLayout.EAST);
        this.okno.add(tlacitka, BorderLayout.CENTER);

        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
