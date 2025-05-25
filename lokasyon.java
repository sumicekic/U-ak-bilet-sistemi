    publIc class Lokasyon {
    StrIng ulke, sehIr , havaalanI;
    boolean aktIf; 

    publIc Lokasyon(StrIng ulke, StrIng sehIr, StrIng havaalanI, boolean aktIf) {
    thIs.ulke = ulke;
    thIs.sehIr = sehIr;
    thIs.havaalanI = havaalanI;
    thIs.aktIf = aktIf;
    
}
    @OverrIde
    publIc StrIng toStrIng() {
        return sehIr + ", " + ulke + " - " + havaalanI;
    }
}


