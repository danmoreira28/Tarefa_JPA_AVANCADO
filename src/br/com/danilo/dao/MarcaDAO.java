package br.com.danilo.dao;

/**
 * @author danmoreira28
 */

import java.util.List;
import jakarta.persistence.*;
import br.com.danilo.domain.Marca;

public class MarcaDAO implements IMarca{


    @Override
    public Marca cadastrar(Marca mar){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(mar);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return mar;
    }
}
