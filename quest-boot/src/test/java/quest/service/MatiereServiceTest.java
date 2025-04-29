package quest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import quest.dao.IDAOMatiere;

// Exécuter le test avec Mockito
@ExtendWith(MockitoExtension.class)
class MatiereServiceTest {
    @Mock // Demander à Mockito d'instancier une daoMatiere
	private IDAOMatiere daoMatiere;

    @InjectMocks // Demander à Mockito de faire toute l'injection de dépendances avec les Mocks qu'il connait
    private MatiereService service;

    // public boolean existById(Integer id) {
	// 	return daoMatiere.existsById(id);
	// }

    @Test
    void shouldExistsByIdReturnFalse() {
        // given
        Mockito.when(this.daoMatiere.existsById(Mockito.any())).thenReturn(false);

        // when
        boolean result = this.service.existById(5);

        // then
        Assertions.assertFalse(result);

        Mockito.verify(this.daoMatiere).existsById(Mockito.any());
    }
    
    @Test
    void shouldExistsByIdReturnTrue() {
        // given
        Mockito.when(this.daoMatiere.existsById(Mockito.any())).thenReturn(true);

        // when
        boolean result = this.service.existById(5);

        // then
        Assertions.assertTrue(result);

        Mockito.verify(this.daoMatiere).existsById(Mockito.any());
    }
    
    @Test
    void shouldExistsByIdCatchExceptionAndReturnFalse() {
        // given
        Mockito.when(this.daoMatiere.existsById(Mockito.any())).thenThrow(new RuntimeException());

        // // when & then
        // Assertions.assertThrows(
        //     RuntimeException.class,
        //     () -> this.service.existById(5)
        // );

        // when
        boolean result = this.service.existById(5);

        // then
        Assertions.assertFalse(result);

        Mockito.verify(this.daoMatiere).existsById(Mockito.any());
    }

    
    
    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    void shouldExistsByIdReturnBoolean(boolean expected) {
        // given
        Mockito.when(this.daoMatiere.existsById(Mockito.any())).thenReturn(expected);

        // when
        boolean result = this.service.existById(5);

        // then
        Assertions.assertEquals(expected, result);

        Mockito.verify(this.daoMatiere).existsById(Mockito.any());
    }
}
