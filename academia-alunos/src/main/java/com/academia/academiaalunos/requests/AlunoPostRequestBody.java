package com.academia.academiaalunos.requests;

import java.time.LocalDate;
import lombok.Data;

@Data

public class AlunoPostRequestBody {
    private String nome;
    private double altura;
    private double peso;
    private String telefone;
    private LocalDate dataNascimento;
}
