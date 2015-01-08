package br.com.estacio.persistence.repository;

import br.com.estacio.persistence.entity.Post;
import br.com.estacio.persistence.entity.TurmaDisciplina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Gaetani
 * Date: 04/03/13
 * Time: 22:31
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface IPostService extends CrudRepository<Post, Integer>{


    @Query("select distinct p from Post p inner join fetch p.turmaDisciplinaList tdl where tdl in (?1) order by p.postado desc")
    List<Post> findBy(List<TurmaDisciplina> turmaDisciplinaList);

    @Query("select distinct p from Post p order by p.postado desc")
    List<Post> findAllOrderByPostado();
}
