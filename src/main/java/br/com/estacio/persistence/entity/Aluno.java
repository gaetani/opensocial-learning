package br.com.estacio.persistence.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fabiano.gaetani
 * Date: 08/05/13
 * Time: 18:05
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Aluno extends Usuario {

    @ManyToMany
    private List<TurmaDisciplina> turmaDisciplinaList;

    @ManyToOne
    private Curso curso;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<TurmaDisciplina> getTurmaDisciplinaList() {
        return turmaDisciplinaList;
    }

    public void setTurmaDisciplinaList(List<TurmaDisciplina> turmaDisciplinaList) {
        this.turmaDisciplinaList = turmaDisciplinaList;
    }

    @Override
    public String getAssinatura() {
        return "Aluno de " + curso.getNomeCurso();
    }
}
