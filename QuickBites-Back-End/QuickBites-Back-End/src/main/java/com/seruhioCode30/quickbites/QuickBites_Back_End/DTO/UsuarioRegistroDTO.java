package com.seruhioCode30.quickbites.QuickBites_Back_End.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRegistroDTO {
    private String nombre;
    private String correo;
    private String contraseña;
    private String rol;
}
