package com.Proyecto_Ciclo_3.Project.services;


import com.Proyecto_Ciclo_3.Project.entities.Empresa;
import com.Proyecto_Ciclo_3.Project.repositories.EnterpriseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService {
    @Autowired //enlaza con EnterpriseRepository
    EnterpriseRepository enterpriseRepository;

    /*-------------------------- GET  Y POST --------------------------------------------*/
    public List<Empresa> GetAllEnterprises(){ //genera un listado de todas las empresas
        List<Empresa> EnterpriseList = new ArrayList<>(); //se crea una lista tipo Array de Empresa
        //por cada empresa registrada, se guarda en la lista de Empresa y se agrega al repositorio Empresa
        enterpriseRepository.findAll().forEach(enterprise -> EnterpriseList.add(enterprise));
        return EnterpriseList; //retorna toda la lista Empresa
    }

    /*-------------------------- GET con parámetro--------------------------------------------*/
    public Optional<Empresa> GetEnterpriseById(Integer id){
        return enterpriseRepository.findById(id);
    }


    /*--------------------------------- PATCH --------------------------------------------*/
    public boolean SelectOrChangeEnterpriseName(Empresa empresa){
        Empresa emp = enterpriseRepository.save(empresa);
        return enterpriseRepository.findById(emp.getId()).isPresent();
    }

    /*-------------------------------- DELETE --------------------------------------------*/
    public boolean DeleteEnterprise(Integer id){
        if(GetEnterpriseById(id).isPresent()){
            enterpriseRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
