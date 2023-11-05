package tn.esprit.spring.khaddem.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.khaddem.entities.Contrat;
import tn.esprit.spring.khaddem.entities.Etudiant;
import tn.esprit.spring.khaddem.repositories.ContratRepository;
import tn.esprit.spring.khaddem.repositories.EtudiantRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ContratServiceImplTest {
   /* @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ContratServiceImpl contratService;

    @BeforeEach
    void setUp() {
        // Common setup tasks for all test cases
        // For example, you can create some test data here
        Etudiant student = new Etudiant();
        student.setNomE("bachouch");


        Contrat contrat1 = new Contrat();
        contrat1.setEtudiant(student);

        Contrat contrat2 = new Contrat();
        contrat2.setEtudiant(student);

        contratRepository.save(contrat1);
        contratRepository.save(contrat2);
    }

    @Test
    void retrieveContractsByStudent() {
        // Test the method with the common test data created in setUp
        List<Contrat> foundContracts = contratService.retrieveContractsByStudent("bachouch");

        assertNotNull(foundContracts);
        assertEquals(2, foundContracts.size());
        assertEquals("bachouch", foundContracts.get(0).getEtudiant().getNomE());

        assertEquals("bachouch", foundContracts.get(1).getEtudiant().getNomE());

    }

   @Test
   public void testFindByEtudiantNomEAndEtudiantPrenomE() {
        // Create a sample Etudiant with the matching name and surname
        Etudiant etudiant = new Etudiant();
        etudiant.setNomE("bachouch");
        etudiantRepository.save(etudiant);

        // Create a Contrat associated with the Etudiant
        Contrat contrat = new Contrat();
        contrat.setEtudiant(etudiant);
        contratRepository.save(contrat);

        // Call the method you want to test
        List<Contrat> foundContracts = contratRepository.findContratByEtudiantNomE("bachouch");

        // Make assertions to verify the results
        assertNotNull(foundContracts);
        assertEquals(1, foundContracts.size());
        assertEquals("bachouch", foundContracts.get(0).getEtudiant().getNomE());

    }
*/

}