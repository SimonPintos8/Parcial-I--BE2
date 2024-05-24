package com.elaparato.service;

import com.elaparato.model.Producto;
import com.elaparato.model.Venta;
import com.elaparato.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepo;


    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public void saveVenta(Venta vent) {
        ventaRepo.save(vent);
    }

    @Override
    public void deleteVenta(int id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public Venta findVenta(int id) {
       return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public void editVenta(Venta vent) {
        this.saveVenta(vent);
    }

    }
