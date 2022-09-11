package com.Proyecto_Ciclo_3.Project.controllers;



import com.Proyecto_Ciclo_3.Project.entities.Empresa;
import com.Proyecto_Ciclo_3.Project.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnterpriseController {
    @Autowired
    EnterpriseService enterpriseService;

    /*-------------------------- GET --------------------------------------------*/
    @GetMapping("/enterprises")//listar todas las empresas creadas
    public List<Empresa> verEmpresas() {
        return enterpriseService.GetAllEnterprises();
    }

    /*---------------------------------- POST --------------------------------------------*/
    @PostMapping("/enterprises")//crear empresa
    //pide un body tipo Json y entrega un booleano: true(exitoso), falta excepcion por si ya existe la empresa
    public boolean SaveEnterprise(@RequestBody Empresa empresa) {
        return this.enterpriseService.SelectOrChangeEnterpriseName(empresa);
    }

    /*-------------------------- GET CON parámetro (id) --------------------------------------------*/
    @GetMapping(path = "/enterprises/{id}")
    public Optional<Empresa> EnterpriseById(@PathVariable("id") Integer id){
        return this.enterpriseService.GetEnterpriseById(id);
    }

    /*-------------------------- PATCH con Cualquier parámetro --------------------------------------------*/
    @PatchMapping("/enterprises/{id}")
    public boolean UpdateEnterprise(@PathVariable("id") Integer id, @RequestBody Empresa enterprise) {
        Optional<Empresa> enterpr = enterpriseService.GetEnterpriseById(id);
        if(enterpr.isPresent()) {
            Empresa enter = enterpr.get();
            enter.setNombre(enterprise.getNombre());
            enter.setDireccion(enterprise.getDireccion());
            enter.setTelefono(enterprise.getTelefono());
            enter.setNit(enterprise.getNit());
            return enterpriseService.SelectOrChangeEnterpriseName(enter);
        }
        return false;
    }

    /*-------------------------- DELETE --------------------------------------------*/
    @DeleteMapping(path = "enterprises/{id}")
    public String DeleteEnterprises (@PathVariable("id") Integer id){
        boolean response = this.enterpriseService.DeleteEnterprise(id);
        if (response) {
            return "Ha sido eliminada la empresa con el id" + id;
        }
        return "No ha sido posible eliminar la empresa con el id" + id;

    }
}


