package com.academia.academiaalunos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "avaliacao")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    private LocalDate data;

    private double peso;

    private double altura;

    @ElementCollection
    @CollectionTable(name = "medidas", joinColumns = @JoinColumn(name = "avaliacao_id"))
    @Column(name = "valor")
    private List<Double> medidas;

    private double porcentagemGordura;

    private String observacoes;
}
