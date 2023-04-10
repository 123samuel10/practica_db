package org.example.v1;

import org.example.model.Category;
import org.example.model.ProductCategory;
import org.example.model.Producto;
import org.example.repository.impl.ProductoCategoryRepositoryImpl;
import org.example.repository.impl.ProductoRepositoryImpl;

import java.time.LocalDate;

public class MainProductCategory {

    public static void main(String[] args) {
        //agregamos
        ProductoCategoryRepositoryImpl productoCategoryRepository=new ProductoCategoryRepositoryImpl();
        ProductCategory producto1=new ProductCategory();
        Category category=new Category("pera",1);
        producto1.setCategory(category);
        producto1.setNombre("fresa");
        producto1.setPrecio(2000.0);
        producto1.setFechaRegistro(LocalDate.now());
        productoCategoryRepository.save(producto1);
        //------------------------------------------
        //modificar
        producto1.setNombre("cambio de nombre(banana)");
        ProductCategory productoUpdate=productoCategoryRepository.getById(3L);
        productoUpdate.setNombre("cambio de nombre UPDATE");
        productoCategoryRepository.update(productoUpdate);
        //---------------------------------------------
        //eliminar
        ProductCategory productoEliminar=productoCategoryRepository.getById(1L);
        productoCategoryRepository.delateById(productoEliminar.getId());

    }
}
