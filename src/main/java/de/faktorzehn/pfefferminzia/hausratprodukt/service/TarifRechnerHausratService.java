package de.faktorzehn.pfefferminzia.hausratprodukt.service;

import de.faktorzehn.pfefferminzia.hausratprodukt.dto.PremiumVersicherungsummeDTO;
import java.util.List;

public interface TarifRechnerHausratService {
    List<PremiumVersicherungsummeDTO> getPremiumVersicherungsumme(int wohnfleasche);

}
