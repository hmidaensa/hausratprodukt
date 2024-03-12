package de.faktorzehn.pfefferminzia.hausratprodukt.service;

import de.faktorzehn.pfefferminzia.hausratprodukt.component.TarifRechnerHausrat;
import de.faktorzehn.pfefferminzia.hausratprodukt.dto.PremiumVersicherungsummeDTO;
import de.faktorzehn.pfefferminzia.hausratprodukt.enumaration.TarifHausratAuswahl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarifRechnerHausratServiceImpl implements TarifRechnerHausratService {
    @Autowired
    private TarifRechnerHausrat tarifRechnerHausrat;

    @Override
    public List<PremiumVersicherungsummeDTO> getPremiumVersicherungsumme(int wohnfleasche) {
        var listtVersicherungsumme = new ArrayList<PremiumVersicherungsummeDTO>();
        listtVersicherungsumme.add(getListVersicherungsumme(TarifHausratAuswahl.THK, wohnfleasche));
        listtVersicherungsumme.add(getListVersicherungsumme(TarifHausratAuswahl.THO, wohnfleasche));
        return listtVersicherungsumme;
    }

    private PremiumVersicherungsummeDTO getListVersicherungsumme(TarifHausratAuswahl tarifHausratAuswahl, int wohnfleasche) {

        var premiumVersicherungsumme = new PremiumVersicherungsummeDTO();
        premiumVersicherungsumme.setTarifHausratAuswahl(tarifHausratAuswahl.getKey());
        premiumVersicherungsumme.setPremiumVersicherungsumme(tarifRechnerHausrat.getPremiumVersicherungsummeByTarif(tarifHausratAuswahl, wohnfleasche));
        return premiumVersicherungsumme;
    }
}
