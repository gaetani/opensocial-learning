package br.com.estacio.persistence.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fabiano.gaetani
 * Date: 08/05/13
 * Time: 18:08
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Curso extends AbstractPersistable<Integer> {

    private String nomeCurso;

    @OneToMany(mappedBy = "curso")
    private List<Disciplina> disciplinaList;

    @ManyToMany
    private List<Turma> turmaList;

    @OneToMany(mappedBy = "curso")
    private List<Aluno> alunoList;

    @ManyToOne
    private InstituicaoAcademica instituicaoAcademica;


    public List<Aluno> getAlunoList() {
        return alunoList;
    }

    public void setAlunoList(List<Aluno> alunoList) {
        this.alunoList = alunoList;
    }

    public InstituicaoAcademica getInstituicaoAcademica() {
        return instituicaoAcademica;
    }

    public void setInstituicaoAcademica(InstituicaoAcademica instituicaoAcademica) {
        this.instituicaoAcademica = instituicaoAcademica;
    }

    public List<Turma> getTurmaList() {
        return turmaList;
    }

    public void setTurmaList(List<Turma> turmaList) {
        this.turmaList = turmaList;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
}
