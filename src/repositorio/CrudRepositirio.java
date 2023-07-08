package repositorio;

import modelo.Cliente;
import java.util.List;

public interface CrudRepositirio {

    List<Cliente> listar();
    //listar general
    Cliente porId(Integer id);
    void crear(Cliente cliente);
    void editar(Cliente cliente);
    void eliminar(Integer id);
}