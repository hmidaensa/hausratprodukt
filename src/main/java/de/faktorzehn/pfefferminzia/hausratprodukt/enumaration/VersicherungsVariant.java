package de.faktorzehn.pfefferminzia.hausratprodukt.enumaration;

public enum VersicherungsVariant {
    PV("Premium-Variante"),
    BV("Basic-Variante");

    private final String value;
    VersicherungsVariant( String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}
