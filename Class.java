package programa;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Class{
    private String[][]estacionamientos = {{"A1-VIP", "A2-PREMIUM", "A3", "A4", "A5", "A6", "A7"},{"B1-VIP", "B2-PREMIUM","B3", "B4", "B5", "B6", "B7"},
    {"C1-VIP", "C2-PREMIUM","C3", "C4", "C5", "C6", "C7"},{"D1-VIP", "D2-PREMIUM","D3", "D4", "D5", "D6", "D7"},{"E1-VIP", "E2-PREMIUM","E3", "E4", "E5", "E6", "E7"}};
    private double pago;
    private String placa;
    private int selec, horae, minutoe;

    
    public Class(String[][] estacionamientos, double pago, String placa, int selec, int horae, int minutoe) {
        this.estacionamientos = estacionamientos;
        this.pago = pago;
        this.placa = placa;
        this.selec = selec;
        this.horae = horae;
        this.minutoe = minutoe;
    }

    public int getHorae() {
        return horae;
    }

    public void setHorae(int horae) {
        this.horae = horae;
    }

    public int getMinutoe() {
        return minutoe;
    }

    public void setMinutoe(int minutoe) {
        this.minutoe = minutoe;
    }

    public int getSelec() {
        return selec;
    }

    public void setSelec(int selec) {
        this.selec = selec;
    }

    public String[][] getEstacionamientos() {
        return estacionamientos;
    }

    public void setEstacionamientos(String[][] estacionamientos) {
        this.estacionamientos = estacionamientos;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void menu()throws IOException{
        System.out.println("***********************************************");
        System.out.println("1. DISPONIBILIDAD ");
        System.out.println("2. MONTO RECAUDADO ");
        System.out.println("3. ALQUILER"); 
        System.out.println("4. CIERRE DE CAJA");
        System.out.println("5. LIBERACIÓN");
        System.out.println("***********************************************");
    }

    public void opciones(){
        if (selec == 1){
            disponibilidad();
        }
        if (selec == 2){

        }
        if (selec == 3){
        }
        if (selec == 4){
        }
        if (selec == 5){
        }
    }
    
    public void validacionSiNo(int nume){
        Scanner scanner = new Scanner(System.in);

        while (nume>3||nume<1){
            System.out.println("Elija una opcionn valida");
            nume=scanner.nextInt();
        }

    }
    public void alquiler()throws IOException{
        int tipo = 0;
        String park = "", entrada = "";
        boolean aver= true, veri = true;
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        Regist rg = new Regist(estacionamientos, tipo, entrada, tipo, tipo, tipo, entrada, entrada, entrada, entrada, park, entrada, null);

        System.out.println("1. alquiler por minutos\n2.alquiler por dia\n3.alquiler por mes");
        System.out.println("elija el nuemro de la opcion deseada");
        tipo=scanner.nextInt();
        validacionSiNo(tipo);
        System.out.println("Ingrese su numero de placa");
        placa = leer.readLine();
        placa = placa.toUpperCase();
        veri= rg.equals();
        if(veri==false){
            System.out.println("1. alquiler por minutos\n2.alquiler por dia\n3.alquiler por mes");
            System.out.println("elija el nuemro de la opcion deseada");
            tipo=scanner.nextInt();
            validacionSiNo(tipo);
            System.out.println("Su vehiculo no está registrado, proceda a registrarse");
            if(tipo==1){
                rg.registrarPorHora();
            }
            if(tipo==2){
            }
            else{
                
            }


        }
        else{
            System.out.println("1. alquiler por minutos\n2.alquiler por dia\n3.alquiler por mes");
            System.out.println("elija el nuemro de la opcion deseada");
            tipo=scanner.nextInt();
            validacionSiNo(tipo);
            if(tipo == 1){
                System.out.println("La tarifa es de 0.05 por minuto");
                do{
                    System.out.println("Ingrese el codigo de un espacio disponible(SOLO EL CODIGO): ");
                    park = leer.readLine();
                    park = park.trim();
                    park = park.toUpperCase();
                    while(park == "A1" ||park == "A2" ||park == "B1" ||park == "B2" ||park == "C1" ||park == "C2" ||park == "D1" ||park == "D2" ||park == "E1" ||park == "E2"){
                        System.out.println("estos estacionamientos estan reservados para clientes VIP y Premium\nSELECCIONE UN ESTACIONAMIENTO QUE NO DIGA VIP O PREMIUM");
                        park = leer.readLine();
                    }
                    for(int i = 0; i<5;i++){
                        for(int j = 0; j<7;j++){
                            if(estacionamientos[i][j] == park){
                                aver = true;
                                estacionamientos[i][j] = estacionamientos+"-OCUPADO";
                                break;
                            }
                        }
                        if(aver == true){
                            break;
                        }
                    } 
                }while(aver == false);
                System.out.println("ingrese la hora de entrada en formato de 24 horas\nHORA");
                horae=scanner.nextInt();
                while(horae>23||horae<0){
                    System.out.println("INGRESE UNA HORA DE 0 A 23");
                    horae=scanner.nextInt();
                }
                System.out.println("MINUTO");
                minutoe = scanner.nextInt();
                while(minutoe>59||minutoe<0){
                    System.out.println("INGRESE UN MINUTO DE 0 A 59");
                    minutoe = scanner.nextInt();
                }
                entrada = horae + ":" + minutoe;
                System.out.println("Auto placa: "+placa+"\n Hora de entrada: "+entrada+"\nEstacionamiento: "+park);
            }
            else if(tipo == 2){
                System.out.println("La tarifa es de $6.50 el dia");
                do{
                    System.out.println("Ingrese el codigo de un espacio disponible(SOLO EL CODIGO)");
                    park = leer.readLine();
                    park = park.trim();
                    park= park.toUpperCase();
                    if(park == "A2" ||park == "B2" ||park == "C2" ||park == "D2" ||park == "E2"){
                        park = park+"-PREMIUM";
                    }
                    for(int i = 0; i<5;i++){
                        for(int j = 0; j<7;j++){
                            if(estacionamientos[i][j] == park){
                                aver = true;
                                estacionamientos[i][j] = estacionamientos+"-OCUPADO";
                                break;
                            }
                        }
                        if(aver == true){
                            break;
                        }
                    } 
                }while(aver == false);
                System.out.println("ingrese la hora de entrada en formato de 24 horas\nHORA");
                horae=scanner.nextInt();
                while(horae>23||horae<0){
                    System.out.println("INGRESE UNA HORA DE 0 A 23");
                    horae=scanner.nextInt();
                }
                System.out.println("MINUTO");
                minutoe = scanner.nextInt();
                while(minutoe>59||minutoe<0){
                    System.out.println("INGRESE UN MINUTO DE 0 A 59");
                    minutoe = scanner.nextInt();
                }
                entrada = horae + ":" + minutoe;
                System.out.println("Auto placa: "+placa+"\n Hora de entrada: "+entrada+"\nEstacionamiento: "+park);
            }
            else{
                do{
                    System.out.println("Ingrese el codigo de un espacio disponible(SOLO EL CODIGO): ");
                    park = leer.readLine();
                    park = park.trim();
                    park = park.toUpperCase();
                    if(park == "A1" ||park == "B1" || park == "C1" ||park == "D1" ||park == "E1"){
                        park = park+"-VIP";
                    }
                    for(int i = 0; i<5;i++){
                        for(int j = 0; j<7;j++){
                            if(estacionamientos[i][j] == park){
                                aver = true;
                                estacionamientos[i][j] = estacionamientos+"-OCUPADO";
                                break;
                            }
                        }
                        if(aver == true){
                            break;
                        }
                    } 
                }while(aver == false);
                System.out.println("ingrese la hora de entrada en formato de 24 horas\nHORA");
                horae=scanner.nextInt();
                while(horae>23||horae<0){
                    System.out.println("INGRESE UNA HORA DE 0 A 23");
                    horae=scanner.nextInt();
                }
                System.out.println("MINUTO");
                minutoe = scanner.nextInt();
                while(minutoe>59||minutoe<0){
                    System.out.println("INGRESE UN MINUTO DE 0 A 59");
                    minutoe = scanner.nextInt();
                }
                entrada = horae + ":" + minutoe;
                System.out.println("Auto placa: "+placa+"\n Hora de entrada: "+entrada+"\nEstacionamiento: "+park);
            }
        }


    }

    public void disponibilidad(){
        for(int i = 0; i<5; i++){
            for(int c = 0; c<7; c++){
                System.out.print("|"+estacionamientos[i][c]+"| ");
            }
            System.out.println();
        }
    }
}
