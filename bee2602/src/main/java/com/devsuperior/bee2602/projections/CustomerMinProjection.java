package com.devsuperior.bee2602.projections;

/* Projections - interface - são uma forma de mapear consultas diretamente em objetos que contêm apenas os campos necessários.
São geralmente utilizados no contexto de consultas com JPA/Hibernate para melhorar a performance ao evitar o carregamento de dados desnecessários. */

public interface CustomerMinProjection {

    String getName();
    
}
