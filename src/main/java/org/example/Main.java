package org.example;

import org.example.entities.Producto;
import org.example.repository.impl.ProductoRepositoryImpl;

import java.time.LocalDate;

//psvm
public class Main {
    public static void main(String[] args) {
        //agregar
        ProductoRepositoryImpl productoRepository=new ProductoRepositoryImpl();
        Producto producto=new Producto();
        producto.setNombre("papa");
        producto.setPrecio(2000.0);
        producto.setFechaRegistro(LocalDate.now());
        productoRepository.save(producto);

        //modificar---------------------------
        producto.setNombre("cambio de nombre UPDATE");
        Producto productoUpdate=productoRepository.getById(3L);
        productoUpdate.setNombre("cambio de nombre UPDATE");
        productoRepository.update(productoUpdate);
        //eliminar----------
        Producto productoEliminar=productoRepository.getById(7L);
        productoRepository.delateById(productoEliminar.getId());
    }
}
