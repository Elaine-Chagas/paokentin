package com.paokentin.restcontrollers;

import java.sql.SQLException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.paokentin.model.entities.Pao;
import com.paokentin.model.repositories.PaoRepository;

@RestController
@RequestMapping("/pao")
@CrossOrigin("*")
public class PaoController {

    private PaoRepository paoRepository = new PaoRepository();

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Pao pao) {
        try {
            paoRepository.create(pao);
            return ResponseEntity.ok("Pão cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível cadastrar o pão.");
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Pao>> readAll() throws SQLException {
        return ResponseEntity.ok(paoRepository.readAll());
    }
}