package sistemproje;

import java.util.ArrayList;
import java.util.List;

public class Hesap {

    int id = 0;
    String ad = "";
    String soyad = "";
    String sifre = "";
    String kredi_karti = "";
    int[] arkadaslar = new int[0];
    Kutuphane kutuphane = new Kutuphane(0, (List) null);
    List<Oyun> istek_listesi = new ArrayList();

    public Hesap(int id, String ad, String soyad, String sifre, String kredi_karti, int[] arkadaslar, Kutuphane kutuphane, List<Oyun> istek_listesi) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.sifre = sifre;
        this.kredi_karti = kredi_karti;
        this.arkadaslar = arkadaslar;
        this.kutuphane = kutuphane;
        this.istek_listesi = istek_listesi;
    }

    public Kutuphane getKutuphane() {
        return this.kutuphane;
    }

    public void setKutuphane(Kutuphane kutuphane) {
        this.kutuphane = kutuphane;
    }

    public String getAd() {
        return this.ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSifre() {
        return this.sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getKredi_karti() {
        return this.kredi_karti;
    }

    public void setKredi_karti(String kredi_karti) {
        this.kredi_karti = kredi_karti;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoyad() {
        return this.soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public List<Oyun> getIstek_listesi() {
        return this.istek_listesi;
    }

    public void setIstek_listesi(List<Oyun> istek_listesi) {
        this.istek_listesi = istek_listesi;
    }

    public int[] getArkadaslar() {
        return this.arkadaslar;
    }

    public void setArkadaslar(int[] arkadaslar) {
        this.arkadaslar = arkadaslar;
    }
}
