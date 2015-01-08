package br.com.estacio.persistence.entity.domain;

/**
 * Created with IntelliJ IDEA.
 * User: fabiano.gaetani
 * Date: 08/05/13
 * Time: 17:58
 * To change this template use File | Settings | File Templates.
 */
public enum Sexo {
    M("Masculino"),
    F("Feminino");

    private String descricao;

    private Sexo(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
