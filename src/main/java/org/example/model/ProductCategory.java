package org.example.model;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductCategory {
    private  Long id;
    private String nombre;
    private Double precio;
    private LocalDate fechaRegistro;

    private Category category;



}
