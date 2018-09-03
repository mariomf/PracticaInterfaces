/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import objetosUtileria.Estudiante;

/**
 *
 * @author rafaelm
 */
public class Consultor {
    
    List<Estudiante> estudiantes;
    onConsultorInterface laSecre;
    
    public Consultor(onConsultorInterface secre){
        this.laSecre=secre;
        estudiantes=new ArrayList<Estudiante>();
    }
    
    
    public void agregarEstudianteALista(Estudiante estudiante){
        estudiantes.add(estudiante);
        laSecre.onCreateEstudiante(); 
    }
    
    public Estudiante buscar(String nombre){
        for(Estudiante estudianteARevisar:estudiantes){
            if(estudianteARevisar.getPaterno().equals("null")){
                
            }else{
                System.out.println("Estudiante iterado "+estudianteARevisar.getNombre());
                if(nombre.equals(estudianteARevisar.getNombre())){
                    laSecre.onEstudianteEncontrado(estudianteARevisar);
                    return estudianteARevisar;
                    //break;
                }                
            }
        }
        System.out.println("\nEstudiante no encontrado!\n");
        return null;
    }

    public void muestra(){
        for(Estudiante estudianteARevisar:estudiantes){
            if(estudianteARevisar.getPaterno().equals("null")){
                
            }else{
                System.out.println("Estudiante iterado "+estudianteARevisar.getNombre()+" "+estudianteARevisar.getPaterno()+" "+estudianteARevisar.getMaterno());
            }
            
            
        }
    }
    
    public void modificarEstudiante(){
        laSecre.onConsulta();
        Scanner scann=new Scanner(System.in);
        System.out.println("Ingresa el nombre del estudiante a modificar: ");
        String nombre = scann.nextLine();
        for(Estudiante estudianteARevisar:estudiantes){
            if(estudianteARevisar.getPaterno().equals("null")){
                
                System.out.println("\nEstudiante no encontrado!\n");
                
            }else if(nombre.equals(estudianteARevisar.getNombre())){
                laSecre.onEstudianteEncontrado(estudianteARevisar);
                Scanner sc=new Scanner(System.in);
                
                System.out.println("Ingresa nuevo nombre");
                String nombre1=sc.nextLine();
                System.out.println("Ingresa nuevo paterno");
                String paterno=sc.nextLine();
                System.out.println("Ingresa nuevo materno");
                String materno=sc.nextLine();
                try {
                    System.out.println("Ingresa nueva edad");
                    int edad=sc.nextInt();
                    estudianteARevisar.setEdad(edad);
                    estudianteARevisar.setNombre(nombre1);
                    estudianteARevisar.setMaterno(materno);
                    estudianteARevisar.setPaterno(paterno);
                    laSecre.onCreateEstudiante();
                } catch (Exception e) {
                    laSecre.onError();
                }
                //break;
            }else{
                System.out.println("\nEstudiante no encontrado!\n");
            }
        }
    }
    
    
    
    public void borrar(Estudiante estudiante){
        estudiante.setPaterno("null");
        laSecre.onEstudianteBorrado(estudiante.getNombre());
    }
    
    
    public interface onConsultorInterface{
        public void onConsulta();
        public void onError();
        public void onCreateEstudiante();
        public void onEstudianteEncontrado(Estudiante estudiante);
        public void onEstudianteBorrado(String data);
    }
    
}
