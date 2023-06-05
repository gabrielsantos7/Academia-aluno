package com.academia.academiaalunos.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.academia.academiaalunos.domain.Aluno;
import com.academia.academiaalunos.repository.AlunoRepository;
// import com.academia.academiaalunos.repository.AlunoRepository;
//import com.academia.academiaalunos.util.DateUtil;

import lombok.RequiredArgsConstructor;

//import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AlunoService {
    //private static ArrayList<Aluno> alunos;
    private final AlunoRepository alunoRepository;
/* 
    static {
        alunos = new ArrayList<>(List.of(
            new Aluno(1L, "Gabriel", 1.68,57.4, "11 11111-1111", DateUtil.formatDate(9, 4, 2005)), 

            new Aluno(2L, "Pedro", 1.71, 56.9, "22 22222-2222", DateUtil.formatDate(13, 2, 2004))
        ));

    }
    */

    public List<Aluno> listAll() {
        return alunoRepository.findAll();
    }
    
    public Aluno findById(long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Aluno com o id " + id + " não foi encontrado."));
    }
    
    public Aluno save(Aluno aluno) {
        aluno.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        return alunoRepository.save(aluno);
    }
    
    public void delete(long id) {
        alunoRepository.deleteById(id);
    }
    
    public void replace(Aluno aluno) {
        alunoRepository.save(aluno);
    }
}
