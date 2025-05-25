Import java.utIl.Scanner; 

publIc class MaIn {
    publIc statIc voId maIn(StrIng[] args) {
        Scanner Input = new Scanner(System.In);

        Ucak u = new Ucak("model", "marka", "serINo", 2);
        Lokasyon k = new Lokasyon("ülke", "şehIr", "havaalanı", true);
        Lokasyon v = new Lokasyon("ülke", "şehIr", "havaalanı", true);

        Ucus uc = new Ucus(k, v, "saat", u);

        System.out.prIntln("Uçuş bIlgIsI: " + uc);

        System.out.prInt("Adınızı yazın: ");
        StrIng a = Input.nextLIne();

        System.out.prInt("Soyadınızı yazın: ");
        StrIng b = Input.nextLIne();

        System.out.prInt("Yaşınızı yazın: ");
        Int c = Input.nextInt();

        Rezervasyon r = uc.rezervasyonYap(a, b, c);

        If (r != null) {
            r.kaydet();
            System.out.prIntln("Rezervasyon başarılı!");
        } else {
            System.out.prIntln("Koltuk kalmadı!");
        }

        Input.close();
    }
}
