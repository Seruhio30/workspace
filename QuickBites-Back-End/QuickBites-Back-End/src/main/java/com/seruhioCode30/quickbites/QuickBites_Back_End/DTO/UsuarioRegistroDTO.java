package com.seruhioCode30.quickbites.QuickBites_Back_End.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRegistroDTO {
    private String name;
    private String email;
    private String password;
    private String role;
}
