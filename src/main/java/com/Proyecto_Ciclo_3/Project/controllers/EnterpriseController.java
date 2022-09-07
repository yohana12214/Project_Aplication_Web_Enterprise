package com.Proyecto_Ciclo_3.Project.controllers;



import com.Proyecto_Ciclo_3.Project.entities.Empresa;
import com.Proyecto_Ciclo_3.Project.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnterpriseController {
    @Autowired
    EnterpriseService empresaService;

    @GetMapping("/enterprises")
    public List<Empresa> verEmpresas() {
        return empresaService.getallEmpresas();
    }

    @PostMapping("/enterprises")
    public boolean guardarEmpresa(@RequestBody Empresa empresa) {
        return this.empresaService.setorChangeEmpresaName(empresa);
    }

    @GetMapping(path = "enterprises/{id}")
    public Empresa empresaPorID(@PathVariable("id") Integer id){
        return this.empresaService.getEmpresaById(id);
    }
    @PatchMapping("/enterprises/{id}")
    public boolean actualizarEmpresa(@PathVariable("id") Integer id, @RequestBody Empresa empresa) {
        Empresa emp = empresaService.getEmpresaById(id);
        emp.setNombre(empresa.getNombre());
        emp.setDireccion(empresa.getDireccion());
        emp.setTelefono(empresa.getTelefono());
        emp.setNIT(empresa.getNIT());
        return empresaService.setorChangeEmpresaName(emp);
    }
    @DeleteMapping(path = "enterprises/{id}")
    public String DeleteEmpresa (@PathVariable("id") Integer id){
        boolean respuesta = this.empresaService.EliminateEmpresa(id);
        if (respuesta) {
            return "Ha sido eliminada la empresa con el id" + id;
        } else {
            return "No ha sido posible eliminar la empresa con el id" + id;
        }
    }
}


