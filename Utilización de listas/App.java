package appNumeros;

import ed.ito.ListaEstatica;
import ed.ito.ExcepcionDeListaLlena;
import ed.ito.ExcepcionDeListaVacia;
import javax.swing.JOptionPane;

public class App {
    
    static ListaEstatica<Integer> l=new ListaEstatica<Integer>(20);
    
    static int menu(){
        int opc=0;
        String[] datos={"1.- Agregar nuevo número",
                        "2.- Primer número",
                        "3.- Ultimo número",
                        "4.- Cantidad de números",
                        "5.- Eliminar el primer número",
                        "6.- Eliminar el último número",
                        "7.- Terminar el programa"};
        String x=(String)JOptionPane.showInputDialog(null,"Seleccione uno", "Menu",
        JOptionPane.INFORMATION_MESSAGE, null,datos,datos[0]);
        opc=Integer.parseInt(x.charAt(0)+"");
        return opc;
    }
    
    static void agregar(){
        Integer n= new Integer(0);
        n=(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un número:")));
        try{
            l.add(n);
        }catch(ExcepcionDeListaLlena e){
            System.err.println(e.getMessage());
        }
    }
    
    static void primer(){
        try{
          Integer n=l.first();
          JOptionPane.showMessageDialog(null, n, "Primer numero", 0);
        }catch(ExcepcionDeListaVacia e){
            System.err.println(e.getMessage());
        }
    }
    
    static void ultimo(){
        try{
          Integer n=l.last();
          JOptionPane.showMessageDialog(null, n, "Ultimo numero", 0);
        }catch(ExcepcionDeListaVacia e){
            System.err.println(e.getMessage());
        }
    }
    
     static void cantidad(){
        JOptionPane.showMessageDialog(null, "Cantidad de numeros: "+l.size(), "Total de numeros", 0);
    }
     
     static void eliminarP(){
         try{
          Integer n=l.deleteFirst();
          JOptionPane.showMessageDialog(null, n, "Primer numero", 0);
        }catch(ExcepcionDeListaVacia e){
            System.err.println(e.getMessage());
        }
     }
     
     static void eliminarU(){
         try{
          Integer n=l.deleteLast();
          JOptionPane.showMessageDialog(null, n, "Ultimo numero", 0);
        }catch(ExcepcionDeListaVacia e){
            System.err.println(e.getMessage());
        }
     }
    
    static void run(){
        boolean salir=false;
        while(!salir){
          switch(menu()) {
            case 1:agregar();break;
            case 2:primer();break;
            case 3:ultimo();break;
            case 4:cantidad();break;
            case 5:eliminarP();break;
            case 6:eliminarU();break;
            case 7: salir=true;
          }
        }
    }
    public static void main(String[] args) throws Exception {
        run();
    }
}
