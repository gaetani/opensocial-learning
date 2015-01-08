package br.com.estacio.persistence.entity;

import br.com.estacio.persistence.entity.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fabiano.gaetani
 * Date: 09/05/13
 * Time: 13:32
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class TurmaDisciplina extends AbstractPersistable<Integer> {

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Turma turma;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Disciplina disciplina;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Professor professor;

    @ManyToMany(mappedBy = "turmaDisciplinaList")
    private List<Aluno> alunoList;

    @ManyToMany(mappedBy = "turmaDisciplinaList")
    private List<Post> postList;


    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunoList() {
        return alunoList;
    }

    public void setAlunoList(List<Aluno> alunoList) {
        this.alunoList = alunoList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
