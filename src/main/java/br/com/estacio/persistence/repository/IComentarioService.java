package br.com.estacio.persistence.repository;

import br.com.estacio.persistence.entity.Comentario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: fabiano.gaetani
 * Date: 11/05/13
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface IComentarioService extends CrudRepository<Comentario, Integer> {
}
