package com.academia.academiaalunos.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.academia.academiaalunos.domain.Aluno;
// import com.academia.academiaalunos.repository.AlunoRepository;
import com.academia.academiaalunos.util.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AlunoService {
    private static ArrayList<Aluno> alunos;

    static {
        alunos = new ArrayList<>(List.of(
            new Aluno(1L, "Gabriel", 1.68,57.4, "11 11111-1111", DateUtil.formatDate(9, 4, 2005)), 

            new Aluno(2L, "Pedro", 1.71, 56.9, "22 22222-2222", DateUtil.formatDate(13, 2, 2004))
        ));

    }

    public ArrayList<Aluno> listAll() {
        return alunos;
    }

    public Aluno findById(long id) {
        return alunos.stream()
                .filter(aluno -> aluno.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Aluno com o id " +id+ " não foi encontrado."));
    }

    public Aluno save(Aluno aluno) {
        aluno.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        alunos.add(aluno);
        return aluno;
    }

    public void delete(long id) {
        alunos.remove(findById(id));
    }

    public void replace(Aluno aluno) {
        delete(aluno.getId());
        alunos.add(aluno);
    }
}
