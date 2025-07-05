package com.asapmob.cadastro_usuario.business;

import com.asapmob.cadastro_usuario.infrastruture.entitys.Usuario;
import com.asapmob.cadastro_usuario.infrastruture.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioEmail(String email){

        return repository.findByEmail(email).orElseThrow(
                ()-> new RuntimeException("Email não encontrado!")
        );
    }

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorEmail(Integer id, Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(email)

                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())

                .id(usuarioEntity.getId())

                .build()
    }

}
