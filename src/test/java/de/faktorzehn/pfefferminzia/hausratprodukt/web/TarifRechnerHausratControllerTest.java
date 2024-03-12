package de.faktorzehn.pfefferminzia.hausratprodukt.web;


import de.faktorzehn.pfefferminzia.hausratprodukt.data.PremiumVersicherungsummeData;
import de.faktorzehn.pfefferminzia.hausratprodukt.dto.TarifProduktRequest;
import de.faktorzehn.pfefferminzia.hausratprodukt.service.TarifRechnerHausratService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TarifRechnerHausratControllerTest extends PremiumVersicherungsummeData {
    @InjectMocks
    TarifRechnerHausratController tarifRechnerHausratController;
    @Mock
    TarifRechnerHausratService tarifRechnerHausratService;

    @Test
    @Order(1)
    @DisplayName("checkTarifRechnerHausratControllerTest")
    void checkTarifRechnerHausratControllerTest() {
        assertThat(tarifRechnerHausratController).isNotNull();
        assertThat(tarifRechnerHausratService).isNotNull();
    }

    @Test
    @Order(2)
    @DisplayName("TarifRechnerHausratControllerTest test getPremiumVersicherungsummeTest")
    void getPremiumVersicherungsummeTest() {

        when(tarifRechnerHausratService.getPremiumVersicherungsumme(60)).thenReturn(getListPremiumVersicherungsumme());

        var listAngebote = tarifRechnerHausratController.erstelleAngebotHausratPremiumVariante(new TarifProduktRequest(), 60);

        assertAll("listAngebote",
                () -> assertThat(listAngebote.getBody()).isNotNull(),
                () -> assertThat(listAngebote.getStatusCode()).isEqualTo(HttpStatus.OK),
                () -> assertThat(listAngebote.getBody().getVersicherungsArt()).isEqualTo(getTarifProduktResponse().getVersicherungsArt()),
                () -> assertThat(listAngebote.getBody().getVersicherungsVariant()).isEqualTo(getTarifProduktResponse().getVersicherungsVariant()),
                () -> assertThat(listAngebote.getBody().getPremiumVersicherungsumme()).isNotEmpty()
        );

        var listAngeboteNonPremium = tarifRechnerHausratController.erstelleAngebotHausratPremiumVariante(createTarifProduktRequest(), 60);
        assertAll("listAngeboteNonPremium",
                () -> assertThat(listAngeboteNonPremium.getBody()).isNotNull(),
                () -> assertThat(listAngeboteNonPremium.getBody().getPremiumVersicherungsumme()).isEmpty()
        );

    }
}
