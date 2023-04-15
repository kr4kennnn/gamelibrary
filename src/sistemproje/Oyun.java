package sistemproje;

public class Oyun {

    int id = 0;
    String ad = "";
    String tur = "";
    double fiyat = 0.0D;
    double puan = 0.0D;
    boolean indirimde_mi = false;
    double indirimli_fiyat = 0.0D;
    double kullanici_puan = 0.0D;

    public Oyun(int id, String ad, String tur, double fiyat, double puan, boolean indirimde_mi, double indirimli_fiyat, double kullanici_puan) {
        this.id = id;
        this.ad = ad;
        this.tur = tur;
        this.fiyat = fiyat;
        this.puan = puan;
        this.indirimde_mi = indirimde_mi;
        this.indirimli_fiyat = indirimli_fiyat;
        this.kullanici_puan = kullanici_puan;
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

    public String getTur() {
        return this.tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public double getFiyat() {
        return this.fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public double getPuan() {
        return this.puan;
    }

    public void setPuan(double puan) {
        this.puan = puan;
    }

    public boolean isIndirimde_mi() {
        return this.indirimde_mi;
    }

    public void setIndirimde_mi(boolean indirimde_mi) {
        this.indirimde_mi = indirimde_mi;
    }

    public double getIndirimli_fiyat() {
        return this.indirimli_fiyat;
    }

    public void setIndirimli_fiyat(double indirimli_fiyat) {
        this.indirimli_fiyat = indirimli_fiyat;
    }

    public double getKullanici_puan() {
        return this.kullanici_puan;
    }

    public void setKullanici_puan(double kullanici_puan) {
        this.kullanici_puan = kullanici_puan;
    }
}
