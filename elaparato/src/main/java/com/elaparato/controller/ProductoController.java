package com.elaparato.controller;
import com.elaparato.model.Producto;
import com.elaparato.repository.IProductoRepository;
import com.elaparato.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private IProductoService prodServ;

    //crear un nuevo producto
    @PostMapping("/productos/create")
    public String createProducto(@RequestBody Producto prod) {
        prodServ.saveProducto(prod);
        return "Producto creado correctamente";
    }

    //obtener todos los productos
    @GetMapping("/productos/getall")
    public List<Producto> getProductos () {
        return prodServ.getProductos();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> getProductById(@PathVariable int id){
        Producto producto = prodServ.findProducto(id);
        return ResponseEntity.ok(producto);
    }

    //Modificar los datos de un producto
    @PutMapping("/productos/edit/{id}")
    public ResponseEntity<Producto> editProducto(@PathVariable int id, @RequestBody Producto productoDetails){
        Producto producto = prodServ.findProducto(id);
        producto.setNombre(productoDetails.getNombre());
        producto.setDescripcion(productoDetails.getDescripcion());
        producto.setPrecio(productoDetails.getPrecio());
        producto.setCantidad(productoDetails.getCantidad());

        Producto updatedProduct = productoRepository.save(producto);
        return ResponseEntity.ok(updatedProduct);

    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable int id){
        prodServ.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }

}
