package br.com.estacio.persistence.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fabiano.gaetani
 * Date: 09/05/13
 * Time: 12:06
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class InstituicaoAcademica  extends AbstractPersistable<Integer> {
    private String nome;
    private Integer cnpj;
    private String endereco;

    @OneToMany(mappedBy = "instituicaoAcademica")
    private List<Curso> cursoList;

    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
