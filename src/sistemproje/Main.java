package sistemproje;

import java.util.*;

public class Main {

    Veritabani veritabani = new Veritabani();
    Magaza magaza;

    public Main() {
        this.magaza = new Magaza(this.veritabani.magaza_hesaplarini_al(), this.veritabani.magaza_oyunlarini_al());
    }

    public void ana_menu_goster() {
        String secim = "0";
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("");
            System.out.println("");
            System.out.println("DİJİTAL OYUN MAĞAZASI ANA MENÜ");
            System.out.println("");
            System.out.println("1. Hesap Bilgileri");
            System.out.println("2. Mağazada Alış/Veriş");
            System.out.println("3. Kütüphanem");
            System.out.println("4. Arkadaşlarım");
            System.out.println("0. Çıkış");
            System.out.print("Lütfen menüden bir seçim yapınız : ");
            secim = scanner.nextLine();
            switch (secim.hashCode()) {
                case 48:
                    if (secim.equals("0")) {
                        System.out.println("Programdan çıkıldı.");
                        System.exit(0);
                    }
                    break;
                case 49:
                    if (secim.equals("1")) {
                        this.hesap_bilgileri_menu_goster();
                    }
                    break;
                case 50:
                    if (secim.equals("2")) {
                        this.magaza_alis_veris();
                    }
                    break;
                case 51:
                    if (secim.equals("3")) {
                        this.kutuphanem();
                    }
                    break;
                case 52:
                    if (secim.equals("4")) {
                        this.arkadaslarim();
                    }
            }
        } while (secim != "0");

        scanner.close();
    }

    public void hesap_bilgileri_menu_goster() {
        Hesap hesap_bilgisi = this.magaza.hesap_bilgilerimi_al(0);
        List<Oyun> istek_listesi = hesap_bilgisi.getIstek_listesi();
        String secim = "0";
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("");
            System.out.println("");
            System.out.println("Hesap Bilgileri Alt Menü");
            System.out.println("");
            System.out.println("Hesap Sahibi Adı : " + hesap_bilgisi.getAd());
            System.out.println("Hesap Sahibi Soyadı : " + hesap_bilgisi.getSoyad());
            System.out.println("Şifre Bilgisi : " + hesap_bilgisi.getSifre());
            System.out.println("Kredi Kartı Bilgileri : " + hesap_bilgisi.getKredi_karti());
            System.out.println("İstek Listem : ");
            Iterator var6 = istek_listesi.iterator();

            while (var6.hasNext()) {
                Oyun oyunum = (Oyun) var6.next();
                System.out.println(oyunum.getId() + "\t- Oyun adı : " + oyunum.getAd() + "\tTürü : " + oyunum.getTur() + "\tFiyatı : " + oyunum.getFiyat());
            }

            System.out.println("");
            System.out.println("-1. Bir Önceki Menü");
            System.out.println("0. Ana Menü");
            System.out.print("Lütfen menüden bir seçim yapınız : ");
            secim = scanner.nextLine();
            switch (secim.hashCode()) {
                case 48:
                    if (secim.equals("0")) {
                        this.ana_menu_goster();
                    }
                    break;
                case 1444:
                    if (secim.equals("-1")) {
                        this.ana_menu_goster();
                    }
            }
        } while (secim != "0");

        scanner.close();
    }

    public void oyunlari_sirali_listele(String siralama_Tipi) {
        String secim = "0";
        Scanner scanner = new Scanner(System.in);
        List<Oyun> magaza_oyun_listesi = this.magaza.getMagaza_oyunlar();
        if (siralama_Tipi.compareTo("Ad") == 0) {
            Collections.sort(magaza_oyun_listesi, new Comparator<Oyun>() {
                public int compare(Oyun oyunOne, Oyun OyunTwo) {
                    return oyunOne.getAd().compareTo(OyunTwo.getAd());
                }
            });
        } else if (siralama_Tipi.compareTo("Tür") == 0) {
            Collections.sort(magaza_oyun_listesi, new Comparator<Oyun>() {
                public int compare(Oyun oyunOne, Oyun OyunTwo) {
                    return oyunOne.getTur().compareTo(OyunTwo.getTur());
                }
            });
        } else if (siralama_Tipi.compareTo("Fiyat") == 0) {
            Collections.sort(magaza_oyun_listesi, new Comparator<Oyun>() {
                public int compare(Oyun oyunOne, Oyun OyunTwo) {
                    if (oyunOne.getFiyat() < OyunTwo.getFiyat()) {
                        return -1;
                    } else {
                        return oyunOne.getFiyat() > OyunTwo.getFiyat() ? 1 : 0;
                    }
                }
            });
        } else if (siralama_Tipi.compareTo("Puan") == 0) {
            Collections.sort(magaza_oyun_listesi, new Comparator<Oyun>() {
                public int compare(Oyun oyunOne, Oyun OyunTwo) {
                    if (oyunOne.getPuan() < OyunTwo.getPuan()) {
                        return -1;
                    } else {
                        return oyunOne.getPuan() > OyunTwo.getPuan() ? 1 : 0;
                    }
                }
            });
        }

        do {
            System.out.println("");
            System.out.println("");
            System.out.println("Oyunları Sıralı Listele Alt Menü (" + siralama_Tipi + ")");
            System.out.println("");
            System.out.println("Mağaza Oyun Listesi : ");
            Iterator var6 = magaza_oyun_listesi.iterator();

            while (var6.hasNext()) {
                Oyun oyunum = (Oyun) var6.next();
                if (!oyunum.isIndirimde_mi()) {
                    System.out.println(oyunum.getId() + "\t- Oyun adı : " + oyunum.getAd() + "\tTürü : " + oyunum.getTur() + "\tFiyatı : " + oyunum.getFiyat() + "\tPuanı : " + oyunum.getPuan());
                } else {
                    System.out.println(oyunum.getId() + "\t- Oyun adı : " + oyunum.getAd() + "\tTürü : " + oyunum.getTur() + "\tFiyatı : " + oyunum.getFiyat() + "\tİndirimli Fiyatı : " + oyunum.getIndirimli_fiyat() + "\tPuanı : " + oyunum.getPuan());
                }
            }

            System.out.println("");
            System.out.println("1. Oyunları Adına Göre Listele");
            System.out.println("2. Oyunları Fiyata Göre Listele");
            System.out.println("3. Oyunları Türe Göre Listele");
            System.out.println("4. Oyunları Puanına Göre Listele");
            System.out.println("-1. Bir Önceki Menü");
            System.out.println("0. Ana Menü");
            System.out.print("Lütfen menüden bir seçim yapınız : ");
            secim = scanner.nextLine();
            switch (secim.hashCode()) {
                case 48:
                    if (secim.equals("0")) {
                        this.ana_menu_goster();
                    }
                    break;
                case 49:
                    if (secim.equals("1")) {
                        this.oyunlari_sirali_listele("Ad");
                    }
                    break;
                case 50:
                    if (secim.equals("2")) {
                        this.oyunlari_sirali_listele("Fiyat");
                    }
                    break;
                case 51:
                    if (secim.equals("3")) {
                        this.oyunlari_sirali_listele("Tür");
                    }
                    break;
                case 52:
                    if (secim.equals("4")) {
                        this.oyunlari_sirali_listele("Puan");
                    }
                    break;
                case 1444:
                    if (secim.equals("-1")) {
                        this.magaza_alis_veris();
                    }
            }
        } while (secim != "0");

        scanner.close();
    }

    public void magaza_alis_veris() {
        String secim = "0";
        Scanner scanner = new Scanner(System.in);
        Hesap hesap_bilgisi = this.magaza.hesap_bilgilerimi_al(0);
        List<Oyun> magaza_oyun_listesi = this.magaza.getMagaza_oyunlar();
        Collections.sort(magaza_oyun_listesi, new Comparator<Oyun>() {
            public int compare(Oyun oyunOne, Oyun OyunTwo) {
                if (oyunOne.getFiyat() < OyunTwo.getFiyat()) {
                    return -1;
                } else {
                    return oyunOne.getFiyat() > OyunTwo.getFiyat() ? 1 : 0;
                }
            }
        });

        do {
            System.out.println("");
            System.out.println("");
            System.out.println("Mağaza Alışveriş Alt Menü");
            System.out.println("");
            System.out.println("Mağaza Oyun Listesi : ");
            Iterator var6 = magaza_oyun_listesi.iterator();

            Oyun istek_oyunum;
            while (var6.hasNext()) {
                istek_oyunum = (Oyun) var6.next();
                if (!istek_oyunum.isIndirimde_mi()) {
                    System.out.println(istek_oyunum.getId() + "\t- Oyun adı : " + istek_oyunum.getAd() + "\tTürü : " + istek_oyunum.getTur() + "\tFiyatı : " + istek_oyunum.getFiyat() + "\tPuanı : " + istek_oyunum.getPuan());
                } else {
                    System.out.println(istek_oyunum.getId() + "\t- Oyun adı : " + istek_oyunum.getAd() + "\tTürü : " + istek_oyunum.getTur() + "\tFiyatı : " + istek_oyunum.getFiyat() + "\tİndirimli Fiyatı : " + istek_oyunum.getIndirimli_fiyat() + "\tPuanı : " + istek_oyunum.getPuan());
                }
            }

            System.out.println("");
            System.out.println("Güncel Oyun Listem : ");
            var6 = hesap_bilgisi.getKutuphane().getOyunlar().iterator();

            while (var6.hasNext()) {
                istek_oyunum = (Oyun) var6.next();
                System.out.println(istek_oyunum.getId() + "\t- Oyun adı : " + istek_oyunum.getAd() + "\tTürü : " + istek_oyunum.getTur() + "\tFiyatı : " + istek_oyunum.getFiyat());
            }

            System.out.println("");
            System.out.println("Güncel İstek Listem : ");
            var6 = hesap_bilgisi.getIstek_listesi().iterator();

            while (var6.hasNext()) {
                istek_oyunum = (Oyun) var6.next();
                System.out.println(istek_oyunum.getId() + "\t- Oyun adı : " + istek_oyunum.getAd() + "\tTürü : " + istek_oyunum.getTur() + "\tFiyatı : " + istek_oyunum.getFiyat());
            }

            System.out.println("");
            System.out.println("1. Mağaza Oyunlarını Sıralı Listele");
            System.out.println("2. Oyun Satın Al");
            System.out.println("3. Oyunu İstek Listene Ekle");
            System.out.println("-1. Bir Önceki Menü");
            System.out.println("0. Ana Menü");
            System.out.print("Lütfen menüden bir seçim yapınız : ");
            secim = scanner.nextLine();
            switch (secim.hashCode()) {
                case 48:
                    if (secim.equals("0")) {
                        this.ana_menu_goster();
                    }
                    break;
                case 49:
                    if (secim.equals("1")) {
                        this.oyunlari_sirali_listele("Fiyat");
                    }
                    break;
                case 50:
                    if (secim.equals("2")) {
                        this.oyun_satin_al();
                    }
                    break;
                case 51:
                    if (secim.equals("3")) {
                        this.oyunu_istek_listene_ekle();
                    }
                    break;
                case 1444:
                    if (secim.equals("-1")) {
                        this.ana_menu_goster();
                    }
            }
        } while (secim != "0");

        scanner.close();
    }

    public void oyun_satin_al() {
        String oyun_secim = "0";
        String secim = "0";
        Scanner scanner = new Scanner(System.in);
        Hesap hesap_bilgisi = this.magaza.hesap_bilgilerimi_al(0);
        List<Oyun> magaza_oyun_listesi = this.magaza.getMagaza_oyunlar();
        Collections.sort(magaza_oyun_listesi, new Comparator<Oyun>() {
            public int compare(Oyun oyunOne, Oyun OyunTwo) {
                if (oyunOne.getFiyat() < OyunTwo.getFiyat()) {
                    return -1;
                } else {
                    return oyunOne.getFiyat() > OyunTwo.getFiyat() ? 1 : 0;
                }
            }
        });
        Iterator var7 = hesap_bilgisi.getKutuphane().getOyunlar().iterator();

        while (true) {
            Oyun magaza_oyun;
            Oyun oyunum;
            Iterator var9;
            while (var7.hasNext()) {
                magaza_oyun = (Oyun) var7.next();
                var9 = magaza_oyun_listesi.iterator();

                while (var9.hasNext()) {
                    oyunum = (Oyun) var9.next();
                    if (magaza_oyun.getId() == oyunum.getId()) {
                        magaza_oyun_listesi.remove(oyunum);
                        break;
                    }
                }
            }

            do {
                System.out.println("");
                System.out.println("");
                System.out.println("Oyun Satın Al Alt Menü");
                System.out.println("");
                System.out.println("Mağaza Oyun Listesi : ");
                var7 = magaza_oyun_listesi.iterator();

                while (var7.hasNext()) {
                    magaza_oyun = (Oyun) var7.next();
                    if (!magaza_oyun.isIndirimde_mi()) {
                        System.out.println(magaza_oyun.getId() + "\t- Oyun adı : " + magaza_oyun.getAd() + "\tTürü : " + magaza_oyun.getTur() + "\tFiyatı : " + magaza_oyun.getFiyat() + "\tPuanı : " + magaza_oyun.getPuan());
                    } else {
                        System.out.println(magaza_oyun.getId() + "\t- Oyun adı : " + magaza_oyun.getAd() + "\tTürü : " + magaza_oyun.getTur() + "\tFiyatı : " + magaza_oyun.getFiyat() + "\tİndirimli Fiyatı : " + magaza_oyun.getIndirimli_fiyat() + "\tPuanı : " + magaza_oyun.getPuan());
                    }
                }

                System.out.println("");
                System.out.println("Kredi Kartı Bilgileri : " + hesap_bilgisi.getKredi_karti());
                System.out.println("");
                System.out.println("Güncel Oyun Listem : ");
                var7 = hesap_bilgisi.getKutuphane().getOyunlar().iterator();

                while (var7.hasNext()) {
                    magaza_oyun = (Oyun) var7.next();
                    System.out.println(magaza_oyun.getId() + "\t- Oyun adı : " + magaza_oyun.getAd() + "\tTürü : " + magaza_oyun.getTur() + "\tFiyatı : " + magaza_oyun.getFiyat());
                }

                System.out.println("");
                System.out.println("Satın Alınacak Oyun Numarasını Giriniz : ");
                oyun_secim = scanner.nextLine();
                var7 = magaza_oyun_listesi.iterator();

                while (var7.hasNext()) {
                    magaza_oyun = (Oyun) var7.next();
                    if (magaza_oyun.getId() == Integer.valueOf(oyun_secim)) {
                        hesap_bilgisi.getKutuphane().getOyunlar().add(magaza_oyun);
                        this.magaza.getMagaza_hesaplar().set(0, hesap_bilgisi);
                        System.out.println("");
                        if (!magaza_oyun.isIndirimde_mi()) {
                            System.out.println(magaza_oyun.getId() + "\t- Oyun adı : " + magaza_oyun.getAd() + "\tFiyatı : " + magaza_oyun.getFiyat() + "\t. Satın alınmıştır.");
                        } else {
                            System.out.println(magaza_oyun.getId() + "\t- Oyun adı : " + magaza_oyun.getAd() + "\tİndirimli Fiyatı : " + magaza_oyun.getIndirimli_fiyat() + "\t. Satın alınmıştır.");
                        }

                        System.out.println("");
                        System.out.println("Son Oyun Listem : ");
                        var9 = hesap_bilgisi.getKutuphane().getOyunlar().iterator();

                        while (var9.hasNext()) {
                            oyunum = (Oyun) var9.next();
                            System.out.println(oyunum.getId() + "\t- Oyun adı : " + oyunum.getAd() + "\tTürü : " + oyunum.getTur() + "\tFiyatı : " + oyunum.getFiyat());
                        }

                        System.out.println("");
                        break;
                    }
                }

                System.out.println("");
                System.out.println("-1. Bir Önceki Menü");
                System.out.println("0. Ana Menü");
                System.out.print("Lütfen menüden bir seçim yapınız : ");
                secim = scanner.nextLine();
                switch (secim.hashCode()) {
                    case 48:
                        if (secim.equals("0")) {
                            this.ana_menu_goster();
                        }
                        break;
                    case 1444:
                        if (secim.equals("-1")) {
                            this.magaza_alis_veris();
                        }
                }
            } while (secim != "0");

            scanner.close();
            return;
        }
    }

    public void oyunu_istek_listene_ekle() {
        String oyun_secim = "0";
        String secim = "0";
        Scanner scanner = new Scanner(System.in);
        Hesap hesap_bilgisi = this.magaza.hesap_bilgilerimi_al(0);
        List<Oyun> magaza_oyun_listesi = this.magaza.getMagaza_oyunlar();
        Collections.sort(magaza_oyun_listesi, new Comparator<Oyun>() {
            public int compare(Oyun oyunOne, Oyun OyunTwo) {
                return oyunOne.getAd().compareTo(OyunTwo.getAd());
            }
        });
        Iterator var7 = hesap_bilgisi.getIstek_listesi().iterator();

        while (true) {
            Oyun magaza_oyun;
            Oyun istek_oyunum;
            Iterator var9;
            while (var7.hasNext()) {
                magaza_oyun = (Oyun) var7.next();
                var9 = magaza_oyun_listesi.iterator();

                while (var9.hasNext()) {
                    istek_oyunum = (Oyun) var9.next();
                    if (magaza_oyun.getId() == istek_oyunum.getId()) {
                        magaza_oyun_listesi.remove(istek_oyunum);
                        break;
                    }
                }
            }

            do {
                System.out.println("");
                System.out.println("");
                System.out.println("Oyunu İstek Listesine Ekleme Alt Menü");
                System.out.println("");
                System.out.println("Listemde Olmayan Mağaza Oyun Listesi : ");
                var7 = magaza_oyun_listesi.iterator();

                while (var7.hasNext()) {
                    magaza_oyun = (Oyun) var7.next();
                    if (!magaza_oyun.isIndirimde_mi()) {
                        System.out.println(magaza_oyun.getId() + "\t- Oyun adı : " + magaza_oyun.getAd() + "\tTürü : " + magaza_oyun.getTur() + "\tFiyatı : " + magaza_oyun.getFiyat() + "\tPuanı : " + magaza_oyun.getPuan());
                    } else {
                        System.out.println(magaza_oyun.getId() + "\t- Oyun adı : " + magaza_oyun.getAd() + "\tTürü : " + magaza_oyun.getTur() + "\tFiyatı : " + magaza_oyun.getFiyat() + "\tİndirimli Fiyatı : " + magaza_oyun.getIndirimli_fiyat() + "\tPuanı : " + magaza_oyun.getPuan());
                    }
                }

                System.out.println("");
                System.out.println("Güncel İstek Listem : ");
                var7 = hesap_bilgisi.getIstek_listesi().iterator();

                while (var7.hasNext()) {
                    magaza_oyun = (Oyun) var7.next();
                    System.out.println(magaza_oyun.getId() + "\t- Oyun adı : " + magaza_oyun.getAd() + "\tTürü : " + magaza_oyun.getTur() + "\tFiyatı : " + magaza_oyun.getFiyat());
                }

                System.out.println("");
                System.out.println("İstek Listesine Eklenecek Oyun Numarasını Giriniz : ");
                oyun_secim = scanner.nextLine();
                var7 = magaza_oyun_listesi.iterator();

                while (var7.hasNext()) {
                    magaza_oyun = (Oyun) var7.next();
                    if (magaza_oyun.getId() == Integer.valueOf(oyun_secim)) {
                        hesap_bilgisi.getIstek_listesi().add(magaza_oyun);
                        this.magaza.getMagaza_hesaplar().set(0, hesap_bilgisi);
                        System.out.println("");
                        if (!magaza_oyun.isIndirimde_mi()) {
                            System.out.println(magaza_oyun.getId() + "\t- Oyun adı : " + magaza_oyun.getAd() + "\tFiyatı : " + magaza_oyun.getFiyat() + "\t. İstek listene eklenmiştir.");
                        } else {
                            System.out.println(magaza_oyun.getId() + "\t- Oyun adı : " + magaza_oyun.getAd() + "\tİndirimli Fiyatı : " + magaza_oyun.getIndirimli_fiyat() + "\t. İstek listene eklenmiştir.");
                        }

                        System.out.println("");
                        System.out.println("Son Oyun Listem : ");
                        var9 = hesap_bilgisi.getKutuphane().getOyunlar().iterator();

                        while (var9.hasNext()) {
                            istek_oyunum = (Oyun) var9.next();
                            System.out.println(istek_oyunum.getId() + "\t- Oyun adı : " + istek_oyunum.getAd() + "\tTürü : " + istek_oyunum.getTur() + "\tFiyatı : " + istek_oyunum.getFiyat());
                        }

                        System.out.println("");
                        System.out.println("Son İstek Listem : ");
                        var9 = hesap_bilgisi.getIstek_listesi().iterator();

                        while (var9.hasNext()) {
                            istek_oyunum = (Oyun) var9.next();
                            System.out.println(istek_oyunum.getId() + "\t- Oyun adı : " + istek_oyunum.getAd() + "\tTürü : " + istek_oyunum.getTur() + "\tFiyatı : " + istek_oyunum.getFiyat());
                        }

                        System.out.println("");
                        break;
                    }
                }

                System.out.println("");
                System.out.println("-1. Bir Önceki Menü");
                System.out.println("0. Ana Menü");
                System.out.print("Lütfen menüden bir seçim yapınız : ");
                secim = scanner.nextLine();
                switch (secim.hashCode()) {
                    case 48:
                        if (secim.equals("0")) {
                            this.ana_menu_goster();
                        }
                        break;
                    case 1444:
                        if (secim.equals("-1")) {
                            this.magaza_alis_veris();
                        }
                }
            } while (secim != "0");

            scanner.close();
            return;
        }
    }

    public void kutuphanem() {
        String secim = "0";
        Scanner scanner = new Scanner(System.in);
        Hesap hesap_bilgisi = this.magaza.hesap_bilgilerimi_al(0);
        Collections.sort(hesap_bilgisi.getKutuphane().getOyunlar(), new Comparator<Oyun>() {
            public int compare(Oyun oyunOne, Oyun OyunTwo) {
                if (oyunOne.getKullanici_puan() < OyunTwo.getKullanici_puan()) {
                    return -1;
                } else {
                    return oyunOne.getKullanici_puan() > OyunTwo.getKullanici_puan() ? 1 : 0;
                }
            }
        });

        do {
            System.out.println("");
            System.out.println("");
            System.out.println("Kütüphanem Alt Menü");
            System.out.println("");
            System.out.println("Oyun Listem (Puanlarıma göre) : ");
            Iterator var5 = hesap_bilgisi.getKutuphane().getOyunlar().iterator();

            while (var5.hasNext()) {
                Oyun oyunum = (Oyun) var5.next();
                System.out.println(oyunum.getId() + "\t- Oyun adı : " + oyunum.getAd() + "\tTürü : " + oyunum.getTur() + "\tGenel Puan : " + oyunum.getPuan() + "\tPuanım : " + oyunum.getKullanici_puan());
            }

            System.out.println("");
            System.out.println("1. Oyununa Puan Ver");
            System.out.println("-1. Bir Önceki Menü");
            System.out.println("0. Ana Menü");
            System.out.print("Lütfen menüden bir seçim yapınız : ");
            secim = scanner.nextLine();
            switch (secim.hashCode()) {
                case 48:
                    if (secim.equals("0")) {
                        this.ana_menu_goster();
                    }
                    break;
                case 49:
                    if (secim.equals("1")) {
                        this.oyununa_puan_ver();
                    }
                    break;
                case 1444:
                    if (secim.equals("-1")) {
                        this.ana_menu_goster();
                    }
            }
        } while (secim != "0");

        scanner.close();
    }

    public void oyununa_puan_ver() {
        String oyun_secim = "0";
        String secim = "0";
        Scanner scanner = new Scanner(System.in);
        Hesap hesap_bilgisi = this.magaza.hesap_bilgilerimi_al(0);
        Collections.sort(hesap_bilgisi.getKutuphane().getOyunlar(), new Comparator<Oyun>() {
            public int compare(Oyun oyunOne, Oyun OyunTwo) {
                if (oyunOne.getKullanici_puan() < OyunTwo.getKullanici_puan()) {
                    return -1;
                } else {
                    return oyunOne.getKullanici_puan() > OyunTwo.getKullanici_puan() ? 1 : 0;
                }
            }
        });

        do {
            System.out.println("");
            System.out.println("");
            System.out.println("Oyununa Puan Verme Alt Menü");
            System.out.println("");
            System.out.println("Oyun Listem (Puanlarıma göre) : ");
            Iterator var6 = hesap_bilgisi.getKutuphane().getOyunlar().iterator();

            Oyun oyunum;
            while (var6.hasNext()) {
                oyunum = (Oyun) var6.next();
                System.out.println(oyunum.getId() + "\t- Oyun adı : " + oyunum.getAd() + "\tTürü : " + oyunum.getTur() + "\tGenel Puan : " + oyunum.getPuan() + "\tPuanım : " + oyunum.getKullanici_puan());
            }

            System.out.println("");
            System.out.println("Puan Verilecek Oyun Numarasını Giriniz : ");
            oyun_secim = scanner.nextLine();
            var6 = hesap_bilgisi.getKutuphane().getOyunlar().iterator();

            while (var6.hasNext()) {
                oyunum = (Oyun) var6.next();
                if (oyunum.getId() == Integer.valueOf(oyun_secim)) {
                    if (oyunum.getKullanici_puan() > 0.0D) {
                        System.out.println("");
                        System.out.println("Daha önce bu oyunun puanınız verdiniz. Başka bir oyun seçmek için herhangi bir tuşa basınız.");
                        oyun_secim = scanner.nextLine();
                        this.oyununa_puan_ver();
                        break;
                    }

                    System.out.println("");
                    System.out.println("Puanınızı veriniz : ");
                    oyun_secim = scanner.nextLine();
                    oyunum.setKullanici_puan(Double.valueOf(oyun_secim));
                    this.magaza.getMagaza_hesaplar().set(0, hesap_bilgisi);
                    System.out.println("");
                    System.out.println(" Puan verdiğiniz " + oyunum.getAd() + "\toyununa ait güncel bilgiler : ");
                    System.out.println(oyunum.getId() + "\t- Oyun adı : " + oyunum.getAd() + "\tTürü : " + oyunum.getTur() + "\tGenel Puan : " + oyunum.getPuan() + "\tPuanım : " + oyunum.getKullanici_puan());
                    System.out.println("");
                    System.out.println("Güncellenmiş Oyun Listem : ");
                    Iterator var8 = hesap_bilgisi.getKutuphane().getOyunlar().iterator();

                    while (var8.hasNext()) {
                        Oyun puan_degismi_oyunum = (Oyun) var8.next();
                        System.out.println(puan_degismi_oyunum.getId() + "\t- Oyun adı : " + puan_degismi_oyunum.getAd() + "\tTürü : " + puan_degismi_oyunum.getTur() + "\tGenel Puan : " + puan_degismi_oyunum.getPuan() + "\tPuanım : " + puan_degismi_oyunum.getKullanici_puan());
                    }

                    System.out.println("");
                    break;
                }
            }

            System.out.println("");
            System.out.println("-1. Bir Önceki Menü");
            System.out.println("0. Ana Menü");
            System.out.print("Lütfen menüden bir seçim yapınız : ");
            secim = scanner.nextLine();
            switch (secim.hashCode()) {
                case 48:
                    if (secim.equals("0")) {
                        this.ana_menu_goster();
                    }
                    break;
                case 1444:
                    if (secim.equals("-1")) {
                        this.kutuphanem();
                    }
            }
        } while (secim != "0");

        scanner.close();
    }

    public void arkadaslarim() {
        String secim = "0";
        Scanner scanner = new Scanner(System.in);
        Hesap hesap_bilgisi = this.magaza.hesap_bilgilerimi_al(1);
        Collections.sort(hesap_bilgisi.getKutuphane().getOyunlar(), new Comparator<Oyun>() {
            public int compare(Oyun oyunOne, Oyun OyunTwo) {
                return oyunOne.getAd().compareTo(OyunTwo.getAd());
            }
        });

        do {
            System.out.println("");
            System.out.println("");
            System.out.println("Arkadaşlarım Alt Menü");
            System.out.println("");
            System.out.println("Arkadaşının Adı : " + hesap_bilgisi.getAd());
            System.out.println("Arkadaşının Soyadı : " + hesap_bilgisi.getSoyad());
            System.out.println("");
            System.out.println("Arkadaşımın Oyun Listesi (Ada göre) : ");
            Iterator var5 = hesap_bilgisi.getKutuphane().getOyunlar().iterator();

            Oyun oyunum;
            while (var5.hasNext()) {
                oyunum = (Oyun) var5.next();
                System.out.println(oyunum.getId() + "\t- Oyun adı : " + oyunum.getAd() + "\tTürü : " + oyunum.getTur() + "\tGenel Puan : " + oyunum.getPuan() + "\tPuanım : " + oyunum.getKullanici_puan());
            }

            System.out.println("");
            System.out.println("Arkadaşımın İstek Listesi : ");
            var5 = hesap_bilgisi.getIstek_listesi().iterator();

            while (var5.hasNext()) {
                oyunum = (Oyun) var5.next();
                System.out.println(oyunum.getId() + "\t- Oyun adı : " + oyunum.getAd() + "\tTürü : " + oyunum.getTur() + "\tFiyatı : " + oyunum.getFiyat());
            }

            System.out.println("");
            System.out.println("1. Oyun Hediye Et");
            System.out.println("-1. Bir Önceki Menü");
            System.out.println("0. Ana Menü");
            System.out.print("Lütfen menüden bir seçim yapınız : ");
            secim = scanner.nextLine();
            switch (secim.hashCode()) {
                case 48:
                    if (secim.equals("0")) {
                        this.ana_menu_goster();
                    }
                    break;
                case 49:
                    if (secim.equals("1")) {
                        this.oyun_hediye_et();
                    }
                    break;
                case 1444:
                    if (secim.equals("-1")) {
                        this.ana_menu_goster();
                    }
            }
        } while (secim != "0");

        scanner.close();
    }

    public void oyun_hediye_et() {
        Hesap hesap_bilgisi = this.magaza.hesap_bilgilerimi_al(1);
        String oyun_secim = "0";
        String secim = "0";
        Scanner scanner = new Scanner(System.in);
        Collections.sort(hesap_bilgisi.getIstek_listesi(), new Comparator<Oyun>() {
            public int compare(Oyun oyunOne, Oyun OyunTwo) {
                return oyunOne.getAd().compareTo(OyunTwo.getAd());
            }
        });

        do {
            System.out.println("");
            System.out.println("");
            System.out.println("Arkadaşıma Oyun Hediye Et Alt Menü");
            System.out.println("");
            System.out.println("Arkadaşının Adı : " + hesap_bilgisi.getAd());
            System.out.println("Arkadaşının Soyadı : " + hesap_bilgisi.getSoyad());
            System.out.println("");
            System.out.println("Arkadaşımın İstek Listesi : ");
            Iterator var6 = hesap_bilgisi.getIstek_listesi().iterator();

            Oyun arkadasim_istek_oyun;
            while (var6.hasNext()) {
                arkadasim_istek_oyun = (Oyun) var6.next();
                System.out.println(arkadasim_istek_oyun.getId() + "\t- Oyun adı : " + arkadasim_istek_oyun.getAd() + "\tTürü : " + arkadasim_istek_oyun.getTur() + "\tFiyatı : " + arkadasim_istek_oyun.getFiyat());
            }

            System.out.println("");
            System.out.println("Kredi Kartı Bilgileri : " + hesap_bilgisi.getKredi_karti());
            System.out.println("");
            System.out.println("Hediye Edilecek Oyun Numarasını Giriniz : ");
            oyun_secim = scanner.nextLine();
            var6 = hesap_bilgisi.getIstek_listesi().iterator();

            while (var6.hasNext()) {
                arkadasim_istek_oyun = (Oyun) var6.next();
                if (arkadasim_istek_oyun.getId() == Integer.valueOf(oyun_secim)) {
                    hesap_bilgisi.getKutuphane().getOyunlar().add(arkadasim_istek_oyun);
                    hesap_bilgisi.getIstek_listesi().remove(arkadasim_istek_oyun);
                    this.magaza.getMagaza_hesaplar().set(1, hesap_bilgisi);
                    System.out.println("");
                    if (!arkadasim_istek_oyun.isIndirimde_mi()) {
                        System.out.println(arkadasim_istek_oyun.getId() + "\t- Oyun adı : " + arkadasim_istek_oyun.getAd() + "\tFiyatı : " + arkadasim_istek_oyun.getFiyat() + "\t. Oyun hediye edilmiştir.");
                    } else {
                        System.out.println(arkadasim_istek_oyun.getId() + "\t- Oyun adı : " + arkadasim_istek_oyun.getAd() + "\tİndirimli Fiyatı : " + arkadasim_istek_oyun.getIndirimli_fiyat() + "\t. Oyun hediye edilmiştir.");
                    }

                    System.out.println("");
                    System.out.println("Arkadaşımın Son Oyun Listesi : ");
                    Iterator var8 = hesap_bilgisi.getKutuphane().getOyunlar().iterator();

                    Oyun oyunum;
                    while (var8.hasNext()) {
                        oyunum = (Oyun) var8.next();
                        System.out.println(oyunum.getId() + "\t- Oyun adı : " + oyunum.getAd() + "\tTürü : " + oyunum.getTur() + "\tFiyatı : " + oyunum.getFiyat());
                    }

                    System.out.println("");
                    System.out.println("Arkadaşımın Son İstek Listesi : ");
                    var8 = hesap_bilgisi.getIstek_listesi().iterator();

                    while (var8.hasNext()) {
                        oyunum = (Oyun) var8.next();
                        System.out.println(oyunum.getId() + "\t- Oyun adı : " + oyunum.getAd() + "\tTürü : " + oyunum.getTur() + "\tFiyatı : " + oyunum.getFiyat());
                    }

                    System.out.println("");
                    break;
                }
            }

            System.out.println("");
            System.out.println("-1. Bir Önceki Menü");
            System.out.println("0. Ana Menü");
            System.out.print("Lütfen menüden bir seçim yapınız : ");
            secim = scanner.nextLine();
            switch (secim.hashCode()) {
                case 48:
                    if (secim.equals("0")) {
                        this.ana_menu_goster();
                    }
                    break;
                case 1444:
                    if (secim.equals("-1")) {
                        this.arkadaslarim();
                    }
            }
        } while (secim != "0");

        scanner.close();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.ana_menu_goster();
    }
}
