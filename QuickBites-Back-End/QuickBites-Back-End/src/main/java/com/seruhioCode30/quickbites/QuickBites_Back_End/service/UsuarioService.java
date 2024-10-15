package com.seruhioCode30.quickbites.QuickBites_Back_End.service;

import com.seruhioCode30.quickbites.QuickBites_Back_End.model.Role;
import com.seruhioCode30.quickbites.QuickBites_Back_End.model.Usuario;
import com.seruhioCode30.quickbites.QuickBites_Back_End.DTO.UsuarioRegistroDTO;
import com.seruhioCode30.quickbites.QuickBites_Back_End.repository.RoleRepository;
import com.seruhioCode30.quickbites.QuickBites_Back_End.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inyectamos el codificador de contraseñas

    @Autowired
    private RoleRepository roleRepository;

    // Manejar el registro de usuarios
    public Usuario registrarUsuario(UsuarioRegistroDTO dto) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setName(dto.getName());
        nuevoUsuario.setEmail(dto.getEmail());

        // Hasheamos la contraseña antes de guardarla
        String contraseñaHasheada = passwordEncoder.encode(dto.getPassword());
        nuevoUsuario.setPassword(contraseñaHasheada);

        // Asignar roles al usuario
        Role userRole = roleRepository.findByName("ROLE_ADMIN")  // Usa el rol que envías, "ROLE_ADMIN"
                .orElseThrow(() -> new RuntimeException("Role no encontrado"));

        Set<Role> roles = new HashSet<>();
        roles.add(userRole);  // Añadir el rol correspondiente
        nuevoUsuario.setRoles(roles);  // Asignar roles

        return usuarioRepository.save(nuevoUsuario);
    }

    public Optional<Usuario> buscarPorCorreo(String email){
        return usuarioRepository.findByEmail(email);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setName(usuarioActualizado.getName());

        // Si se actualiza la contraseña, la hasheamos
        if (usuarioActualizado.getPassword() != null && !usuarioActualizado.getPassword().isEmpty()) {
            String contraseñaHasheada = passwordEncoder.encode(usuarioActualizado.getPassword());
            usuario.setPassword(contraseñaHasheada);
        }

        usuario.setRoles(usuarioActualizado.getRoles());
        return usuarioRepository.save(usuario);
    }

    // Método para autenticar usuario
    public Usuario autenticarUsuario(String correo, String contraseña) {
        Usuario usuario = usuarioRepository.findByEmail(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Verificar si la contraseña ingresada coincide con la almacenada (hasheada)
        if (!passwordEncoder.matches(contraseña, usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return usuario; // Retornamos el usuario si se autentica correctamente
    }
}
