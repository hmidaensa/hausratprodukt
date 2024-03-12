package de.faktorzehn.pfefferminzia.hausratprodukt.dto;

import de.faktorzehn.pfefferminzia.hausratprodukt.enumaration.VersicherungsArt;
import de.faktorzehn.pfefferminzia.hausratprodukt.enumaration.VersicherungsVariant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarifProduktRequest {

    private VersicherungsVariant versicherungsVariant = VersicherungsVariant.PV;
    private VersicherungsArt versicherungsArt = VersicherungsArt.VA1;
}
