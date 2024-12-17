package br.com.danilo.domain;

/**
 * @author danmoreira28
 */

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="acessorio_seq")
    @SequenceGenerator(name="acessorio_seq", sequenceName="sq_acessorio", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "NOME", length = 10, nullable = false)
    private String nome;

    @ManyToMany
    @JoinTable(
            name = "TB_ACESSORIO_MARCA",
            joinColumns = @JoinColumn(name = "id_acessorio_fk"),
            inverseJoinColumns = @JoinColumn(name = "id_marca_fk")
    )
    private List<Marca> marcas;

    @ManyToOne
    @JoinColumn(name = "id_carro_fk", foreignKey = @ForeignKey(name = "fk_carro_acessorio"), referencedColumnName = "id")
    private Carro carro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
