package br.com.danilo;

/**
 * @author danmoreira28
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.time.Instant;

import br.com.danilo.dao.*;
import org.junit.Test;
import br.com.danilo.domain.*;

public class CarroTest {

    @Test
    public void testCadastrarCarro() {
        Carro carro = new Carro();
        carro.setCodigo("A1");
        carro.setDescricao("Carro teste");

        Marca marca = new Marca();
        marca.setNome("Ford");
        marca.getCarros().add(carro);
        carro.setMarca(marca);

        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo("A1");
        acessorio.setNome("Turbo");
        acessorio.setCarro(carro);
        carro.getAcessorios().add(acessorio);

        CarroDAO carroDAO = new CarroDAO();
        Carro carroCadastrado = carroDAO.cadastrar(carro);

        assertNotNull(carroCadastrado);
    }
}

