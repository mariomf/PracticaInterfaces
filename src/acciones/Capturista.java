/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import java.util.Scanner;
import objetosUtileria.Estudiante;

/**
 *
 * @author rafaelm
 */
public class Capturista {
    
    onCapturistaAction laSecre;
     
    public Capturista(onCapturistaAction  secre){
        this.laSecre=secre;
    }
    
 
    
    public Estudiante capturar(){
        laSecre.onCaptura();
        Scanner sc=new Scanner(System.in);
        Estudiante estudiante=new Estudiante();
        System.out.println("Ingresa nombre");
        String nombre=sc.nextLine();
        System.out.println("Ingresa paterno");
        String paterno=sc.nextLine();
        System.out.println("Ingresa materno");
        String materno=sc.nextLine();
        try {
            System.out.println("Ingresa edad");
            int edad=sc.nextInt();
            estudiante.setEdad(edad);
            estudiante.setNombre(nombre);
            estudiante.setMaterno(materno);
            estudiante.setPaterno(paterno);
            laSecre.onCapturaTerminada(estudiante);
            return estudiante;
        } catch (Exception e) {
            laSecre.onErrorOnCaptura();
        }
//        estudiante.setNombre(nombre);
//        estudiante.setMaterno(materno);
//        estudiante.setPaterno(paterno);
//        laSecre.onCapturaTerminada(estudiante);
        return estudiante;
    }
    
    public void ingresoDeNombre(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingresa el nombre de la persona a buscar");
        String data=scanner.nextLine();
        laSecre.onNombreABuscarIngresado(data);
    }
    
    public void NombreABorrar(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingresa el nombre de la persona a buscar");
        String data=scanner.nextLine();
        laSecre.onIngresadoParaBorrar(data);
        
    }
    
    public interface onCapturistaAction{
        public void onCaptura();
        public void onErrorOnCaptura();
        public void onNombreABuscarIngresado(String ingresado);
        public void onCapturaTerminada(Estudiante estudiante);
        public void onIngresadoParaBorrar(String ingresado);
    }
    
}
