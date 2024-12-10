package com.devsuperior.bee2609.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.bee2609.dto.CategorySumDTO;
import com.devsuperior.bee2609.entities.Category;
import com.devsuperior.bee2609.projections.CategorySumProjection;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(nativeQuery = true, value = "SELECT categories.name, SUM(products.amount) " + //
                "FROM categories " + //
                "LEFT JOIN products ON categories.id = products.id_categories " + //
                "GROUP BY categories.name " + //
                "ORDER BY sum DESC;")
    List<CategorySumProjection> search1();

    @Query("SELECT new com.devsuperior.bee2609.dto.CategorySumDTO(obj.category.name, SUM(obj.amount)) " + //
                "FROM Product obj " + //
                "GROUP BY obj.category.name")
    List<CategorySumDTO> search2();
}
