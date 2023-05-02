package com.academia.academiaalunos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Aluno {
    private Long id;
    private String nome;
    private double altura;
    private double peso;
    private String telefone;
    private String dataNascimento;
    
}
