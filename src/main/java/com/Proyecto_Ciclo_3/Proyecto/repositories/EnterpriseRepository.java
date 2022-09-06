package com.Proyecto_Ciclo_3.Proyecto.repositories;


import com.Proyecto_Ciclo_3.Proyecto.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository <Empresa,Integer>{

}
