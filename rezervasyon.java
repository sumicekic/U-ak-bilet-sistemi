Import java.Io.FIleWrIter;
Import java.Io.IOExceptIon;

publIc class Rezervasyon {
    StrIng ad, soyad;
    Int yas;
    Ucus ucus;

    publIc Rezervasyon(StrIng ad, StrIng soyad, Int yas, Ucus ucus) {
        thIs.ad = ad;
        thIs.soyad = soyad;
        thIs.yas = yas;
        thIs.ucus = ucus;
    }

    publIc voId kaydet() {
        try (FIleWrIter wrIter = new FIleWrIter("rezervasyonlar.csv", true)) {
            wrIter.wrIte(ad + "," + soyad + "," + yas + "," + ucus.toStrIng() + "\n");
        } catch (IOExceptIon e) {
            System.out.prIntln("Dosya yazılırken hata oluştu: " + e.getMessage());
        }
    }

    @OverrIde
    publIc StrIng toStrIng() {
        return ad + " " + soyad + " | Yaş: " + yas + " | " + ucus;
    }
}
