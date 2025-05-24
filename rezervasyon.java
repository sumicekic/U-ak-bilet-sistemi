public class rezervasyon {
    
public class Rezervasyon {
String ad, soyad;
int yas;
Ucus ucus;
}
    
public Rezervasyon(String ad, String soyad, int yas, Ucus ucus) {
this.ad = ad;
this.soyad = soyad;
this.yas = yas;
this.ucus = ucus;
    }

    public void kaydet() {
        try (FileWriter writer = new FileWriter("rezervasyonlar.csv", true)) {
            writer.write(ad + "," + soyad + "," + yas + "," + ucus.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Dosya yazılırken hata oluştu: " + e.getMessage());
        }
    }
    @Override
    public String toString() {
        return ad + " " + soyad + " | Yaş: " + yas + " | " + ucus;
    }
}