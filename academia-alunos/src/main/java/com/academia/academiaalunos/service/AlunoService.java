package com.academia.academiaalunos.service;

//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;

import com.academia.academiaalunos.domain.Aluno;
import com.academia.academiaalunos.exception.BadRequestException;
import com.academia.academiaalunos.repository.AlunoRepository;
// import com.academia.academiaalunos.repository.AlunoRepository;
//import com.academia.academiaalunos.util.DateUtil;
import com.academia.academiaalunos.requests.AlunoPostRequestBody;
import com.academia.academiaalunos.requests.AlunoPutRequestBody;

import lombok.RequiredArgsConstructor;

//import java.util.ArrayList;
//import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

import javax.transaction.Transactional;

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
        List<Aluno> alunos = alunoRepository.findByNome(nome);
    
        if (alunos == null || alunos.isEmpty()) {
            throw new BadRequestException("O Aluno com o nome " + nome + " nao foi encontrado.");
        }
    
        return alunos;
    }
    
    public Aluno findByIdOrThrowBadRequestException(long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("O Aluno com o id " + id + " nao foi encontrado."));
    }
    
    @Transactional
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
