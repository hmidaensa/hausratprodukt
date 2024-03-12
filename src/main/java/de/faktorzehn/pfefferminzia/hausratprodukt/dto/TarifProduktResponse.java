package de.faktorzehn.pfefferminzia.hausratprodukt.dto;


import de.faktorzehn.pfefferminzia.hausratprodukt.enumaration.VersicherungsArt;
import de.faktorzehn.pfefferminzia.hausratprodukt.enumaration.VersicherungsVariant;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TarifProduktResponse {

    private List<PremiumVersicherungsummeDTO> premiumVersicherungsumme = new ArrayList<>();
    private String versicherungsArt = VersicherungsArt.VA1.getValue();

    private String versicherungsVariant = VersicherungsVariant.PV.getValue();
}
