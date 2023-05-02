package com.academia.academiaalunos.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.academia.academiaalunos.domain.Aluno;
import com.academia.academiaalunos.util.DateUtil;

import java.util.ArrayList;

@Service
public class AlunoService {
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    private DateUtil dateUtil = new DateUtil();

    public AlunoService(){
        inserirAluno(1L, "Gabriel", 1.68,57.4, "11 11111-1111", dateUtil.formatarData(9, 4, 2005));

        inserirAluno(2L, "Pedro", 1.71, 56.9, "22 22222-2222", dateUtil.formatarData(13, 2, 2004));

        inserirAluno(3L, "Maria", 1.66, 56.4, "33 33333-3333", dateUtil.formatarData(4, 1, 2000));
    }

    public void inserirAluno(Long id, String nome, double altura, double peso, String telefone, String datanascimento){
        Aluno aluno = new Aluno(id, nome, altura, peso, telefone, datanascimento);
        alunos.add(aluno);
    }

    public ArrayList<Aluno> listAll() {
        return alunos;
    }

    public Aluno findById(long id) {
        return alunos.stream()
                .filter(aluno -> aluno.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi encontrado nenhum Aluno com o id "+id));
    }
}
