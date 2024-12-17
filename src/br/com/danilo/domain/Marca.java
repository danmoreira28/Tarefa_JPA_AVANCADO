package br.com.danilo.domain;

/**
 * @author danmoreira28
 */

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;


@Entity
@Table(name = "TB_MARCA")
public class Marca {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "marca")
    private List<Carro> carros = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "TB_ACESSORIO_MARCA",
            joinColumns = @JoinColumn(name = "id_marca_fk"),
            inverseJoinColumns = @JoinColumn(name = "id_acessorio_fk")
    )
    private List<Acessorio> acessorios = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
}
