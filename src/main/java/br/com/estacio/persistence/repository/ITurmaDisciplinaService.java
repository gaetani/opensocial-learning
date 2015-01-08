package br.com.estacio.persistence.repository;

import br.com.estacio.persistence.entity.TurmaDisciplina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fabiano.gaetani
 * Date: 10/05/13
 * Time: 13:00
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface ITurmaDisciplinaService extends CrudRepository<TurmaDisciplina, Integer> {

    @Query("select tdl from TurmaDisciplina tdl where tdl in (?1) ")
    List<TurmaDisciplina> findAll(List<TurmaDisciplina> turmaDisciplinaList);
}
