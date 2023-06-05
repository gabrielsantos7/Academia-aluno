package com.academia.academiaalunos.repository;

import com.academia.academiaalunos.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

/* 
import java.util.List;
public interface AlunoRepository {
    List<Aluno> listAll();
}
*/

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
