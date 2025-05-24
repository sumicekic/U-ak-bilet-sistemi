    public class lokasyon {
    String ulke, sehir , havaalani;
    boolean aktif; 

    public Lokasyon(String ulke, String sehir, String havaalani, boolean aktif) {
    this.ulke = ulke;
    this.sehir = sehir;
    this.havaalani = havaalani;
    this.aktif = aktif;
    
}
    @Override
    public String toString() {
        return sehir + ", " + ulke + " - " + havaalani;
    }
}


