package sistemproje;

import java.util.ArrayList;
import java.util.List;

public class Veritabani {

    public Veritabani() {
    }

    public List<Oyun> magaza_oyunlarini_al() {
        List<Oyun> oyun_listesi = new ArrayList();
        oyun_listesi.add(new Oyun(1, "Call Of Duty - WW II", "Action", 450.0D, 3.9D, false, 0.0D, 4.3D));
        oyun_listesi.add(new Oyun(2, "Spider Man 2", "Action", 250.0D, 3.8D, false, 0.0D, 0.0D));
        oyun_listesi.add(new Oyun(3, "Ark Survivor Evolved", "Adventure", 100.0D, 3.2D, true, 50.0D, 3.0D));
        oyun_listesi.add(new Oyun(4, "Resident Evil 7", "FPS", 500.0D, 4.5D, false, 0.0D, 0.0D));
        oyun_listesi.add(new Oyun(5, "Tekken 7", "Fight", 500.0D, 4.2D, false, 0.0D, 0.0D));
        oyun_listesi.add(new Oyun(6, "Tetris Effect", "Puzzle", 200.0D, 5.0D, false, 0.0D, 0.0D));
        oyun_listesi.add(new Oyun(7, "God of War 3", "Action", 600.0D, 4.7D, false, 0.0D, 0.0D));
        return oyun_listesi;
    }

    public List<Hesap> magaza_hesaplarini_al() {
        List<Hesap> magaza_hesaplar = new ArrayList();
        List<Oyun> oyun_listesi0 = new ArrayList();
        oyun_listesi0.add(new Oyun(1, "Call Of Duty - WW II", "Action", 450.0D, 3.9D, false, 0.0D, 4.3D));
        oyun_listesi0.add(new Oyun(3, "Ark Survivor Evolved", "Adventure", 100.0D, 3.2D, true, 50.0D, 3.0D));
        oyun_listesi0.add(new Oyun(4, "Resident Evil 7", "FPS", 500.0D, 4.5D, false, 0.0D, 0.0D));
        List<Oyun> istek_listesi0 = new ArrayList();
        istek_listesi0.add(new Oyun(5, "Tekken 7", "Fight", 500.0D, 4.2D, false, 0.0D, 0.0D));
        int[] arkadas_array0 = new int[]{1};
        Kutuphane kutuphane0 = new Kutuphane(0, oyun_listesi0);
        magaza_hesaplar.add(new Hesap(0, "Nuraddin", "OSMANLI", "xxxx", "xxxx-xxxx-xxxx-xxxx", arkadas_array0, kutuphane0, istek_listesi0));
        List<Oyun> oyun_listesi1 = new ArrayList();
        oyun_listesi1.add(new Oyun(2, "Spider Man 2", "Action", 250.0D, 3.8D, false, 0.0D, 0.0D));
        List<Oyun> istek_listesi1 = new ArrayList();
        istek_listesi1.add(new Oyun(4, "Resident Evil 7", "FPS", 500.0D, 4.5D, false, 0.0D, 0.0D));
        int[] arkadas_array1 = new int[1];
        Kutuphane kutuphane1 = new Kutuphane(1, oyun_listesi1);
        magaza_hesaplar.add(new Hesap(1, "Tural", "AZIMOV", "xxxx", "xxxx-xxxx-xxxx-xxxx", arkadas_array1, kutuphane1, istek_listesi1));
        return magaza_hesaplar;
    }
}
