package com.academia.academiaalunos.domain;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "altura")
    private double altura;

    @Column(name = "peso")
    private double peso;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "avaliacao")
    private List<Avaliacao> avaliacoes;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;
}

/* 
Padrão de Requisição JSON
 {
    "nome": "João",
    "altura": 1.68,
    "peso": 68.1,
    "telefone": "(11) 90909-9944",
    "dataNascimento": "2003-10-10"
  }
 */