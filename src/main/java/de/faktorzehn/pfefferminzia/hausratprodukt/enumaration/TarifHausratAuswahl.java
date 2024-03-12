package de.faktorzehn.pfefferminzia.hausratprodukt.enumaration;

public enum TarifHausratAuswahl {
    THK("Kompakt", 650),
    THO("Optimal", 700);
    private final String key;
    private final Integer value;

    TarifHausratAuswahl(String key, Integer value) {
        this.key = key;
        this.value = value;

    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }
}
