package com.Proyecto_Ciclo_3.Project.repositories;


import com.Proyecto_Ciclo_3.Project.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Empresa hereda funciones de JPA Repository
@Repository
public interface EnterpriseRepository extends JpaRepository <Empresa,Integer>{

}
