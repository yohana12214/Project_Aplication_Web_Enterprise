package com.Proyecto_Ciclo_3.Project.controllers;

import com.Proyecto_Ciclo_3.Project.entities.MovimientoDinero;
import com.Proyecto_Ciclo_3.Project.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class MovementController {

    @Autowired
    MovementService movementService;

    /*-------------------------- GET --------------------------------------------*/
    @GetMapping("/enterprises/{id}/movement")
    public List<MovimientoDinero> movimientoDineroPorID(){
        return this.movementService.getAllMovimientos();
    }

    /*-------------------------- POST --------------------------------------------*/
    @PostMapping("/enterprises/{id}/movement")
    public Optional <MovimientoDinero> guardarMovimientoDinero (@RequestBody MovimientoDinero movimientoDinero) {
        return Optional.ofNullable(this.movementService.saveOrUpdateMovimiento(movimientoDinero));
    }

    /*-------------------------- PATCH con parámetros --------------------------------------------*/
    @PatchMapping("/enterprises/{id}/movement")
    public MovimientoDinero actualizarMovimientoDinero(@PathVariable("id") Integer id, @RequestBody MovimientoDinero movimientoDinero){
        Optional<MovimientoDinero> movimientoDinero1 = Optional.ofNullable(movementService.getMovimientoById(id));
        MovimientoDinero movement = movimientoDinero1.get();
        movement.setMonto(movimientoDinero.getMonto());
        movement.setConcepto(movimientoDinero.getConcepto());
        movement.setUsuario(movimientoDinero.getUsuario());
        return movementService.saveOrUpdateMovimiento(movement);
    }

    /*---------------------------------  DELETE  --------------------------------------------*/
    @DeleteMapping("/enterprises/{id}/movement")
    public String DeleteMovimiento (@PathVariable("id") Integer id){
        boolean rta = this.movementService.deleteMovimiento(id);
        if (rta) {
            return "El Mto Dinero ha sido eliminado atravez del id " + id;
        }
        return "El Mto Dinero NO ha sido eliminado atravez del id " + id;
        }

    }
