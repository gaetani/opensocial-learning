package br.com.estacio.gui.model;

import br.com.estacio.persistence.repository.IUsuarioService;
import org.primefaces.context.RequestContext;
import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by IntelliJ IDEA.
 * User: Gaetani
 * Date: 14/04/13
 * Time: 19:33
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Scope("request")
public class ChatBean {

    public String nomeUsuarioLogado ;
    @Autowired
    private SessionBean sessionBean;

    private final PushContext pushContext = PushContextFactory.getDefault().getPushContext();

    private String privateMessage;

    private boolean loggedIn;

    private User privateUser;

    @Autowired
    private IUsuarioService usuarioRepository;

    private final static String CHANNEL = "/chat/";

    @PostConstruct
    public void carregarUsuario(){


        nomeUsuarioLogado = sessionBean.getUsuarioLogado().getNome();
    }


    public User getPrivateUser() {
        return privateUser;
    }

    public void setPrivateUser(User privateUser) {
        this.privateUser = privateUser;
    }

    public String getPrivateMessage() {
        return privateMessage;
    }

    public void setPrivateMessage(String privateMessage) {
        this.privateMessage = privateMessage;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void sendPrivate() {
        pushContext.push(CHANNEL + privateUser, "[PM] " + nomeUsuarioLogado + ": " + privateMessage);

        privateMessage = null;
    }

    public void login() {
        RequestContext requestContext = RequestContext.getCurrentInstance();

        if(sessionBean.getUsuariosChat().contains((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
            loggedIn = false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username taken", "Try with another username."));

            requestContext.update("growl");
        }
        else {
            sessionBean.getUsuariosChat().add((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            pushContext.push(CHANNEL, nomeUsuarioLogado + " joined the channel.");
            requestContext.execute("subscriber.connect('/" + nomeUsuarioLogado + "')");
            loggedIn = true;
        }
    }

    public void disconnect() {
        //remove user and update ui
        sessionBean.getUsuariosChat().remove((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        RequestContext.getCurrentInstance().update("form:users");

        //push leave information
        pushContext.push(CHANNEL, sessionBean.getUsuarioLogado() + " left the channel.");

        //reset state
        loggedIn = false;
    }
}
