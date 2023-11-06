package tn.esprit.spring.khaddem.services.Contrat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.khaddem.entities.Contrat;
import tn.esprit.spring.khaddem.entities.Etudiant;
import tn.esprit.spring.khaddem.entities.Specialite;
import tn.esprit.spring.khaddem.repositories.ContratRepository;
import tn.esprit.spring.khaddem.services.ContratServiceImpl;
import tn.esprit.spring.khaddem.services.IContratService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
@ExtendWith(MockitoExtension.class)
class ContratTestMockito {

    @Mock
    ContratRepository contratRepository;

    /*@InjectMocks
    IContratService contratService;
*/
    @InjectMocks
    private ContratServiceImpl contratService;
    @BeforeEach
    void setUp() {
        // Initialize or set up any required data before each test.
        Date currentDate = new Date(109, 10, 12);  // Year is 109, month is 10 (November), day is 12
        Date futureDate = new Date(110, 10, 12);   // Year is 110, month is 10 (November), day is 12

        Specialite specialite = Specialite.CLOUD; // Replace with an actual Specialite value

        Contrat contrat = Contrat.builder()
                .idContrat(1)
                .dateDebutContrat(currentDate)
                .dateFinContrat(futureDate)
                .specialite(specialite)
                .archived(false)
                .montantContrat(1000) // Replace with an actual value
                .etudiant(createSampleEtudiant())  // Create a sample Etudiant
                .build();
    }


    private Etudiant createSampleEtudiant() {
        return Etudiant.builder()
                .idEtudiant(1)
                .nomE("bachouch")
                .prenomE("zaineb")
                .build();
    }

    @Test
    public void testRetrieveContractsAboutToExpire() {
        // Define the input parameters
        int daysToExpire = 7;
        Date currentDate = new Date(109, 10, 12);
        Date futureDate = calculateFutureDate(currentDate, daysToExpire);

        // Define a list of contracts that you expect to be returned
        List<Contrat> expectedContracts = new ArrayList<>();
        // Create a Contrat object with actual details
        Contrat expectedContrat1 = Contrat.builder()
                .idContrat(1)
                .dateDebutContrat(new Date(2009, 10, 12))
                .dateFinContrat(futureDate) // Use the calculated futureDate
                .specialite(Specialite.CLOUD) // Replace with an actual Specialite value
                .archived(false)
                .montantContrat(11111)
                .etudiant(createSampleEtudiant()) // Use the sample Etudiant created in the setUp method
                .build();
        expectedContracts.add(expectedContrat1);

        // Mock the behavior of the contratRepository
        when(contratRepository.findContractsAboutToExpire(any(Date.class), any(Date.class))).thenReturn(expectedContracts);

        // Call the method you want to test
        List<Contrat> actualContracts = contratService.retrieveContractsAboutToExpire(daysToExpire);

        // Assert that the actual contracts match the expected contracts
        assertEquals(expectedContracts, actualContracts);
        // You can add more specific assertions as needed
    }


    // Helper method to calculate the future date based on current date and days to expire
    private Date calculateFutureDate(Date currentDate, int daysToExpire) {
        currentDate.setTime(currentDate.getTime() + daysToExpire * 24 * 60 * 60 * 1000); // Add milliseconds for days
        return currentDate;
    }






}
