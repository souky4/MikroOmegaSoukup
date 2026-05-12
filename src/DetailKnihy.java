import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DetailKnihy extends JFrame {

    public DetailKnihy(HlavniOkno hlavni, Kniha kniha) {
        setTitle("Detail Knihy");
        setSize(300,200);
        setLayout(new GridLayout(6,1));
        setLocationRelativeTo(hlavni);

        add(new JLabel("nazev: "+ kniha.getNazev()));
        add(new JLabel("autor: "+ kniha.getAutor()));
        add(new JLabel("rok: "+ kniha.getRok()));
        add(new JLabel("zanr: "+ kniha.getZanr()));

        JLabel status = new JLabel("stav: "+ (kniha.isDostupnost() ? "Pujcena" : "Dostupna" ));
        add(status);

        JButton toggleBtn = new JButton("Zmenit stav");

        toggleBtn.addActionListener(e -> {
            kniha.setDostupnost(!kniha.isDostupnost());
            status.setText("stav: "+(kniha.isDostupnost() ? "Pujcena" : "Dostupna" ));
        });
        add(toggleBtn);
        setVisible(true);
    }
}
