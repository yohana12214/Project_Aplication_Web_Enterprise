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
    EnterpriseRepository empresaRepositorio;

    public List<Empresa> getallEmpresas(){
        List<Empresa> listadeEmpresas = new ArrayList<>();
        empresaRepositorio.findAll().forEach(empresa -> listadeEmpresas.add(empresa));
        return listadeEmpresas;

    }
    public Empresa getEmpresaById(Integer id){
        return empresaRepositorio.findById(id).get();
    }
    //metodo para definir o actulizar el nombre de la empresa
    public boolean setorChangeEmpresaName(Empresa empresa){
        Empresa emp = empresaRepositorio.save(empresa);
        if(empresaRepositorio.findById(emp.getId()) != null){
            return true;
        }
        return false;
    }
    public boolean EliminateEmpresa(Integer id){
        empresaRepositorio.deleteById(id);
        if (getEmpresaById(id) != null){
            return false;
        }
        return true;
    }



}
