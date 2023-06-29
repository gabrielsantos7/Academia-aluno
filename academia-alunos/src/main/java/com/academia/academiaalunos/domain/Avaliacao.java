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
    @Column(name = "id_avaliacao")
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_aluno")
    private Aluno aluno;

    @Column(name = "dataAvaliacao")
    private LocalDate data;

    @Column(name = "peso")
    private double peso;

    @Column(name = "altura")
    private double altura;

    @ElementCollection
    @CollectionTable(name = "medidas", joinColumns = @JoinColumn(name = "id_avaliacao"))
    @Column(name = "valor")
    private List<Double> medidas;

    private double porcentagemGordura;

    private String observacoes;
}
