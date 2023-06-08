package com.academia.academiaalunos.repository;

import com.academia.academiaalunos.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
//import org.springframework.stereotype.Repository;

/* 

public interface AlunoRepository {
    List<Aluno> listAll();
}
*/

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNome(String nome);
}
