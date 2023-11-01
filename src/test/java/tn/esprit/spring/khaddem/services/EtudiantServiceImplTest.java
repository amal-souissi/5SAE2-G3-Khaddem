package tn.esprit.spring.khaddem.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import tn.esprit.spring.khaddem.entities.Etudiant;
import tn.esprit.spring.khaddem.repositories.EtudiantRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;



//@SpringBootTest
//@ExtendWith(MockitoExtension.class)


public class EtudiantServiceImplTest {

    @InjectMocks
    EtudiantServiceImpl etudiantService;

    @Mock
    EtudiantRepository etudiantRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // initialize mocks

        // Test data setup
        Etudiant etudiant1 = new Etudiant();
        etudiant1.setIdEtudiant(1);
        etudiant1.setNomE("Amal");

        Etudiant etudiant2 = new Etudiant();
        etudiant2.setIdEtudiant(2);
        etudiant2.setNomE("Aya");

        // Mock behavior for the repository
        Mockito.when(etudiantRepository.findAll()).thenReturn(Arrays.asList(etudiant1, etudiant2));
        Mockito.when(etudiantRepository.save(ArgumentMatchers.any(Etudiant.class))).thenAnswer(invocation -> invocation.getArgument(0));
    }

    @Test
    public void testRetrieveAllEtudiant() {
        List<Etudiant> etudiants = etudiantService.retrieveAllEtudiants();

        Assertions.assertEquals(2, etudiants.size());
        Assertions.assertTrue(etudiants.stream().anyMatch(d -> d.getNomE().equals("Amal")));
        Assertions.assertTrue(etudiants.stream().anyMatch(d -> d.getNomE().equals("Aya")));
    }

    @Test
    public void testAddEtudiant() {
       Etudiant etudiant= new Etudiant();
        etudiant.setNomE("Souissi");

        Etudiant savedEtudiant = etudiantService.addEtudiant(etudiant );

        Assertions.assertNotNull(savedEtudiant);
        Assertions.assertEquals("Souissi", savedEtudiant.getNomE());

        // Verify that the save method was called once
        Mockito.verify(etudiantRepository, Mockito.times(1)).save(etudiant);

    }

}
