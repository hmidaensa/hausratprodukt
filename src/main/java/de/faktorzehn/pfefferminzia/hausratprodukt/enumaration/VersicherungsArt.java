package de.faktorzehn.pfefferminzia.hausratprodukt.enumaration;


public enum VersicherungsArt {

    VA1("Hausrat","Hausratversicherung");

    private final String key;
    private final String value;

    VersicherungsArt(String key,String value){
        this.key=key;
        this.value=value;
    }

    public String getKey(){
        return key;
    }
    public String getValue(){
        return  value;
    }

}
