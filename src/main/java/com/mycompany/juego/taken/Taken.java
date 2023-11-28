package com.mycompany.juego.taken;
import java.util.LinkedList;
import java.util.List;

public class Taken {
    String lista[];
    List<String> tablero;
    int movimientos;
    String Horizontal[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",""};
    String Espiral[] = {"7","8","9","10","5","1","2","11","5","4","3","12","","15","14","13"};
    String Imposible[] = {"15","14","13","12","11","10","9","8","7","6","5","4","3","2","1",""};
    String Periferico[] = {"1","2","3","4","12","13","14","5","11","","15","6","10","9","8","7"};
    String Vertical[] = {"1","5","9","13","2","6","10","14","3","7","11","15","4","8","12",""};
    
    Taken(){
        tablero = new LinkedList<String>();
        reiniciar();
    }
    
    void actualizarDato(){
        lista = new String[tablero.size()];
        lista = tablero.toArray(lista);
    }
    
    boolean verificarTablero(){
        boolean resp = true;
        int i=0;
        actualizarDato();
        while(resp == true && i<16){
            resp=false;
            if(lista[i] == Horizontal[i]){
                resp = true;
            }
            i++;
        }
        if(resp == false){
            resp = true;
            i = 0;
            while(resp == true && i<16){
                resp=false;
                if(lista[i] == Espiral[i]){
                    resp = true;
                }
                i++;
            }
        }
        if(resp == false){
            resp = true;
            i = 0;
            while(resp == true && i<16){
                resp=false;
                if(lista[i] == Imposible[i]){
                    resp = true;
                }
                i++;
            }
        }
        if(resp == false){
            resp = true;
            i = 0;
            while(resp == true && i<16){
                resp=false;
                if(lista[i] == Periferico[i]){
                    resp = true;
                }
                i++;
            }
        }
        if(resp == false){
            resp = true;
            i = 0;
            while(resp == true && i<16){
                resp=false;
                if(lista[i] == Vertical[i]){
                    resp = true;
                }
                i++;
            }
        }
        
        return resp;
    }
    

String moverTecla(int num, int dir) {
    String resp = "Moviendo tecla.";
    String aux;
    int pos = -1;
    
    pos = tablero.indexOf(String.valueOf(num));
    
    switch (dir) {
        case 1 -> {
            // Arriba
            if (pos >= 4 && tablero.get(pos-4).equals("")) {
                aux = tablero.get(pos);
                tablero.set(pos, tablero.get(pos-4));
                tablero.set(pos-4,aux);
                movimientos++;
                resp = "Tecla cambiada.";
            } else {
                resp = "No se pudo mover.";
            }
            }

        case 2 -> {
            // Abajo
            if (pos <= 11 && tablero.get(pos+4).equals("")) {
                aux = tablero.get(pos);
                tablero.set(pos, tablero.get(pos+4));
                tablero.set(pos+4,aux);
                movimientos++;
                resp = "Tecla cambiada.";
            } else {
                resp = "No se pudo mover.";
            }
            }

        case 3 -> {
            // Derecha
            if (pos % 4 != 3 && tablero.get(pos+1).equals("")) {
                aux = tablero.get(pos);
                tablero.set(pos, tablero.get(pos+1));
                tablero.set(pos+1,aux);
                movimientos++;
                resp = "Tecla cambiada.";
            } else {
                resp = "No se pudo mover.";
            }
            }

        case 4 -> {
            // Izquierda
            if (pos % 4 != 0 && tablero.get(pos-1).equals("")) {
                aux = tablero.get(pos);
                tablero.set(pos, tablero.get(pos-1));
                tablero.set(pos-1,aux);
                movimientos++;
                resp = "Tecla cambiada.";
            } else {
                resp = "No se pudo mover.";
            }
            }
    }
    actualizarDato();
    return resp;
}
    
    int obtenerMovimientos(){
        return movimientos;
    }
    
    void reiniciar(){
        tablero.clear();
        for (int i=0; i<13; i++){
            tablero.add(String.valueOf(i+1));
        }
        tablero.add("15");
        tablero.add("14");
        tablero.add("");
        movimientos=0;
    }
}
