package br.com.estacio.persistence.entity;


import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: Gaetani
 * Date: 03/03/13
 * Time: 20:33
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Post extends AbstractPersistable<Integer> {
    
    private String descricao;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Usuario autorPost;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comentario> comentarioList;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date postado;

    @ManyToMany
    private List<TurmaDisciplina> turmaDisciplinaList;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getPostado() {
        return postado;
    }

    public void setPostado(Date postado) {
        this.postado = postado;
    }

    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    public Usuario getAutorPost() {
        return autorPost;
    }

    public void setAutorPost(Usuario autorPost) {
        this.autorPost = autorPost;
    }

    public List<TurmaDisciplina> getTurmaDisciplinaList() {
        return turmaDisciplinaList;
    }

    public void setTurmaDisciplinaList(List<TurmaDisciplina> turmaDisciplinaList) {
        this.turmaDisciplinaList = turmaDisciplinaList;
    }
}
