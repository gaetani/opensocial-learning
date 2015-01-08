package br.com.estacio.persistence.entity;

import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: fabiano.gaetani
 * Date: 08/05/13
 * Time: 18:14
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Coordenacao extends Usuario {

    @Override
    public String getAssinatura() {
        return "Coordenador";
    }
}
