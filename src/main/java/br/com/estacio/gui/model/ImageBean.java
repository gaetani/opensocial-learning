package br.com.estacio.gui.model;

import br.com.estacio.persistence.repository.IUsuarioService;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.context.FacesContext;

/**
 * Created with IntelliJ IDEA.
 *
 * Date: 19/05/13
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Scope("request")
public class ImageBean {

    @Autowired
    private IUsuarioService usuarioRepository;

    public StreamedContent getImage(){
        FacesContext context = FacesContext.getCurrentInstance();
        /*HttpServletRequest myRequest = (HttpServletRequest) context.getExternalContext().getRequest();
        Post post = (Post)myRequest.getAttribute("novoPost");

        if(post == null){
            return null;
        }
        Integer id = post.getAutorPost().getId();*/
        return usuarioRepository.findOne(1).getFotoStreamed();
    }
}
