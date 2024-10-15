package com.seruhioCode30.quickbites.QuickBites_Back_End.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Productos")
@Table(name = "productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = true)
    private String descripcion;

    @Column(name = "imagen_url", nullable = true)
    private String imagenUrl;

    @ElementCollection // Esta anotación se utiliza para colecciones de tipo básico
    @CollectionTable(name = "productos_ingredientes", joinColumns = @JoinColumn(name = "productos_id")) // Asegúrate de que el nombre de la tabla y la columna sean correctos
    @Column(name = "ingredientes") // Este es el nombre de la columna que almacenará cada ingrediente
    private List<String> ingredientes;


}
