Bu projede, Java ile nesne yönelimli programlama (OOP) mantığı kullanılarak kullanıcıların uçuş rezervasyonu yapabildiği,
uçak, lokasyon ve uçuş bilgilerini yöneten basit bir uçak bileti sistemi geliştirildi.
program vscode ile yazılmış olup içerisinde  java  csv dosyası barındırmaktadır.
program ilk yazılan türçe karakterleri tanımadığı için terminal üzerinden değiştirildi,
bu nedenle bazı sesli harfler büyük olarak yazıldı. 

programın barındırdığı dosyalar:

main.java: Uygulamanın başlangıç noktasıdır. Kullanıcı arayüzünü yönetir ve diğer sınıflarla etkileşimi sağlar.
ucak.java: Uçak nesnesini temsil eder. Uçağın model, kapasite gibi özelliklerini içerir.
ucus.java: Uçuş bilgilerini tutar. Kalkış ve varış noktaları, tarih ve saat gibi verileri içerir.
lokasyon.java: Havalimanı veya şehir bilgilerini yönetir.
rezervasyon.java: Rezervasyon işlemlerini gerçekleştirir. Kullanıcı bilgileri, seçilen uçuş ve koltuk numarası gibi detayları içerir.
rezervasyonlar.csv: Yapılan rezervasyonların kaydedildiği dosyadır.


ilk olarak main.java dosyasıyla başlayalım:


Import java.utIl.Scanner; 
(klavyeden veri almamızı sağlayan scanner sınıfını çağırdık.)

publIc class MaIn {   (main sınıfını tanımladık,public sayesinde herkes bu sınıfa erişebilir.)
    publIc statIc voId maIn(StrIng[] args) {    (Programın başlangıç noktası olan main metodunu tanımladık, herkes erişebilir, nesne oluşturmadan çalışır ve herhangi bir değer döndürmez.)
        Scanner Input = new Scanner(System.In);   (Klavyeden veri almak için Scanner sınıfından input isimli bir nesne oluşturduk.)

        Ucak u = new Ucak("model", "marka", "serINo", 2);   (model, marka, seri numarası ve kapasitesi 2 olan bir uçak nesnesi oluşturduk.)
        Lokasyon k = new Lokasyon("ülke", "şehIr", "havaalanı", true);  (Kalkış noktası için ülke, şehir, havaalanı ve aktiflik bilgisini içeren bir lokasyon nesnesi oluşturduk.)
        Lokasyon v = new Lokasyon("ülke", "şehIr", "havaalanı", true);  (Varış noktası için aynı şekilde bir lokasyon nesnesi oluşturduk.)

        Ucus uc = new Ucus(k, v, "saat", u);   (Kalkış ve varış lokasyonları, uçuş saati ve uçak bilgilerini kullanarak bir uçuş nesnesi oluşturduk.)

        System.out.prIntln("Uçuş bIlgIsI: " + uc); ( Uçuş bilgilerini ekrana yazdırdık.)

        System.out.prInt("Adınızı yazın: "); (Kullanıcıdan adını girmesini istedik.)
        StrIng a = Input.nextLIne();    ( Kullanıcının girdiği adı aldık ve a değişkenine kaydettik.)

        System.out.prInt("Soyadınızı yazın: "); (Kullanıcıdan soyadını girmesini istedik.)
        StrIng b = Input.nextLIne();  ( Kullanıcının girdiği soyadı aldık ve b değişkenine kaydettik.)

        System.out.prInt("Yaşınızı yazın: "); ( Kullanıcıdan yaşını girmesini istedik.)
        Int c = Input.nextInt();   ( Kullanıcının girdiği yaşı int tipinde c değişkenine kaydettik.)
 
        Rezervasyon r = uc.rezervasyonYap(a, b, c);   (Uçuş nesnesinin rezervasyon yap metodunu çağırdık, kullanıcı bilgilerini verip rezervasyon denedik.)

        If (r != null) {    (Eğer rezervasyon başarılıysa (r boş değilse) şu işlemleri yapacağız demek.)
            r.kaydet();    ( Rezervasyonu kaydettik.)
            System.out.prIntln("Rezervasyon başarılı!");   (Ekrana rezervasyonun başarılı olduğunu yazdırdık.)
        } else {    ( Eğer rezervasyon yapılamadıysa (r boşsa) diğer işlemler yapılacak.)
            System.out.prIntln("Koltuk kalmadı!"); (Ekrana koltuk kalmadığını yazdırdık.)
        }

        Input.close();   ( Klavyeden veri alma işini kapattık, Scanner’ı kapattık.)
    }
}



UCAK.JAVA DOSYASIYLA DEVAM EDELİM:

    publIc class ucak {  (Ucak adında bir sınıf oluşturduk, public olduğu için her yerden erişilebilir.)
    StrIng model, marka , serINo;  (Uçağın modelini, markasını ve seri numarasını tutacak değişkenleri tanımladık.)
    Int kapasIte;   (Uçağın kaç kişilik olduğunu tutan kapasite değişkenini tanımladık.)

    publIc Ucak(StrIng model, StrIng marka, StrIng serINo, Int kapasIte) {    (Ucak sınıfının yapıcı (constructor) metodunu oluşturduk, böylece uçak nesnesi yaratılırken bu bilgiler verilecek.)
        thIs.model = model;   (Bu uçağın model bilgisi, parametreden gelen model ile ayarlandı.)
        thIs.marka = marka;   (Bu uçağın marka bilgisi, parametreden gelen marka ile ayarlandı.)
        thIs.serINo = serINo;  (Bu uçağın seri numarası, parametreden gelen serINo ile ayarlandı.)
        thIs.kapasIte = kapasIte;   (Bu uçağın kapasitesi, parametreden gelen kapasite ile ayarlandı.)
    }

publIc Int getKapasIte() {     (Uçağın kapasitesini dışarıya vermek için bir fonksiyon yazdık.)
    return kapasIte;         (Fonksiyon kapasite değerini geri döndürüyor.)
    }

    @OverrIde
    publIc StrIng toStrIng() {    (Uçak nesnesini yazdırdığımızda nasıl görüneceğini belirten metodu tanımladık.)
        return marka + " " + model + " (" + serINo + ") - KapasIte: " + kapasIte;   (Uçağı marka, model, seri numarası ve kapasitesiyle birleştirip string olarak döndürüyoruz.)
    }
}


 UCUS.JAVA DOSYASIYLA DEVAM EDELİM:


 publIc class Ucus {  (Ucus adında bir sınıf oluşturduk, herkes erişebilir.)
    Lokasyon kalkIs, varIs;  (Uçağın nereden kalktığını ve nereye gittiğini tutmak için iki tane lokasyon değişkeni tanımladık.)
    StrIng saat;  (Uçuşun saatini string (yazı) olarak tutuyoruz.)
    Ucak ucak;   (Bu uçuşta kullanılacak olan uçağın bilgisini tutan değişken.)
    Int kalanKoltuk; (Uçakta kalan boş koltuk sayısını bu değişkende tutuyoruz.)

    publIc Ucus(Lokasyon kalkIs, Lokasyon varIs, StrIng saat, Ucak ucak) { (Uçuş nesnesi oluştururken kalkış, varış, saat ve uçak bilgilerini alıyoruz.)
        thIs.kalkIs = kalkIs;  (Parametre olarak gelen kalkış lokasyonunu sınıftaki kalkış değişkenine atıyoruz.)
        thIs.varIs = varIs;   (Aynı şekilde, varış lokasyonunu atıyoruz.)
        thIs.saat = saat; (Saat bilgisini sınıfa atıyoruz.)
        thIs.ucak = ucak;  (Uçak nesnesini de bu sınıfa tanıtıyoruz.)
        thIs.kalanKoltuk = ucak.getKapasIte();   (Uçağın kapasitesini alıp kalan koltuk olarak başta hepsini boş kabul ediyoruz.)
    }

    publIc boolean rezervasyonYap() {   (Bu metot, sadece koltuk varsa 1 tane azaltıp true döner, yoksa false döner.)
        If (kalanKoltuk > 0) { (boş koltuk olup olmadığını belirtir. klasik if yapısı)
            kalanKoltuk--;  (bir koltuğu rezerve ediyoruz)
            return true;  (rezervasyon başarılı)
        }
        return false;  (boş koltuk yoksa,başarısız.)
    }

    
    publIc Rezervasyon rezervasyonYap(StrIng ad, StrIng soyad, Int yas) {   (yolcu bilgileriyle rezervasyon yapmaya çalışıyoruz.)
        If (rezervasyonYap()) {   (eğer rezervasyon başarılıysa,klasik if yapısı)
            return new Rezervasyon(ad, soyad, yas, thIs);   (Yeni bir rezervasyon oluşturup döner.)
        } else {   (koltuk yoksa 0 döner, rezervasyon yapılamaz.)
            return null;
        }
    }

    @OverrIde    (çıktının nasıl gözükeceğini düzenler)
    publIc StrIng toStrIng() { (nesne çıktısını nasıl görmek istediğimizi ayarlıyoruz.)
        return kalkIs + " -> " + varIs + " | Saat: " + saat + " | Uçak: " + ucak;
    }
}

 LOKASYON.JAVA DOSYASINA BAKALIM:

    publIc class Lokasyon {  (lokasyon sınıfını tanımladık, bu sınıf herkes eaçık)
    StrIng ulke, sehIr , havaalanI;   (Uçuşun yapılacağı yerle ilgili bilgileri tutmak için üç tane değişken oluşturduk: ülke, şehir ve havaalanı ismi.)
    boolean aktIf;  (lokasyonun aktif olup olmadığını belitirtir. t/f gibi düşünebiliriz.)

    publIc Lokasyon(StrIng ulke, StrIng sehIr, StrIng havaalanI, boolean aktIf) {   (Lokasyon sınıfının yapıcı metodunu yazdık. Dışarıdan ülke, şehir, havaalanı ve aktiflik bilgilerini alıp nesne oluşturuyoruz.)
    thIs.ulke = ulke;          (parametre olarak gelen ülke bilgisini sınıf içindeki ulke değişkenine atadık.)
    thIs.sehIr = sehIr;       (parametre olarak gelen şehir bilgisini sınıf içindeki sehir değişkenine atadık.)
    thIs.havaalanI = havaalanI;  (parametre olarak gelen havalaanı bilgisini sınıf içindeki havaalanı değişkenine atadık.))
    thIs.aktIf = aktIf;  (Aktiflik durumunu da aldık ve sınıfa atadık.)
    
}
    @OverrIde
    publIc StrIng toStrIng() {   (Lokasyon nesnesi yazdırıldığında nasıl gözüksün istiyorsak buraya yazıyoruz.)
        return sehIr + ", " + ulke + " - " + havaalanI;  (Lokasyon bilgilerini şehir, ülke ve havaalanı şeklinde birleştirip yazı olarak geri döndürüyoruz)
    }
}

REZERVASYON.JAVA DOSYASINA BAKALIM:

Import java.Io.FIleWrIter;  (Dosyaya yazı yazabilmek için Java'nın hazır bir sınıfını içeri aktardık. Bunun sayesinde .csv dosyasına kayıt yapabiliyoruz.)
Import java.Io.IOExceptIon; (Dosya işlemlerinde hata olursa bu sınıf sayesinde hata ayıklanır.)

publIc class Rezervasyon {   (Rezervasyon adında bir sınıf tanımladık. Bu sınıf herkese açıktır.)
    StrIng ad, soyad;   (Yolcunun adı ve soyadını tutuyoruz.)
    Int yas;           (Yolcunun yaşını tutan değişken)
    Ucus ucus;         (Yolcunun yaptığı uçuşun bilgilerini tutuyoruz)

    publIc Rezervasyon(StrIng ad, StrIng soyad, Int yas, Ucus ucus) {   (Bu yapıcı metot, dışarıdan alınan yolcu bilgilerini ve uçuşu sınıfın içine kaydediyor.)
        thIs.ad = ad;   (Dışarıdan gelen ad bilgisini sınıfa atıyoruz.)
        thIs.soyad = soyad;  (Dışarıdan gelen soyad bilgisini sınıfa atıyoruz )
        thIs.yas = yas;  (Dışarıdan gelen yaş bilgisini de sınıfa atıyoruz.)
        thIs.ucus = ucus;  (Hangi uçuşa rezervasyon yapıldığını da sınıfa ekliyoruz.)
    }

    publIc voId kaydet() {   (Rezervasyon bilgilerini dosyaya kaydediyoruz.)
        try (FIleWrIter wrIter = new FIleWrIter("rezervasyonlar.csv", true)) {   (rezervasyonlar.csv adında bir dosya açıyoruz. true yazdığımız için üstüne değil, sonuna ekliyor.)
            wrIter.wrIte(ad + "," + soyad + "," + yas + "," + ucus.toStrIng() + "\n");  (Ad, soyad, yaş ve uçuş bilgilerini CSV formatında (virgülle ayırarak) dosyaya yazıyoruz. Her satır bir rezervasyon.)
        } catch (IOExceptIon e) {   (Dosyaya yazılırken bir hata olup olmadığını kontrol eder.)
            System.out.prIntln("Dosya yazılırken hata oluştu: " + e.getMessage()); (Hata mesajını ekrnaa yazdırıyoruz.)
        }
    }

    @OverrIde   
    publIc StrIng toStrIng() {   Nesne yazıldığında nasıl gözükmesini istediğimizi belirledik.)      
    return ad + " " + soyad + " | Yaş: " + yas + " | " + ucus;  (Yolcunun adı soyadı, yaşı ve uçuş bilgilerini birleştirip geri döndürüyoruz.)
    }
}

