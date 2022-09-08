package com.Proyecto_Ciclo_3.Project.services;


import com.Proyecto_Ciclo_3.Project.entities.Empresa;
import com.Proyecto_Ciclo_3.Project.repositories.EnterpriseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnterpriseService {
    @Autowired
    EnterpriseRepository enterpriseRepository;

    public List<Empresa> GetAllEnterprises(){
        List<Empresa> EnterpriseList = new ArrayList<>();
        enterpriseRepository.findAll().forEach(enterprise -> EnterpriseList.add(enterprise));
        return EnterpriseList;

    }
    public Empresa GetEnterpriseById(Integer id){
        return enterpriseRepository.findById(id).get();
    }
    //metodo para definir o actulizar el nombre de la empresa
    public boolean SelectOrChangeEnterpriseName(Empresa empresa){
        Empresa emp = enterpriseRepository.save(empresa);
        if(enterpriseRepository.findById(emp.getId()) != null){
            return true;
        }
        return false;
    }
    public boolean DeleteEnterprise(Integer id){
        enterpriseRepository.deleteById(id);
        if (GetEnterpriseById(id) != null){
            return false;
        }
        return true;
    }



}
