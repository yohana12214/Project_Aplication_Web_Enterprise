package com.Proyecto_Ciclo_3.Project.controllers;


import com.Proyecto_Ciclo_3.Project.entities.Empleado;
import com.Proyecto_Ciclo_3.Project.services.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {
    @Autowired
    UsersService usersService;
    /////
    //RestController para la entidad Empleado;
    /////
    @GetMapping("/users")
    public List<Empleado> viewUsers(){
        return usersService.getAllEmpleados();
    }
    @PostMapping("/users")
    public Optional<Boolean> SaveUser(@RequestBody Empleado empl){
        return Optional.of(this.usersService.saveOrUpdate(empl));
    }
    @GetMapping(path = "/users/{id}")
    public Empleado findUserById(@PathVariable("id") Integer id){
        return this.usersService.getEmpleadoById(id);
    }
    @GetMapping("/enterprises/{id}/users")
    public ArrayList<Empleado> FinduserByEnterprise(@PathVariable("id") Integer id){
        return this.usersService.getEmpleadoByEmpresa(id);
    }
    @PatchMapping("/users/{id}")
    public boolean UpdateUsers(@PathVariable("id") Integer id, @RequestBody Empleado empleado) {
        Empleado empl = usersService.getEmpleadoById(id);
        empl.setNombre(empleado.getNombre());
        empl.setCorreo(empleado.getCorreo());
        empl.setEmpresa(empleado.getEmpresa());
        empl.setRol(empleado.getRol());
        return usersService.saveOrUpdate(empl);
    }
    @DeleteMapping("/users/{id}") //Metodo para eliminar empleados por id
    public String DeleteUser(@PathVariable("id") Integer id) {
        boolean Response = usersService.deleteEmpleado(id); //eliminamos usando el servicio de nuestro service
        if (Response) {
            return "Se elimino correctamente el empleado con id " + id;
        }
        return "No se  elimino correctamente el empleado con id " + id;
    }
}
