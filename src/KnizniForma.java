import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class KnizniForma extends JFrame {
    public KnizniForma(HlavniOkno hlO, SpravceKnihovny spravce, Kniha kniha) {
        setTitle(kniha == null ? "pridat knihu" : "upravit knihu");
        setSize(300, 250);
        setLayout(new GridLayout(5,2));
        setLocationRelativeTo(hlO);

        JTextField title = new JTextField();
        JTextField autor = new JTextField();
        JTextField rok = new JTextField();
        JTextField zanr = new JTextField();

        if(kniha != null) {
            title.setText(kniha.getNazev());
            autor.setText(kniha.getAutor());
            rok.setText(String.valueOf(kniha.getRok()));
            zanr.setText(kniha.getZanr());
        }

        add(new JLabel("Nazev"));
        add(title);

        add(new JLabel("Autor"));
        add(autor);

        add(new JLabel("Rok"));
        add(rok);

        add(new JLabel("Zanr"));
        add(zanr);

        JButton saveBtn = new JButton("Ulouzit");
        saveBtn.addActionListener(e -> {
            if(kniha == null){
                spravce.pridejKnihu(new Kniha(
                        title.getText(),
                        autor.getText(),
                        Integer.parseInt(rok.getText()),
                        zanr.getText()
                ));
            } else {
                kniha.setNazev(title.getText());
                kniha.setAutor(autor.getText());
                kniha.setRok(Integer.parseInt(rok.getText()));
                kniha.setZanr(zanr.getText());
            }
            hlO.refreshList();
            dispose();
        });

        add(saveBtn);
        setVisible(true);




    }
}
