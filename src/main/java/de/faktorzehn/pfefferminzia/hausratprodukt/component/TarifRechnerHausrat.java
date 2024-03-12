package de.faktorzehn.pfefferminzia.hausratprodukt.component;


import de.faktorzehn.pfefferminzia.hausratprodukt.enumaration.TarifHausratAuswahl;
import org.springframework.stereotype.Component;

@Component
public class TarifRechnerHausrat {
    /**
     *
     * @param tarifHausratAuswahl
     * @param wohnfleasche
     * @return
     */
    public  Integer getPremiumVersicherungsummeByTarif(TarifHausratAuswahl tarifHausratAuswahl, int wohnfleasche){

        return  tarifHausratAuswahl.getValue()*wohnfleasche;
    }
}
