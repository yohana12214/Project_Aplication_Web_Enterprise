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

        return usersService.getAllUsers();
    }
    @PostMapping("/users")
    public Optional<Empleado> SaveUser(@RequestBody Empleado empleado){

        return Optional.ofNullable(this.usersService.saveOrUpdate(empleado));
    }
    @GetMapping(path = "/users/{id}")
    public Optional<Empleado> findUserById(@PathVariable("id") Integer id){
        return this.usersService.getUserById(id);
    }
    @GetMapping("/enterprises/{id}/users")
    public ArrayList<Empleado> FinduserByEnterprise(@PathVariable("id") Integer id){
        return this.usersService.getUsersByEnterprise(id);
    }
    @PatchMapping("/users/{id}")
    public Empleado UpdateUsers(@PathVariable("id") Integer id, @RequestBody Empleado empleado) {
        Empleado user = usersService.getUserById(id).get();
        user.setNombre(empleado.getNombre());
        user.setCorreo(empleado.getCorreo());
        user.setEmpresa(empleado.getEmpresa());
        user.setRol(empleado.getRol());
        return usersService.saveOrUpdate(user);
    }
    @DeleteMapping("/users/{id}") //Metodo para eliminar empleados por id
    public String DeleteUser(@PathVariable("id") Integer id) {
        boolean Response = usersService.DeleteUser(id); //eliminamos usando el servicio de nuestro service
        if (Response) {
            return "Se elimino correctamente el empleado con id " + id;
        }
        return "No se  elimino correctamente el empleado con id " + id;
    }
}
