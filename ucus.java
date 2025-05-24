public class ucus {
    Lokasyon kalkis, varis;
    String saat;
    Ucak ucak;
    int kalanKoltuk; 

public Ucus(Lokasyon kalkis, Lokasyon varis, String saat, Ucak ucak) {
this.kalkis = kalkis;
this.varis = varis;
this.saat = saat;
this.ucak = ucak;
this.kalanKoltuk = ucak.getKapasite();
}

}