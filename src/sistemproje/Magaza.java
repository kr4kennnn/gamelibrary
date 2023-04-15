package sistemproje;

import java.util.ArrayList;
import java.util.List;

public class Magaza {

    List<Hesap> magaza_hesaplar = new ArrayList();
    List<Oyun> magaza_oyunlar = new ArrayList();

    public Magaza(List<Hesap> magaza_hesaplar, List<Oyun> magaza_oyunlar) {
        this.magaza_hesaplar = magaza_hesaplar;
        this.magaza_oyunlar = magaza_oyunlar;
    }

    public Hesap hesap_bilgilerimi_al(int hesap_id) {
        Hesap hesabim = (Hesap) this.getMagaza_hesaplar().get(hesap_id);
        return hesabim;
    }

    public List<Hesap> getMagaza_hesaplar() {
        return this.magaza_hesaplar;
    }

    public void setMagaza_hesaplar(List<Hesap> magaza_hesaplar) {
        this.magaza_hesaplar = magaza_hesaplar;
    }

    public List<Oyun> getMagaza_oyunlar() {
        return this.magaza_oyunlar;
    }

    public void setMagaza_oyunlar(List<Oyun> magaza_oyunlar) {
        this.magaza_oyunlar = magaza_oyunlar;
    }
}
