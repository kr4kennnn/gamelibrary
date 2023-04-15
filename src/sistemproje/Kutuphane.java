package sistemproje;

import java.util.*;

public class Kutuphane {

    int hesap_id = 0;
    List<Oyun> oyunlar = new ArrayList();

    public Kutuphane(int hesap_id, List<Oyun> oyunlar) {
        this.hesap_id = hesap_id;
        this.oyunlar = oyunlar;
    }

    public int getHesap_id() {
        return this.hesap_id;
    }

    public void setHesap_id(int hesap_id) {
        this.hesap_id = hesap_id;
    }

    public List<Oyun> getOyunlar() {
        return this.oyunlar;
    }

    public void setOyunlar(List<Oyun> oyunlar) {
        this.oyunlar = oyunlar;
    }
}
