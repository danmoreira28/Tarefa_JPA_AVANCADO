package br.com.danilo.dao;

/**
 * @author danmoreira28
 */

import java.util.List;

import br.com.danilo.domain.Carro;
import br.com.danilo.domain.Marca;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;


public class CarroDAO implements ICarro{


    @Override
    public Carro cadastrar(Carro car) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return car;
    }

    @Override
    public Carro buscarPorCodigoMarca(String codigoMarca) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT m FROM Carro c ");
        sb.append("INNER JOIN Marca m on m = c.marca ");
        sb.append("WHERE m.codigo = :codigoMarca");

        entityManager.getTransaction().begin();
        TypedQuery<Carro> query =
                entityManager.createQuery(sb.toString(), Carro.class);
        query.setParameter("codigoMarca", codigoMarca);
        Carro carro = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return carro;
    }
}


