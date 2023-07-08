package repositorio;

public interface OrdenablePaginableCrudRepositorio extends OrdenableRepositorio, PaginableRepositorio, CrudRepositirio, ContableRepositorio{
    //este metodo solo es para hacer la herencia multiple de todas las interfaces
    //una interface para unir las demas interfaces
}
