package tn.esprit.spring.khaddem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.khaddem.entities.Etudiant;
import tn.esprit.spring.khaddem.services.IEtudiantService;

import java.util.List;
@RestController
@RequestMapping("/something")
public class PrometheusController {
    @GetMapping("/retrieve-all-etudiants")
    public ResponseEntity<String> getEtudiants() {
        return ResponseEntity.ok("");
    }

}



