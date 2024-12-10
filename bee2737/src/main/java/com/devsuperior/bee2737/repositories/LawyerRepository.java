package com.devsuperior.bee2737.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.bee2737.dto.LawyerMinDTO;
import com.devsuperior.bee2737.entities.Lawyer;
import com.devsuperior.bee2737.projections.LawyerMinProjection;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

    @Query(nativeQuery = true, value = "(SELECT lawyers.name, customers_number AS customersNumber FROM lawyers " +
                "WHERE customers_number = (SELECT MAX(customers_number) FROM lawyers)) " +
                "UNION ALL " +
                "(SELECT lawyers.name, customers_number AS customersNumber FROM lawyers " +
                "WHERE customers_number = (SELECT MIN(customers_number) FROM lawyers)) " +
                "UNION ALL " +
                "(SELECT 'Average', ROUND(AVG(customers_number), 0) FROM lawyers)")
    List<LawyerMinProjection> search1();

    @Query("(SELECT new com.devsuperior.bee2737.dto.LawyerMinDTO(obj.name, obj.customersNumber) FROM Lawyer obj " +
                "WHERE  = (SELECT MAX(obj.customersNumber) FROM lawyers obj)) " +
                "UNION ALL " +
                "(SELECT obj.name, obj.customersNumber FROM Lawyer obj " +
                "WHERE obj.customersNumber = (SELECT MIN(obj.customersNumber) FROM Lawyer obj)) " +
                "UNION ALL " +
                "(SELECT 'Average', ROUND(AVG(obj.customersNumber), 0) FROM Lawyer obj)")
    List<LawyerMinDTO> search2();

}
