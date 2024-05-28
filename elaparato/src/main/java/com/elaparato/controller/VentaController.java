package com.elaparato.controller;

import com.elaparato.model.Producto;
import com.elaparato.model.Venta;
import com.elaparato.repository.IVentaRepository;
import com.elaparato.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaRepository ventaRepository;

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

    @GetMapping("/ventas/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable int id){
        Venta venta = ventServ.findVenta(id);
        return ResponseEntity.ok(venta);
    }

    //Modificar los datos de una venta
    @PutMapping("/ventas/edit/{id}")
    public ResponseEntity<Venta> editVenta(@PathVariable int id, @RequestBody Venta ventaDetails){
        Venta venta = ventServ.findVenta(id);
        venta.setFecha(ventaDetails.getFecha());
        venta.setListaProductos(ventaDetails.getListaProductos());

        Venta updatedVenta = ventaRepository.save(venta);
        return ResponseEntity.ok(updatedVenta);
    }

    @DeleteMapping("/ventas/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable int id){
        ventServ.deleteVenta(id);
        return ResponseEntity.noContent().build();
    }

}
