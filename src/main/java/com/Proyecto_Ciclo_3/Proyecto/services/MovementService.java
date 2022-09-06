package com.Proyecto_Ciclo_3.Proyecto.services;



import com.Proyecto_Ciclo_3.Proyecto.entities.MovimientoDinero;
import com.Proyecto_Ciclo_3.Proyecto.repositories.MovementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovementService {
    @Autowired
    MovementRepository movimientosRepository;

    public List<MovimientoDinero> getAllMovimientos(){
        List<MovimientoDinero> movimientosList = new ArrayList<>();
        movimientosRepository.findAll().forEach(movimiento -> movimientosList.add(movimiento));
        return movimientosList;
    }

    public MovimientoDinero getMovimientoById(Integer id){
        return movimientosRepository.findById(id).get();
    }

    public MovimientoDinero saveOrUpdateMovimiento(MovimientoDinero movimientoDinero){
        MovimientoDinero mov=movimientosRepository.save(movimientoDinero);
        return mov;
    }

    public boolean deleteMovimiento(Integer id){
        movimientosRepository.deleteById(id);
        if(this.movimientosRepository.findById(id).isPresent()){
            return false;
        }
        return true;
    }
//
//    public ArrayList<MovimientoDinero> obtenerPorEmpleado(Integer id) {
//        return movimientosRepository.findByEmpleado(id);
//    }
//
//    public ArrayList<MovimientoDinero> obtenerPorEmpresa(Integer id) {
//        return movimientosRepository.findByEmpresa(id);
//        }
}

