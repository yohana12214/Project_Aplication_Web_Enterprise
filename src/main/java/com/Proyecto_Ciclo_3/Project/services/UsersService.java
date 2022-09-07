package com.Proyecto_Ciclo_3.Project.services;



import com.Proyecto_Ciclo_3.Project.entities.Empleado;
import com.Proyecto_Ciclo_3.Project.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public List<Empleado> getAllUsers(){
        List<Empleado> usersList = new ArrayList<>();
        usersRepository.findAll().forEach(empleado -> usersList.add(empleado));
        return usersList;

    }
    public Optional<Empleado> getUserById (Integer id){
        return usersRepository.findById(id);
    }
    public ArrayList<Empleado> getUsersByEnterprise(Integer id){

        return usersRepository.findByEnterprise(id);
    }
    public Empleado saveOrUpdate(Empleado empleado) {

        return usersRepository.save(empleado);
    }

    public boolean DeleteUser(Integer id){
        usersRepository.deleteById(id);
        return getUserById(id).isEmpty();
    }


}
