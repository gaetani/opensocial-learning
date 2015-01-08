package br.com.estacio.persistence.entity;

import br.com.estacio.persistence.entity.domain.EstadoEnum;
import br.com.estacio.persistence.entity.domain.Sexo;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = 5634914903775684072L;
	private String nome;
    private String login;
	private String senha;
	private String email;
	private Sexo sexo;
    private String cidade;
    private EstadoEnum estadoEnum;

    @Lob
    @Column(columnDefinition="mediumblob")
    private byte[] foto;

    @OneToMany(mappedBy = "autorPost")
    private List<Post> postList;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoEnum getEstadoEnum() {
        return estadoEnum;
    }

    public void setEstadoEnum(EstadoEnum estadoEnum) {
        this.estadoEnum = estadoEnum;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Transient
    public StreamedContent getFotoStreamed(){
        if(foto == null){
            return null;
        }
        return new DefaultStreamedContent(new ByteArrayInputStream(foto), "image/jpeg");
    }

    @Transient
    public abstract String getAssinatura();
}
