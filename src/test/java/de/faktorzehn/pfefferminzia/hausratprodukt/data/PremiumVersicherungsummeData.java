package de.faktorzehn.pfefferminzia.hausratprodukt.data;

import de.faktorzehn.pfefferminzia.hausratprodukt.dto.PremiumVersicherungsummeDTO;
import de.faktorzehn.pfefferminzia.hausratprodukt.dto.TarifProduktRequest;
import de.faktorzehn.pfefferminzia.hausratprodukt.dto.TarifProduktResponse;
import de.faktorzehn.pfefferminzia.hausratprodukt.enumaration.VersicherungsVariant;

import java.util.ArrayList;
import java.util.List;

public class PremiumVersicherungsummeData {


    protected List<PremiumVersicherungsummeDTO> getListPremiumVersicherungsumme() {
        var listPremiumVersicherung = new ArrayList<PremiumVersicherungsummeDTO>();
        var dto = new PremiumVersicherungsummeDTO();
        dto.setTarifHausratAuswahl("Kompakt");
        dto.setPremiumVersicherungsumme(39000);
        listPremiumVersicherung.add(dto);
        dto = new PremiumVersicherungsummeDTO();
        dto.setTarifHausratAuswahl("Optimal");
        dto.setPremiumVersicherungsumme(42000);
        listPremiumVersicherung.add(dto);
        return listPremiumVersicherung;
    }


    protected TarifProduktResponse getTarifProduktResponse() {
        var tarifProduktResponse = new TarifProduktResponse();
        tarifProduktResponse.setPremiumVersicherungsumme(getListPremiumVersicherungsumme());
        return tarifProduktResponse;
    }

    protected TarifProduktRequest createTarifProduktRequest() {
        var tarifProduktRequest = new TarifProduktRequest();
        tarifProduktRequest.setVersicherungsVariant(VersicherungsVariant.BV);
        return tarifProduktRequest;
    }
}
