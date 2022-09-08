package com.Proyecto_Ciclo_3.Project.controllers;



import com.Proyecto_Ciclo_3.Project.entities.Empresa;
import com.Proyecto_Ciclo_3.Project.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnterpriseController {
    @Autowired
    EnterpriseService enterpriseService;

    @GetMapping("/enterprises")
    public List<Empresa> verEmpresas() {
        return enterpriseService.GetAllEnterprises();
    }

    @PostMapping("/enterprises")
    public boolean SaveEnterprise(@RequestBody Empresa empresa) {
        return this.enterpriseService.SelectOrChangeEnterpriseName(empresa);
    }

    @GetMapping(path = "/enterprises/{id}")
    public Empresa EnterpriseById(@PathVariable("id") Integer id){
        return this.enterpriseService.GetEnterpriseById(id);
    }
    @PatchMapping("/enterprises/{id}")
    public boolean UpdateEnterprise(@PathVariable("id") Integer id, @RequestBody Empresa empresa) {
        Empresa emp = enterpriseService.GetEnterpriseById(id);
        emp.setNombre(empresa.getNombre());
        emp.setDireccion(empresa.getDireccion());
        emp.setTelefono(empresa.getTelefono());
        emp.setNIT(empresa.getNIT());
        return enterpriseService.SelectOrChangeEnterpriseName(emp);
    }
    @DeleteMapping(path = "enterprises/{id}")
    public String DeleteEnterprises (@PathVariable("id") Integer id){
        boolean response = this.enterpriseService.DeleteEnterprise(id);
        if (response) {
            return "Ha sido eliminada la empresa con el id" + id;
        } else {
            return "No ha sido posible eliminar la empresa con el id" + id;
        }
    }
}


