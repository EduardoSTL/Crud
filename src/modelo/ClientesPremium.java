package modelo;

public class ClientesPremium extends Cliente implements Comparable<ClientesPremium> {

    public ClientesPremium(String nombre, String apellido){
        super(nombre, apellido);
    }

    @Override
    public int compareTo(ClientesPremium o) {
        return 0;
    }
}
