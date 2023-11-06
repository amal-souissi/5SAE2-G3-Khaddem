package tn.esprit.spring.khaddem.services.Contrat;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring.khaddem.entities.Contrat;
import tn.esprit.spring.khaddem.entities.Etudiant;
import tn.esprit.spring.khaddem.entities.Specialite;
import tn.esprit.spring.khaddem.repositories.ContratRepository;
import tn.esprit.spring.khaddem.repositories.EtudiantRepository;
import tn.esprit.spring.khaddem.services.IContratService;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@Slf4j
class ContratWithUnitTestApplication{

    @Autowired
    ContratRepository contratRepository;
    @Autowired
    private IContratService contratService;
    @Autowired
    private EtudiantRepository etudiantRepository;

  /* Etudiant student = Etudiant.builder()
           .prenomE("zaineb")
           .nomE("bachouch")
           .build();



    Contrat c = Contrat.builder()
            .dateDebutContrat(new Date(2009, 10, 12))
            .dateFinContrat(new Date(2010, 10, 12))
            .specialite(Specialite.RESEAU)
            .archived(true)
            .montantContrat(1200)
            .etudiant(a) // Associate the Contrat with the Etudiant
            .build();*/
    @Test
    @Order(1)
    public void addContratTest() {
        Etudiant student = Etudiant.builder()
                .prenomE("zaineb")
                .nomE("bachouch")
                .build();

        student = etudiantRepository.save(student);
        log.info("Saved hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhEtudiant: " + student);
        Contrat contrat = Contrat.builder()
                .dateDebutContrat(new Date(2009, 10, 12))
                .dateFinContrat(new Date(2010, 10, 12))
                .specialite(Specialite.RESEAU)
                .archived(true)
                .montantContrat(1200)
                .etudiant(student) // Associate the Contrat with the Etudiant
                .build();

        contrat = contratRepository.save(contrat);

        log.info(contrat.toString());
        Assertions.assertNotNull(contrat.getIdContrat());
    }
    @Test
    @Order(2)
    public void retrieveContractsByStudentTest() {
        int studentId =21;
        // Query the student by ID
        Etudiant student = etudiantRepository.findById(studentId).orElse(null);

        if (student == null) {
            log.info("No student found with ID: " + studentId);
        } else {
            // Call the service method to retrieve contracts
            List<Contrat> contracts = contratService.retrieveContractsByStudent(studentId);

            // Assertions based on your test scenario
            // Assert that the 'contracts' list is empty for a non-existent student
            Assertions.assertTrue(!contracts.isEmpty(), "Contracts should be found for an existing student");
            // Assertions based on your test scenario
            // For example, you can assert that the 'contracts' list is not empty
            //  Assertions.assertTrue(!contracts.isEmpty());

            // You can add more specific assertions based on your test cases
            for (Contrat contrat : contracts) {
                log.info(contrat.toString()); // You can log the contracts for inspection
                Assertions.assertEquals(studentId, contrat.getEtudiant().getIdEtudiant());
            }
        }
        }


  /*  @Test
    @Order(1)
    public void modifierMagasinTest() {
        c.setSpecialite(Specialite.CLOUD);
        c = contratRepository.save(c);
        log.info(c.toString());
        Assertions.assertNotEquals(c.getSpecialite(), Specialite.RESEAU);
    }

    @Test
    @Order(2)
    public void listerMagasins() {
        List<Contrat> list = contratRepository.findAll();
        log.info(list.size()+"");
        Assertions.assertTrue(list.size() > 0);
    }

    @Test
    @Order(3)
    public void chercherMagasinAvecId() {
        log.info(m.getId()+"");
        Magasin m1 = contratRepository.findById(m.getId()).get();
        Assertions.assertEquals(m1.getAdresse(),m.getAdresse());
    }*/
/*
    @Test
    @Order(4)
    public void supprimerMagasin() {
        contratRepository.delete(c);
    }

    @Test
    @Order(5)
    public void compter() {
        long taille = contratRepository.count();
        Assertions.assertEquals(taille,contratRepository.findAll().size());
    }*/

   // @Test
   /* public void retrieveContractsByStudentTest() {
        // Replace 'yourStudentId' with the ID of the student you want to test
        int studentId = 1;

        // Call the service method to retrieve contracts
        List<Contrat> contracts = contratService.retrieveContractsByStudent(studentId);

        // Assertions based on your test scenario
        // Assert that the 'contracts' list is empty for a non-existent student
       Assertions.assertTrue(contracts.isEmpty(), "No contracts should be found for a non-existent student");

        // Assertions based on your test scenario
        // For example, you can assert that the 'contracts' list is not empty
      //  Assertions.assertTrue(!contracts.isEmpty());

        // You can add more specific assertions based on your test cases
        for (Contrat contrat : contracts) {
            log.info(contrat.toString()); // You can log the contracts for inspection
            Assertions.assertEquals(studentId, contrat.getEtudiant().getIdEtudiant());
        }
    }*/
       /* Etudiant student = Etudiant.builder().prenomE("John").nomE("Doe").build();

    Etudiant studente = etudiantRepository.save(student);
    Contrat c =Contrat.builder().dateDebutContrat(new Date(2009,10,12)).dateFinContrat(new Date(2010,10,12)).specialite(Specialite.RESEAU).archived(true).montantContrat(1200).etudiant(student).build();

*/
}
