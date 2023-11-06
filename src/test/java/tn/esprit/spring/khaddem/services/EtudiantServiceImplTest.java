package tn.esprit.spring.khaddem.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.khaddem.entities.Departement;
import tn.esprit.spring.khaddem.entities.Etudiant;
import tn.esprit.spring.khaddem.entities.Option;
import tn.esprit.spring.khaddem.repositories.DepartementRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EtudiantServiceImplTest {

    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @Mock
    private DepartementRepository departementRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testCalculateAverageAgeInDepartment() {

        // Create a sample department
        Departement department = new Departement();
        department.setIdDepartement(1);
        department.setNomDepart("IT");

        // Create a list of students in the department
        List<Etudiant> students = Arrays.asList(
                new Etudiant(1, "John", "Doe", 25, Option.GAMIX, department, null, null),
                new Etudiant(2, "Jane", "Smith", 22, Option.SAE, department, null, null)
        );

        department.setEtudiants(students);



        // Mock the behavior of the repository to return the department
        when(departementRepository.findById(1)).thenReturn(Optional.of(department));

        // Calculate the average age
        double averageAge = etudiantService.calculateAverageAgeInDepartment(1);

        // Verify the result
        assertEquals(23.5, averageAge, 0.01); // Using a delta for double comparison
    }
}
