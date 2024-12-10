package com.devsuperior.bee2990.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.bee2990.dto.EmpregadoDeptDTO;
import com.devsuperior.bee2990.entities.Empregado;
import com.devsuperior.bee2990.projections.EmpregadoDeptProjection;


public interface EmpregadoRepository extends JpaRepository<Empregado, String> {

    @Query(nativeQuery = true, value = "SELECT cpf, enome, departamentos.dnome " + //
                "FROM empregados " + //
                "INNER JOIN departamentos ON empregados.dnumero = departamentos.dnumero " + //
                "LEFT JOIN trabalha ON trabalha.cpf_emp = empregados.cpf " + //
                "WHERE trabalha.cpf_emp IS NULL " + //
                "ORDER BY empregados.cpf")
    List<EmpregadoDeptProjection> search1();

    @Query("SELECT new com.devsuperior.bee2990.dto.EmpregadoDeptDTO(e.cpf, e.enome, e.departamento.dnome) " +
       "FROM Empregado e " +
       "WHERE e.cpf NOT IN ( " +
       "   SELECT emp.cpf " +
       "   FROM Empregado emp " +
       "   JOIN emp.projetosOndeTrabalha p " +
       ") " +
       "ORDER BY e.cpf")
    List<EmpregadoDeptDTO> search2();

}
