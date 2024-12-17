package br.com.danilo.dao;

/**
 * @author danmoreira28
 */

import java.util.List;
import br.com.danilo.domain.Acessorio;
import jakarta.persistence.*;

public class AcessorioDAO implements IAcessorio{


    @Override
    public Acessorio cadastrar(Acessorio acessorio) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


        return acessorio;
    }
}
