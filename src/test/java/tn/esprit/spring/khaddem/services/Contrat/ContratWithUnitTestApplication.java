package tn.esprit.spring.khaddem.services.Contrat;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring.khaddem.entities.Contrat;
import tn.esprit.spring.khaddem.entities.Specialite;
import tn.esprit.spring.khaddem.repositories.ContratRepository;

import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@Slf4j
class ContratWithUnitTestApplication{

    @Autowired
    ContratRepository contratRepository;

    Contrat c =Contrat.builder().dateDebutContrat(new Date(2009,10,12)).dateFinContrat(new Date(2010,10,12)).specialite(Specialite.RESEAU).archived(true).montantContrat(1200).build();



    @Test
    @Order(0)
    public void ajouterMagasinTest() {
        c = contratRepository.save(c);
        log.info(c.toString());
        Assertions.assertNotNull(c.getIdContrat());
    }

    @Test
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

   /* @Test
    @Order(3)
    public void chercherMagasinAvecId() {
        log.info(m.getId()+"");
        Magasin m1 = contratRepository.findById(m.getId()).get();
        Assertions.assertEquals(m1.getAdresse(),m.getAdresse());
    }*/

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
    }
}
