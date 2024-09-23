package br.itb.projeto.KitFit.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.itb.projeto.KitFit.model.entity.Usuario;
import br.itb.projeto.KitFit.model.repository.UsuarioRepository;

@Service
public class AuthService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticar(String email) {
        return usuarioRepository.findByEmail(email);
    
    }
}
