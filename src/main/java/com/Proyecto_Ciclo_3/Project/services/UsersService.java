package com.Proyecto_Ciclo_3.Project.services;



import com.Proyecto_Ciclo_3.Project.entities.Empleado;
import com.Proyecto_Ciclo_3.Project.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UsersService {
    @Autowired
    UsersRepository empleadoRepositorio;

    public List<Empleado> getAllEmpleados(){
        List<Empleado> empleadoList = new ArrayList<>();
        empleadoRepositorio.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;

    }

    public Empleado getEmpleadoById(Integer id){
        return empleadoRepositorio.findById(id).get();

    }
    public ArrayList<Empleado> getEmpleadoByEmpresa(Integer id){
        return empleadoRepositorio.findByEmpresa(id);
    }
    public boolean saveOrUpdate(Empleado empleado) {
        Empleado empleado1 = empleadoRepositorio.save(empleado);
        if (empleadoRepositorio.findById(empleado1.getId()) !=null){
            return true;
        }
        return false;
    }

    public boolean deleteEmpleado(Integer id){
        empleadoRepositorio.deleteById(id);
        if(getEmpleadoById(id)!= null){
            return false;
                    }
        return true;
    }


}
