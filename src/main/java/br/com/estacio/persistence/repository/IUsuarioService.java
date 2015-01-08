package br.com.estacio.persistence.repository;

import br.com.estacio.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuarioService extends CrudRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.login = ?1")
    Usuario getByUserName(String userName);
}
