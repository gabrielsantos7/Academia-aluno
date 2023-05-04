package com.academia.academiaalunos.repository;

import com.academia.academiaalunos.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    static Aluno save(Aluno aluno) {
        return null;
    }

}
