package br.com.estacio.persistence.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: fabiano.gaetani
 * Date: 08/05/13
 * Time: 18:29
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Comentario extends AbstractPersistable<Integer> {

    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date inserido;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Post post;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Usuario usuario;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getInserido() {
        return inserido;
    }

    public void setInserido(Date inserido) {
        this.inserido = inserido;
    }
}
