package br.com.estacio.gui.model;

import br.com.estacio.persistence.entity.Usuario;
import br.com.estacio.persistence.repository.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Controller
@Scope("session")
public class SessionBean implements Serializable {

    private static final long serialVersionUID = -2477891600149910534L;
    private String mandant = "default";
    private Usuario usuarioLogado;
    private Set<User> usuariosChat;

    @Autowired
    private IUsuarioService usuarioRepository;

    @Autowired
    private SessionRegistry sessionRegistry;

    public SessionBean() {
        usuariosChat = new HashSet<User>();
    }


    @PostConstruct
    public void carregarUsuario(){

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        usuarioLogado = usuarioRepository.getByUserName(principal.getUsername());
        for(Object princs: sessionRegistry.getAllPrincipals()){
            usuariosChat.add((User)princs);
        }
    }

    public Set<User> getUsuariosChat() {
        return usuariosChat;
    }

    public void setUsuariosChat(Set<User> usuariosChat) {
        this.usuariosChat = usuariosChat;
    }

    public String getMandant() {
        return mandant;
    }

    public void setMandant(String mandant) {
        this.mandant = mandant;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}