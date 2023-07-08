package generics;

import modelo.Cliente;
import modelo.ClientesPremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        //ArrayList
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Fausto", "Guzman"));

        Cliente Fausto = clientes.iterator().next();

        //Array(tradicional) a convertir to ArrayList
        Cliente[] clienteArreglo = {new Cliente("Luci", "Martinez"),
                new Cliente("Andres" , "Guzman")};
        Integer[] enterosAreglo = {1,2,3};

        List<Cliente> clientesLista = fromArrayToList(clienteArreglo);
        //con fromArrayToList enviamos el Array tradicional a un ArrayList
        List<Integer> enterosLista = fromArrayToList(enterosAreglo);

        clientesLista.forEach(System.out::println);
        enterosLista.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[]{"Andres", "Pepe", "Luci", "Bea", "John"}, enterosAreglo);
        nombres.forEach(System.out::println);

        List<ClientesPremium> clientePremiumList = fromArrayToList(
                new ClientesPremium[] {new ClientesPremium("Paco", "Fernandez")});

        imprimirClientes(clientes);
        imprimirClientes(clientesLista);
        imprimirClientes(clientePremiumList);

        System.out.println("Maximo de 1, 9 y 4 es: " + maximo(1, 9, 4));
        System.out.println("Maximo de 3.9, 11.6, 7.8 es: " + maximo(3.9, 11.6, 7.8));
        System.out.println("Maximo de zanahoria, arandanos, manzana es: " +
                maximo("zanahoria", "zanahoria", "manzana"));
    }

    public static <T> List<T> fromArrayToList(T[] c){
        //T = comunmente se usa T para un metodo generico de tipo ArrayList
        return Arrays.asList(c); } // 'c' almacena el Array que hemos enviado
        //asLict(c) convierte de Array traducional a ArrayList

    public static <T extends Number> List<T> fromArrayToList(T[] c) { return  Arrays.asList(c); }

    //ejercicio per-----
    public static <T extends Number, G> List<T> fromArrayToList(T[] c, G[] x) {
        for (G ejemplo : x){
            System.out.println(ejemplo);
        }
        return  Arrays.asList(c);
    }
    //------

    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c) { return  Arrays.asList(c); }

    //Metodo que recibe 2 Arrays:
    public static <T, G> List<T> fromArrayToList(T[] c, G[] x){
        for (G elemento: x){
            System.out.println(elemento);
            //for solo recorre el Array de Integer
        }
        return Arrays.asList(c);
        //pero si convierte el Array de String
    }

    public static void imprimirClientes(List<? extends Cliente> clientes) {clientes.forEach(System.out::println);}

    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T max = a;
        if (b.compareTo(max) > 0){
            max = b;
        } if (c.compareTo(max) > 0){
            max = c;
        }
        return max;
    }

}

