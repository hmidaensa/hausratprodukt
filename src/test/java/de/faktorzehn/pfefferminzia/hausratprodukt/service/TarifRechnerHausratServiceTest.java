package de.faktorzehn.pfefferminzia.hausratprodukt.service;


import de.faktorzehn.pfefferminzia.hausratprodukt.component.TarifRechnerHausrat;
import de.faktorzehn.pfefferminzia.hausratprodukt.data.PremiumVersicherungsummeData;
import de.faktorzehn.pfefferminzia.hausratprodukt.enumaration.TarifHausratAuswahl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TarifRechnerHausratServiceTest extends PremiumVersicherungsummeData {

    @InjectMocks
    TarifRechnerHausratService tarifRechnerHausratService = new TarifRechnerHausratServiceImpl();
    @Mock
    TarifRechnerHausrat tarifRechnerHausrat;

    @Test
    @Order(1)
    @DisplayName("checkTarifRechnerHausratServiceTest")
    void checkTarifRechnerHausratServiceTest() {
        assertThat(tarifRechnerHausratService).isNotNull();
        assertThat(tarifRechnerHausrat).isNotNull();
    }

    @Test
    @Order(2)
    @DisplayName("TarifRechnerHausratService test getPremiumVersicherungsumme")
    void cgetPremiumVersicherungsummeTest() {

        when(tarifRechnerHausrat.getPremiumVersicherungsummeByTarif(TarifHausratAuswahl.THK, 60)).thenReturn(39000);
        when(tarifRechnerHausrat.getPremiumVersicherungsummeByTarif(TarifHausratAuswahl.THO, 60)).thenReturn(42000);

        var listAngebote = tarifRechnerHausratService.getPremiumVersicherungsumme(60);

        assertAll("listAngebote",
                () -> assertThat(listAngebote).isNotEmpty(),
                () -> assertThat(listAngebote).isEqualTo(getListPremiumVersicherungsumme()),
                () -> assertThat(listAngebote.get(0)).isEqualTo(getListPremiumVersicherungsumme().get(0)),
                () -> assertThat(listAngebote.get(0).getPremiumVersicherungsumme()).isEqualTo(getListPremiumVersicherungsumme().get(0).getPremiumVersicherungsumme()),
                () -> assertThat(listAngebote.get(0).getTarifHausratAuswahl()).isEqualTo(getListPremiumVersicherungsumme().get(0).getTarifHausratAuswahl())

        );


    }
}
