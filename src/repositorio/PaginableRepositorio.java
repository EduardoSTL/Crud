package repositorio;

import modelo.Cliente;
import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta);
    //listar especifico
}
