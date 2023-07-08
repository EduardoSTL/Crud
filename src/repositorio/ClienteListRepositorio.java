package repositorio;

import modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio {
    //esta es la clase que implementa todos lo metodos de las interface existentes

    private List<Cliente> dataSource;//es un contenedor que almacena la tabla Cliente de la base de datos "modelo"
    //dataSource inicializado desde 0

    public ClienteListRepositorio(){
        this.dataSource = new ArrayList<>();
        //este constructor llama al dataSource e Inicializa el ArrayList<Cliente>
    }

    //implemento los metodos del Crud:
    @Override
    public List<Cliente> listar() {
        return dataSource;
        //esto no se genera automat.
        //lista=select de la entidad Cliente
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;
        for (Cliente cli: dataSource){
            //el for-each recorre cada uno de los registros del ArrayList
            if (cli.getId() != null && cli.getId().equals(id)){
                //compara el id del dataSource y el id=(Integer id), luego devuelve el id que se quiere buscar
                // y se almacena en "clie"
                resultado = cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSource.add(cliente);
        //metodo que añade los datos de Cliente
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        //obtiene el Cliente que obtiende por Id, lo alamcena en una variable
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
        //set hereda los datos de Cliente
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        //String=nombre, Dir=ENUM
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        //dataSource inicializado con Contenido
        listaOrdenada.sort((a, b) -> { //a y b son variables diferentes pero del mismo tipo(Cliente)
            //metodo.sort, expresion lamba = ->
            //la funcion de este metodo es ordenar datos en un ArrayList
            int resultado = 0;
            if (dir == Direccion.ASC){
                resultado = ordenar(campo, a, b);
            } else if (dir == Direccion.DESC) {
                resultado = ordenar(campo, a, b);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
        //
        //dataSource usa el motodo.sublist
    }

    //esta es una clase:
    public static int ordenar(String campo, Cliente a, Cliente b){
        int resultado = 0;
        switch (campo){
            case "Id" ->
                resultado = a.getId().compareTo(b.getId());
            //.compareTo se usa para comparar dos datos del mismo datatype
            case "nombre" ->
                    resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" ->
                resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

    @Override
    public int total() {
        return this.dataSource.size();
        //retorna el total de registros del dataSource
    }
}
