package br.com.estacio.persistence.repository;

import br.com.estacio.persistence.entity.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: fabiano.gaetani
 * Date: 08/05/13
 * Time: 18:19
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface IAlunoService extends CrudRepository<Aluno, Integer> {
}
