package de.faktorzehn.pfefferminzia.hausratprodukt.web;

import de.faktorzehn.pfefferminzia.hausratprodukt.constants.Constants;
import de.faktorzehn.pfefferminzia.hausratprodukt.dto.TarifProduktRequest;
import de.faktorzehn.pfefferminzia.hausratprodukt.dto.TarifProduktResponse;
import de.faktorzehn.pfefferminzia.hausratprodukt.service.TarifRechnerHausratService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(name = Constants.API)
public class TarifRechnerHausratController {
    @Autowired
    TarifRechnerHausratService tarifRechnerHausratService;

    @PostMapping(name = Constants.API_RECHNEN)
    public ResponseEntity<TarifProduktResponse> erstelleAngebotHausratPremiumVariante(@RequestBody TarifProduktRequest tarifProduktRequest, @RequestParam(name = "wohnfleasche") int wohnfleasche) {
        log.info("  ---- Begin erstelleAngebotHausratPremiumVariante --- ");

        TarifProduktResponse tarifProduktResponse = new TarifProduktResponse();
        switch (tarifProduktRequest.getVersicherungsVariant()) {
            case PV:
                tarifProduktResponse.setPremiumVersicherungsumme(tarifRechnerHausratService.getPremiumVersicherungsumme(wohnfleasche));
                break;
            default:
                log.info("Auf Basis Ihrer eingegeben Versicherungsvariant kann System zurzeit kein Produkt anbieten.");
        }

        log.info("  ---- End erstelleAngebotHausratPremiumVariante --- ");

        return new ResponseEntity<>(tarifProduktResponse, HttpStatus.OK);
    }
}
