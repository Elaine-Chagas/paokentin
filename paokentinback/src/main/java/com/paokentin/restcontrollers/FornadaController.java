package com.paokentin.restcontrollers;

import java.sql.SQLException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.paokentin.model.entities.Fornada;
import com.paokentin.model.entities.Pao;
import com.paokentin.model.repositories.FornadaRepository;
import com.paokentin.model.repositories.PaoRepository;

@RestController
@RequestMapping("/fornada")
@CrossOrigin("*")
public class FornadaController {

    private FornadaRepository fornadaRepository = new FornadaRepository();
    private PaoRepository paoRepository = new PaoRepository();

    @PostMapping
    public ResponseEntity<Fornada> create(@RequestBody Pao pao) {
        try {
            Fornada fornada = new Fornada();
            Pao paoCompleto = paoRepository.read(pao.getCodigo());
            fornada.setPao(paoCompleto);
            fornadaRepository.create(fornada);
            return ResponseEntity.ok(fornada);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Fornada>> readAll() throws SQLException {
        return ResponseEntity.ok(fornadaRepository.readAll());
    }
}
