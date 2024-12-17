package br.com.danilo.dao;

/**
 * @author danmoreira28
 */

import java.util.ArrayList;
import java.util.List;
import br.com.danilo.domain.*;

public interface ICarro {
    Carro cadastrar(Carro car);
    Carro buscarPorCodigoMarca(String codigoMarca);
}