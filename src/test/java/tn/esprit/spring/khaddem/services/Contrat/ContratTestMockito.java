package tn.esprit.spring.khaddem.services.Contrat;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.khaddem.entities.Contrat;
import tn.esprit.spring.khaddem.entities.Specialite;
import tn.esprit.spring.khaddem.repositories.ContratRepository;
import tn.esprit.spring.khaddem.services.IContratService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ContratTestMockito {

    @Mock
    ContratRepository contratRepository;
    @InjectMocks
    IContratService iContratService;
     Contrat contrat =Contrat.builder().idContrat(12).dateDebutContrat(new Date(2009,10,12)).dateFinContrat(new Date(2010,10,12)).specialite(Specialite.RESEAU).archived(true).montantContrat(1200).build();


    Contrat updatedContrat = Contrat.builder().idContrat(12).dateDebutContrat(new Date(2010,10,12)).dateFinContrat(new Date(2011,10,12)).specialite(Specialite.RESEAU).archived(true).montantContrat(1400).build();

    List<Contrat> list= new ArrayList<Contrat>() {
        {
            add(Contrat.builder().idContrat(12).dateDebutContrat(new Date(2009,10,12)).dateFinContrat(new Date(2010,10,12)).specialite(Specialite.RESEAU).archived(true).montantContrat(1200).build());
            add(Contrat.builder().idContrat(13).dateDebutContrat(new Date(2009,10,12)).dateFinContrat(new Date(2010,10,12)).specialite(Specialite.RESEAU).archived(true).montantContrat(1200).build());
        }
    };

    @Test
     void insertPisteTest() {
        Mockito.when(contratRepository.save(Mockito.any(Contrat.class))).then(invocation -> {
            Contrat model = invocation.getArgument(0, Contrat.class);
            model.setIdContrat(1);
            return model;
        });
        log.info("Avant ==> " + contrat.toString());
        Contrat newPiste = iContratService.addContrat(contrat);
        assertSame(newPiste, contrat);
        log.info("Après ==> " + contrat.toString());
    }

    @Test
     void selectByIdPisteTest() {
        Mockito.when(contratRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(contrat));
        Contrat newPiste = iContratService.retrieveContrat(1566);
        assertNotNull(newPiste);
        log.info("get ==> " + newPiste.toString());
        verify(contratRepository).findById(Mockito.anyInt());
    }

    @Test
     void selectAllPisteTest() {
        Mockito.when(contratRepository.findAll()).thenReturn(list);
        List<Contrat> list_piste = iContratService.retrieveAllContrats();
        assertNotNull(list_piste);
    }

    @Test
    void deletePisteTest() {
        int pisteIdToDelete = 12; // Replace with the ID of the Piste you want to delete

        // Mock the behavior of the repository when deleting a Piste
        Mockito.doNothing().when(contratRepository).deleteById(pisteIdToDelete);

        // Call the delete method from your service
        iContratService.removeContrat(pisteIdToDelete);

        Contrat newPiste = iContratService.retrieveContrat( pisteIdToDelete);
        assertNull(newPiste);
    }








}