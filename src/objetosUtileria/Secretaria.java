/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosUtileria;

import acciones.Capturista;
import acciones.Capturista.onCapturistaAction;
import acciones.Consultor;
import acciones.Consultor.onConsultorInterface;
import java.util.Scanner;

public class Secretaria implements onConsultorInterface,onCapturistaAction {

    Consultor consultor;
    Capturista capturista;
    
    public Secretaria(){
        consultor=new Consultor(this);
        capturista=new Capturista(this);
        boolean cond=true;
        while(cond){
            System.out.println("\nMENU\n"
                    + "1) Crear estudiante \n"
                    + "2) Buscar estudiante \n"
                    + "3) Modificar estudiante \n"
                    + "4) Eliminar estudiante \n"
                    + "5) Salir \n");
            Scanner scanner=new Scanner(System.in);
            int entrada=scanner.nextInt();
            switch(entrada){
                case 1:
                    capturista.capturar();
                    break;
                case 2:
                    capturista.ingresoDeNombre();
                    break;
                case 3:
                    consultor.modificarEstudiante();
                    break;
                case 4:
                    capturista.NombreABorrar();
                    break;
                case 5:
                    cond=false;
                    break;
            }
        }
    }

    @Override
    public void onConsulta() {
        System.out.println("---->Inicia procedimiento de modificacion de estudiante");
    }

    @Override
    public void onError() {
        System.out.println("---->Error en la modificacion del estudiante");
    }

    @Override
    public void onCreateEstudiante() {
        System.out.println("---->Tu estudiante ya fue ingresado en la lista");
    }

    @Override
    public void onCaptura() {
        System.out.println("---->Inicia procedimiento de creacion de estudiante");
    }

    @Override
    public void onErrorOnCaptura() {
        System.out.println("---->Error en la captura del estudiante");
    }

    @Override
    public void onCapturaTerminada(Estudiante estudiante) {
        consultor.agregarEstudianteALista(estudiante);
    }

    @Override
    public void onNombreABuscarIngresado(String ingresado) {
        System.out.println("----->Nombre ingresado");
        consultor.buscar(ingresado);
    }

    @Override
    public void onEstudianteEncontrado(Estudiante estudiante) {
        System.out.println("\nNombre encontrado: "+estudiante.getNombre()+" "+
                estudiante.getPaterno()+" "+estudiante.getMaterno()+"\n"+"Edad: "+
                estudiante.getEdad()+"\n");
    }

    @Override
    public void onIngresadoParaBorrar(String ingresado) {
        System.out.println("----->Nombre ingresado para borrar");
        Estudiante estudiante = consultor.buscar(ingresado);
        consultor.borrar(estudiante);
    }

    @Override
    public void onEstudianteBorrado(String data) {
        System.out.println("Estudiante borrado ->"+data+"\n");
        consultor.muestra();
    }
    
}
