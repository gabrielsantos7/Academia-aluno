package com.academia.academiaalunos.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.academia.academiaalunos.domain.Aluno;
import com.academia.academiaalunos.service.AlunoService;
import com.academia.academiaalunos.util.DateUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@RequestMapping("alunos")
@Log4j2
@RequiredArgsConstructor
public class AlunoController {
    private final DateUtil dateUtil;
    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<ArrayList<Aluno>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(alunoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable long id){
        return ResponseEntity.ok(alunoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody Aluno aluno){
        return new ResponseEntity<>(alunoService.save(aluno), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        alunoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Aluno aluno) {
        alunoService.replace(aluno);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}