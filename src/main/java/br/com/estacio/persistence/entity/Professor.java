package br.com.estacio.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fabiano.gaetani
 * Date: 08/05/13
 * Time: 18:14
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Professor extends Usuario {

    @OneToMany(mappedBy = "professor")
    private List<TurmaDisciplina> turmaDisciplinaList;

    public List<TurmaDisciplina> getTurmaDisciplinaList() {
        return turmaDisciplinaList;
    }

    public void setTurmaDisciplinaList(List<TurmaDisciplina> turmaDisciplinaList) {
        this.turmaDisciplinaList = turmaDisciplinaList;
    }

    @Override
    public String getAssinatura() {
        return "Professor";
    }
}
