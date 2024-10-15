package com.seruhioCode30.quickbites.QuickBites_Back_End.repository;

import com.seruhioCode30.quickbites.QuickBites_Back_End.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmail(String email);
}
