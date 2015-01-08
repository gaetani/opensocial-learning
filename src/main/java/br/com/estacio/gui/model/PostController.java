package br.com.estacio.gui.model;

import br.com.estacio.persistence.entity.*;
import br.com.estacio.persistence.repository.IComentarioService;
import br.com.estacio.persistence.repository.IPostService;
import br.com.estacio.persistence.repository.ITurmaDisciplinaService;
import br.com.estacio.persistence.repository.IUsuarioService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Controller
@Scope("session")
public class PostController {

    @Autowired
    private ITurmaDisciplinaService turmaDisciplinaRepository;

    @Autowired
    private IComentarioService comentarioRepository;

    @Autowired
    private IPostService postRepository;

    @Autowired
    private IUsuarioService usuarioRepository;

    private Usuario usuarioLogado;

    private Post post = new Post();

    private Comentario comentario = new Comentario();

    private List<Post> postList;


    public void setTurmaDisciplinaRepository(ITurmaDisciplinaService turmaDisciplinaRepository) {
        this.turmaDisciplinaRepository = turmaDisciplinaRepository;
    }

    public void setComentarioRepository(IComentarioService comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public void setPostRepository(IPostService postRepository) {
        this.postRepository = postRepository;
    }

    public void setUsuarioRepository(IUsuarioService usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostConstruct
    public void carregarUsuario(){

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        usuarioLogado = usuarioRepository.getByUserName(principal.getUsername());
        carregarPost();
    }


    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }


    public void carregarPost(){
        Usuario usuarioLogado = usuarioRepository.findOne(this.usuarioLogado.getId());
        if(usuarioLogado instanceof Professor){
            postList = postRepository.findBy(((Professor) usuarioLogado).getTurmaDisciplinaList());
        } else if(usuarioLogado instanceof Aluno){
            postList = postRepository.findBy(((Aluno) usuarioLogado).getTurmaDisciplinaList());
        } else {
            postList = postRepository.findAllOrderByPostado();
        }
    }

    public void postar(){
        post.setAutorPost(usuarioLogado);
        post.setPostado(new Date());
        Usuario usuarioLogado = usuarioRepository.findOne(this.usuarioLogado.getId());

        List<TurmaDisciplina> turmaDisciplinaList;
        if(usuarioLogado instanceof Professor){
            turmaDisciplinaList = ((Professor) usuarioLogado).getTurmaDisciplinaList();
        } else if(usuarioLogado instanceof Aluno){
            turmaDisciplinaList = ((Aluno) usuarioLogado).getTurmaDisciplinaList();
        } else {
            turmaDisciplinaList =Lists.newArrayList(turmaDisciplinaRepository.findAll().iterator());
        }

        turmaDisciplinaList = turmaDisciplinaRepository.findAll(turmaDisciplinaList);

        post.setTurmaDisciplinaList(turmaDisciplinaList);
        postRepository.save(post);
        post = new Post();
        carregarPost();
    }

    public void comentar(Post post){
        comentario.setPost(post);
        comentario.setInserido(new Date());
        comentario.setUsuario(usuarioLogado);
        comentarioRepository.save(comentario);
        comentario = new Comentario();
        carregarPost();
    }

    public void remover(Post post){
        postRepository.delete(post);
        carregarPost();
    }

    public void alterar(Post post){
        postRepository.save(post);
        carregarPost();
    }

    public void removerComentario(Comentario comentario){
        comentarioRepository.delete(comentario);
        carregarPost();
    }

}