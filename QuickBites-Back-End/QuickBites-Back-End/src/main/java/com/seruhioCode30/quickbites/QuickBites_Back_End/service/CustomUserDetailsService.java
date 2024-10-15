package com.seruhioCode30.quickbites.QuickBites_Back_End.service;

import com.seruhioCode30.quickbites.QuickBites_Back_End.model.Usuario;
import com.seruhioCode30.quickbites.QuickBites_Back_End.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(username);

        if (!usuarioOpt.isPresent()) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        return usuarioOpt.get(); // Devuelve el usuario encontrado
    }
}
