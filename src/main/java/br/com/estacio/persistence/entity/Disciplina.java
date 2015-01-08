package br.com.estacio.persistence.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fabiano.gaetani
 * Date: 09/05/13
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Disciplina extends AbstractPersistable<Integer> {

    private String nome;
    private Integer periodo;

    @ManyToOne
    private Curso curso;

    @OneToMany(mappedBy = "disciplina")
    private List<TurmaDisciplina> disciplinaList;

    public List<TurmaDisciplina> getDisciplinaList() {
        return disciplinaList;
    }

    public void setDisciplinaList(List<TurmaDisciplina> disciplinaList) {
        this.disciplinaList = disciplinaList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
