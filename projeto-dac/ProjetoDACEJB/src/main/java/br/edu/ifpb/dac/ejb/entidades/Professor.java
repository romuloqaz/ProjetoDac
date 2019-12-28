package br.edu.ifpb.dac.ejb.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Professor extends Pessoa implements Serializable {

    @Column(columnDefinition="tinyint(1) default 1")
    private boolean disponivel; //tirar essa duvida

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
