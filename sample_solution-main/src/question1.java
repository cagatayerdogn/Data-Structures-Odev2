import java.util.LinkedList;

public class question1 {

    public static void questionone() {
        int[] fiyatlarDizisi = {4,5,5,2,4,6,1};
        LinkedList<FiyatListesiGunluk> fiyatlar = new LinkedList<>();//Linked list oluşturdum.

        for (int j = 0; j < fiyatlarDizisi.length; j++) {//Fiyatlar dizisi arrayini fiyatlar linked listine ekledim.
            fiyatlar.add(new FiyatListesiGunluk(j, fiyatlarDizisi[j]));
        }

        Sonuc sonuc = bulMaksimumKar(fiyatlar);//Linked listi oluşturduğum fonksiyona gönderdim.

        if (sonuc.maksimumKar > 0) {//Kârın olup olmadığını kontrol ediyor, duruma göre alış ve satış gününü söylüyor.
            System.out.println("Satıcının maksimum karı: " + sonuc.maksimumKar);
            System.out.println("Satıcı bu gün alım yapmalı: " + (sonuc.alimGun+1));
            System.out.println("Satıcı bu gün satış yapmalı: " + (sonuc.satisGun+1));
        } else {//Kâr yoksa bu koşul çalışıyor.
            System.out.println("Bu fiyatlarla kar sağlanamaz.");
        }
    }

    public static Sonuc bulMaksimumKar(LinkedList<FiyatListesiGunluk> fiyatlar) {
        int maksimumKar = 0;
        Integer alimGun = null;
        Integer satisGun = null;

        for (int i = 0; i < fiyatlar.size() - 1; i++) {//iç içe for döngüleri ile alış ve satış fiyatları karşılaştırılıyor, duruma göre alış-satış günü ve kâr belirleniyor.
            FiyatListesiGunluk alisFiyati = fiyatlar.get(i);

            for (int j = i + 1; j < fiyatlar.size(); j++) {
                FiyatListesiGunluk satisFiyati = fiyatlar.get(j);

                int mevcutKar = satisFiyati.fiyat - alisFiyati.fiyat;

                if (mevcutKar > maksimumKar) {
                    maksimumKar = mevcutKar;
                    alimGun = alisFiyati.gun;
                    satisGun = satisFiyati.gun;
                }
            }
        }

        return new Sonuc(maksimumKar, alimGun, satisGun);
    }

    private static class FiyatListesiGunluk {// Gün ve fiyat bilgilerini bu nesne içerisinde tutuyoruz.
                                             // Diğer fonksiyonlarda bu nesnenin içindekilerle işlemlerimizi yaparız.
        int gun;
        int fiyat;

        FiyatListesiGunluk(int gun, int fiyat) {
            this.gun = gun;
            this.fiyat = fiyat;
        }
    }

    private static class Sonuc { // maksimumkar, alim günü ve satis günü bilgilerini bu nesne içerisinde tutuyoruz.
                                // Sonucu bulmak için bu nesnenin içindekilerle işlemlerimizi yaparız.
        int maksimumKar;
        int alimGun;
        int satisGun;

        Sonuc(int maksimumKar, int alimGun, int satisGun) {
            this.maksimumKar = maksimumKar;
            this.alimGun = alimGun;
            this.satisGun = satisGun;
        }
    }
}
