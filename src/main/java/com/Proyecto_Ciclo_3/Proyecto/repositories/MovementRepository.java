package com.Proyecto_Ciclo_3.Proyecto.repositories;


import com.Proyecto_Ciclo_3.Proyecto.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository <MovimientoDinero,Integer>{

}