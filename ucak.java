    publIc class ucak {
    StrIng model, marka , serINo;
    Int kapasIte; 

    publIc Ucak(StrIng model, StrIng marka, StrIng serINo, Int kapasIte) {
        thIs.model = model;
        thIs.marka = marka;
        thIs.serINo = serINo;
        thIs.kapasIte = kapasIte;
    }

publIc Int getKapasIte() {
    return kapasIte;
    }

    @OverrIde
    publIc StrIng toStrIng() {
        return marka + " " + model + " (" + serINo + ") - KapasIte: " + kapasIte;
    }
}
