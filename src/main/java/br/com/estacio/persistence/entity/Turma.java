package br.com.estacio.persistence.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fabiano.gaetani
 * Date: 08/05/13
 * Time: 18:07
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Turma extends AbstractPersistable<Integer> {

    private String codigoTurma;

    @OneToMany(mappedBy = "turma")
    private List<TurmaDisciplina> turmaDisciplina;

    @ManyToMany(mappedBy = "turmaList")
    private List<Curso> cursoList;

    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public List<TurmaDisciplina> getTurmaDisciplina() {
        return turmaDisciplina;
    }

    public void setTurmaDisciplina(List<TurmaDisciplina> turmaDisciplina) {
        this.turmaDisciplina = turmaDisciplina;
    }
}
