
import modelo.Cliente;
import repositorio.ClienteListRepositorio;
import repositorio.Direccion;
import repositorio.OrdenablePaginableCrudRepositorio;
import java.util.List;

public class EjemploRepositorio {

    public static void main(String[] args) {
        OrdenablePaginableCrudRepositorio repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Juan", "Perez"));
        repo.crear(new Cliente("Bea", "Gonzales"));
        repo.crear(new Cliente("Luci", "Martinez"));
        repo.crear(new Cliente("Andrés", "Guzman"));
        repo.crear(new Cliente("Carlos", "Lopez"));

        //metodo listar:
        System.out.println(" ---- metodo listar ---- ");
        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);

        //metodo paginable, listar desde-hasta
        System.out.printf(" ===== Paginable ===== ");
        List<Cliente> paginable = repo.listar(0, 4);
        //desde el index 0 hasta 4
        paginable.forEach(System.out::println);

        //metodo ordenar
        System.out.printf("---- ordenar ----");
        List<Cliente> clientesOrdenAsc = repo.listar("apellido", Direccion.ASC);
        for (Cliente c: clientesOrdenAsc){
            System.out.println(c);
        }

        System.out.printf("---- ordenar ----");
        List<Cliente> clientesOrdenDes = repo.listar("apellido", Direccion.DESC);
        for (Cliente c: clientesOrdenAsc){
            System.out.println(c);
        }

        //metodo editar
        System.out.println("---- editar ----");
        Cliente beaActualizar = new Cliente("Bea", "Gonzales");
        beaActualizar.setId(2);
        repo.editar(beaActualizar);
        Cliente bea = repo.porId(2);
        System.out.println(bea);
        System.out.println(" ----- ");
        repo.listar("nombre", Direccion.ASC).forEach(System.out::println);

        //metodo eliminar
        System.out.println("---- eliminar ----");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

        //metodo total de registros
        System.out.println("---- total ----");
        System.out.println("Total registros: " + repo.total());
    }
}
