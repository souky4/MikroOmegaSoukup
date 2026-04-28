public class Kniha {
    private String nazev;
    private String autor;
    private int rok;
    private String zanr;
    private boolean dostupnost;

    public Kniha(String nazev, String autor, int rok, String zanr, boolean dostupnost) {
        this.nazev = nazev;
        this.autor = autor;
        this.rok = rok;
        this.zanr = zanr;
        this.dostupnost = false;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public boolean isDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(boolean dostupnost) {
        this.dostupnost = dostupnost;
    }

    public String toString(){
        return nazev+" "+autor;
    }
}
