package com.Proyecto_Ciclo_3.Project.controllers;

import com.Proyecto_Ciclo_3.Project.entities.MovimientoDinero;
import com.Proyecto_Ciclo_3.Project.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
    public class MovementController {

        @Autowired
        MovementService movementService;

        @GetMapping("/enterprises/{id}/movement")
        public MovimientoDinero movimientoDineroPorID(@PathVariable("id") Integer id){
            return this.movementService.getMovimientoById(id);
        }

        @PostMapping("/enterprises/{id}/movement")
        public Optional <MovimientoDinero> guardarMovimientoDinero (@RequestBody MovimientoDinero movimientoDinero) {
            return Optional.ofNullable(this.movementService.saveOrUpdateMovimiento(movimientoDinero));
        }

        @PatchMapping("/enterprises/{id}/movement")
        public MovimientoDinero actualizarMovimientoDinero(@PathVariable("id") Integer id, @RequestBody MovimientoDinero movimientoDinero){
            MovimientoDinero movimientoDinero1 = movementService.getMovimientoById(id);
            movimientoDinero1.setMonto(movimientoDinero.getMonto());
            movimientoDinero.setConcepto(movimientoDinero.getConcepto());
            return movementService.saveOrUpdateMovimiento(movimientoDinero1);
        }
        @DeleteMapping("/enterprises/{id}/movement")
        public String DeleteMovimiento (@PathVariable("id") Integer id){
            boolean rta = this.movementService.deleteMovimiento(id);
            if (rta) {
                return "El Mto Dinero ha sido eliminado atravez del id " + id;
            }
                return "El Mto Dinero NO ha sido eliminado atravez del id " + id;
        }

    }
