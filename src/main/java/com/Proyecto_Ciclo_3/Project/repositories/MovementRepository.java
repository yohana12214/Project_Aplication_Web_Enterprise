package com.Proyecto_Ciclo_3.Project.repositories;


import com.Proyecto_Ciclo_3.Project.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository <MovimientoDinero,Integer>{

}