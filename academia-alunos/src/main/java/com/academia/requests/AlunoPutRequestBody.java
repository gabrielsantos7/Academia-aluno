package com.academia.requests;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AlunoPutRequestBody {
    private Long id;
    private String nome;
    private double altura;
    private double peso;
    private String telefone;
    private LocalDate dataNascimento;
}
