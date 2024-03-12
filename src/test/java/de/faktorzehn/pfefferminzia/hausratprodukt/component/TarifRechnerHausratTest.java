package de.faktorzehn.pfefferminzia.hausratprodukt.component;

import de.faktorzehn.pfefferminzia.hausratprodukt.enumaration.TarifHausratAuswahl;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import static org.assertj.core.api.Assertions.assertThat;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TarifRechnerHausratTest {
    @InjectMocks
    TarifRechnerHausrat tarifRechnerHausrat;


    @Test
    @Order(1)
    void checkTarifRechnerHausratTest() {
        assertThat(tarifRechnerHausrat).isNotNull();
    }

    @Test
    @Order(2)
    void getPremiumVersicherungsummeByTarifTest() {
        assertThat(tarifRechnerHausrat.getPremiumVersicherungsummeByTarif(TarifHausratAuswahl.THO, 60)).isEqualTo(42000);
        assertThat(tarifRechnerHausrat.getPremiumVersicherungsummeByTarif(TarifHausratAuswahl.THK, 60)).isEqualTo(39000);
    }
}
