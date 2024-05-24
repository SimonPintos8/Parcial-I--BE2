package com.elaparato.controller;

import com.elaparato.model.Producto;
import com.elaparato.model.Venta;
import com.elaparato.service.IProductoService;
import com.elaparato.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {


    @Autowired
    private IVentaService ventServ;

    //crear una nueva venta
    @PostMapping("/ventas/create")
    public String createVentao(@RequestBody Venta vent) {
        ventServ.saveVenta(vent);
        return "Venta creada correctamente";
    }

    //obtener todas las ventas
    @GetMapping("/ventas/getall")
    public List<Venta> getVentas () {
        return ventServ.getVentas();
    }

    //Modificar los datos de una venta
    @PutMapping("/ventas/edit")
    public String editVenta(@RequestBody Venta vent) {
        ventServ.editVenta(vent);
        return "Venta editada correctamente";
    }

    @DeleteMapping("/ventas/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable int id){
        ventServ.deleteVenta(id);
        return ResponseEntity.noContent().build();
    }

}
