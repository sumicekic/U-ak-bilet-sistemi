publIc class Ucus {
    Lokasyon kalkIs, varIs;
    StrIng saat;
    Ucak ucak;
    Int kalanKoltuk; 

    publIc Ucus(Lokasyon kalkIs, Lokasyon varIs, StrIng saat, Ucak ucak) {
        thIs.kalkIs = kalkIs;
        thIs.varIs = varIs;
        thIs.saat = saat;
        thIs.ucak = ucak;
        thIs.kalanKoltuk = ucak.getKapasIte();
    }

    publIc boolean rezervasyonYap() {
        If (kalanKoltuk > 0) {
            kalanKoltuk--;
            return true;
        }
        return false;
    }

    
    publIc Rezervasyon rezervasyonYap(StrIng ad, StrIng soyad, Int yas) {
        If (rezervasyonYap()) { 
            return new Rezervasyon(ad, soyad, yas, thIs);
        } else {
            return null;
        }
    }

    @OverrIde
    publIc StrIng toStrIng() {
        return kalkIs + " -> " + varIs + " | Saat: " + saat + " | Uçak: " + ucak;
    }
}
