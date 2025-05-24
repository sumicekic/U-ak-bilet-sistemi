public class ucak {
String model, marka , seriNo;
int kapasite; 

public Ucak(String model, String marka, String seriNo, int kapasite) {
        this.model = model;
        this.marka = marka;
        this.seriNo = seriNo;
        this.kapasite = kapasite;
    }

public int getKapasite() {
    return kapasite;
    }
}