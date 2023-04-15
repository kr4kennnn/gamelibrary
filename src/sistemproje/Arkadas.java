package sistemproje;

import java.util.ArrayList;
import java.util.List;

public class Arkadas {

    int id = 0;
    String ad = "";
    String soyad = "";
    List<Oyun> istek_listesi = new ArrayList();
    List<Oyun> oyunlar = new ArrayList();

    public Arkadas() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return this.ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return this.soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
}
