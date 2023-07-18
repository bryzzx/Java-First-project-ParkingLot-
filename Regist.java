package programa;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Regist extends Class{

    private String nombre, marca, año, color, telefonoP, telefonoE;
    private ArrayList <String> veriRegi = new ArrayList<String>();
    

    public Regist(String[][] estacionamientos, double pago, String placa, int selec, int horae, int minutoe,
            String nombre, String marca, String año, String color, String telefonoP, String telefonoE, ArrayList<String> veriRegi){
        super(estacionamientos, pago, placa, selec, horae, minutoe);
        this.nombre = nombre;
        this.marca = marca;
        this.año = año;
        this.color = color;
        this.telefonoP = telefonoP;
        this.telefonoE = telefonoE;
        this.veriRegi = veriRegi;
    } 
    
    public ArrayList<String> getVeriRegi() {
        return veriRegi;
    }

    public void setVeriRegi(ArrayList<String> veriRegi) {
        this.veriRegi = veriRegi;
    }

    public String getTelefonoP() {
        return telefonoP;
    }

    public void setTelefonoP(String telefonoP) {
        this.telefonoP = telefonoP;
    }

    public String getTelefonoE() {
        return telefonoE;
    }

    public void setTelefonoE(String telefonoE) {
        this.telefonoE = telefonoE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void registrarPorHora() throws IOException{

        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ArrayList <String> list = new ArrayList<String>();
        ArrayList <String[]> baseDeDatos = new ArrayList<String[]>();


        list.add(getPlaca());
        veriRegi.add(getPlaca());
        System.out.println("ingrese su nombre y apellido");
        nombre = leer.readLine();
        list.add(nombre);
        veriRegi.add(nombre);
        System.out.println("Ingrese la marca y modelo de su auto");
        marca = leer.readLine();
        marca = marca.toUpperCase();
        list.add(marca);
        veriRegi.add(marca);
        System.out.println("ingrese el color de su auto");
        color = leer.readLine();
        color = color.toUpperCase();
        list.add(color);
        veriRegi.add(color);
        System.out.println("Ingrese su numero de telefono personal");
        telefonoP = leer.readLine();
        list.add(telefonoP);
        veriRegi.add(telefonoP);
        System.out.println("Ingrese un numero de telefono de emergencia");
        telefonoE = leer.readLine();
        list.add(telefonoE);
        veriRegi.add(telefonoE);
        String[] base = list.toArray(new String[list.size()]);
        baseDeDatos.add(base);
        list.clear();
    }

    publi

    public boolean equals(){
        boolean result = false;
        veriRegi.contains(getPlaca());
        return result;
    }
    
    

}