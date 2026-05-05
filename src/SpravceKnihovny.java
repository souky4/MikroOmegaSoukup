import java.util.ArrayList;
import java.util.List;

public class SpravceKnihovny {
        private List<Kniha> knihy = new ArrayList<>();


        public void pridejKnihu(Kniha k){
            knihy.add(k);
        }

        public void odeberKnihu(Kniha k){
            knihy.remove(k);
        }

        public List<Kniha> getKnihy(){
            return knihy;
        }

        public List<Kniha> najdiKnihu(String klicoveSlovo){
            List<Kniha> vysledek = new ArrayList<>();

            for(Kniha kniha : knihy){
                if(kniha.getNazev().toLowerCase().contains(klicoveSlovo.toLowerCase())||
                kniha.getAutor().toLowerCase().contains(klicoveSlovo.toLowerCase()));{
                    vysledek.add(kniha);
                }

            }
            return vysledek;
        }


}
