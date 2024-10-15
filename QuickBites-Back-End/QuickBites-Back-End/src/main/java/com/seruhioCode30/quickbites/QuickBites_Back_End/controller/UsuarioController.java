package com.seruhioCode30.quickbites.QuickBites_Back_End.controller;

import com.seruhioCode30.quickbites.QuickBites_Back_End.DTO.UsuarioLoginDTO;
import com.seruhioCode30.quickbites.QuickBites_Back_End.model.Usuario;
import com.seruhioCode30.quickbites.QuickBites_Back_End.DTO.UsuarioRegistroDTO;
import com.seruhioCode30.quickbites.QuickBites_Back_End.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody UsuarioRegistroDTO dto) {
        Usuario usuarioRegistrado = usuarioService.registrarUsuario(dto);
        return new ResponseEntity<>(usuarioRegistrado, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody UsuarioLoginDTO dto) {
        Usuario usuario = usuarioService.autenticarUsuario(dto.getEmail(), dto.getPassword());
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }


}
