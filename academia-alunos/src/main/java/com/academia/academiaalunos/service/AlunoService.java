package com.academia.academiaalunos.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.academia.academiaalunos.domain.Aluno;
import com.academia.academiaalunos.repository.AlunoRepository;
// import com.academia.academiaalunos.repository.AlunoRepository;
//import com.academia.academiaalunos.util.DateUtil;
import com.academia.requests.AlunoPostRequestBody;
import com.academia.requests.AlunoPutRequestBody;

import lombok.RequiredArgsConstructor;

//import java.util.ArrayList;
//import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

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

    public List<Aluno> findByNome(String nome) {
        return alunoRepository.findByNome(nome);
    }
    
    public Aluno findByIdOrThrowBadRequestException(long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Aluno com o id " + id + " não foi encontrado."));
    }
    
    public Aluno save(AlunoPostRequestBody alunoPostRequestBody) {
        return alunoRepository.save(
            Aluno.builder()
                .nome(alunoPostRequestBody.getNome())
                .altura(alunoPostRequestBody.getAltura())
                .peso(alunoPostRequestBody.getPeso())
                .telefone(alunoPostRequestBody.getTelefone())
                .dataNascimento(alunoPostRequestBody.getDataNascimento())
                .build()
        );
    }

    public void replace(AlunoPutRequestBody alunoPutRequestBody) {
        Aluno savedAluno = findByIdOrThrowBadRequestException(alunoPutRequestBody.getId());
        Aluno aluno = Aluno.builder()
                .id(savedAluno.getId())
                .nome(alunoPutRequestBody.getNome())
                .altura(alunoPutRequestBody.getAltura())
                .peso(alunoPutRequestBody.getPeso())
                .telefone(alunoPutRequestBody.getTelefone())
                .dataNascimento(alunoPutRequestBody.getDataNascimento())
                .build();
    
        alunoRepository.save(aluno);
    }
    
    public void delete(long id) {
        alunoRepository.delete(findByIdOrThrowBadRequestException(id));
    }
    
}
