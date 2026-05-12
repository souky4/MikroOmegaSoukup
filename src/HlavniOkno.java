import javax.swing.*;
import java.awt.*;
import java.awt.print.Book;

public class HlavniOkno extends JFrame {
    private SpravceKnihovny spravce;
    private DefaultListModel<Kniha> listModel;
    private JList<Kniha> bookList;
    private JTextField serchField;

    public HlavniOkno (SpravceKnihovny spravce){
        this.spravce = spravce;

        setTitle("Spravce Knihovny");
        setSize(600,400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        listModel = new DefaultListModel<>();
        bookList = new JList<>(listModel);

        refreshList();

        JPanel horniPanel = new JPanel();
        serchField = new JTextField(20);

        JButton serchBtn = new JButton("Hledat");
        serchBtn.addActionListener(e -> serchBooks());

        horniPanel.add(serchField);
        horniPanel.add(serchBtn);

        add(horniPanel, BorderLayout.NORTH);

        add(new JScrollPane(bookList),BorderLayout.CENTER);

        JPanel spodniPanel =  new JPanel();

        JButton addBtn =  new JButton("Pridat");
        JButton deleteBtn = new JButton("Smazat");
        JButton detailBtn = new JButton("Detail");

        addBtn.addActionListener(e -> new KnizniForma(this,spravce,null));
        deleteBtn.addActionListener(e -> deleteBook());
        detailBtn.addActionListener(e -> showDetail());

        spodniPanel.add(addBtn);
        spodniPanel.add(deleteBtn);
        spodniPanel.add(detailBtn);

        add(spodniPanel, BorderLayout.SOUTH);


        setVisible(true);
    }
    public void refreshList(){
        listModel.clear();
        for(Kniha kniha : spravce.getKnihy()){
            listModel.addElement(kniha);
        }
    }
    private void serchBooks(){
        listModel.clear();

        for(Kniha kniha : spravce.najdiKnihu(serchField.getText())){
            listModel.addElement(kniha);
        }

    }
    private void deleteBook(){
        Kniha selected = bookList.getSelectedValue();
        if(selected != null){
            spravce.odeberKnihu(selected);
            refreshList();
        }
    }

    private void showDetail() {
        Kniha selected = bookList.getSelectedValue();
        if (selected != null) {
            new DetailKnihy (this, selected);
        }
    }


}
