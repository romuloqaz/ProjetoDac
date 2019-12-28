package br.edu.ifpb.dac.ejb.entidades;

import javax.persistence.*;

@Entity
public class Tema {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 60)
    private String titulo;

    @Column(length = 120)
    private String descricao;

    @Column(columnDefinition="tinyint(1) default 1")
    private boolean disponivel; //tirar essa duvida

    @OneToOne // perguntar sobre cascade
    private Professor professor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
