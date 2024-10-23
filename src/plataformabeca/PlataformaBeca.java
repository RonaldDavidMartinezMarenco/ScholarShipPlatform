
package plataformabeca;
import java.util.Date;
import java.util.Scanner;
public class PlataformaBeca {

    public static void main(String[] args) {
       //Creacion de objetos.
       User u1 = new User();
       Beca c1 = new Beca();
       Scanner sc = new Scanner (System.in);
       
       //Fecha de limite de postulacion beca.
       Date fechaLimite = new Date(2024-1900,10,10);
       //Simulando fecha posterior a 20 de noviembre.
       Date fechaRevisar = new Date(2024-1900,10,21);
       
       //Creacion de variables para el main.
       String correo,nombre,mensaje;
       int id,op;
       
       //Objetos de prueba que usamos.
       Beca becaExcelencia  = new Beca(22623,"Beca excelencia Academica",1000,fechaLimite);
       User Marco = new User(1048,"Marco@xd","Marco Gonzalez");
       User Ronald = new User(2214, "Ronald@xeed2","Ronald Martinez");
       Marco.mostrar();
       System.out.println("\n");
       Ronald.mostrar();
       System.out.println("\n");
       System.out.println("Becas disponibles: ");
       mensaje = becaExcelencia.detallarBeca();
       System.out.println(mensaje);//Me esta llamando mi mamaxd
        
       System.out.println("¿Deseas postularte a la beca? 1.si 2.no");
       op=sc.nextInt();
       Ronald.subirDocumentos();
       becaExcelencia.agregarPostulante(Ronald);
       becaExcelencia.revisarPostulaciones(fechaRevisar, Ronald);
       if (op==1) {
            Marco.subirDocumentos();
            becaExcelencia.agregarPostulante(Marco);
            becaExcelencia.revisarPostulaciones(fechaRevisar, Marco);
            becaExcelencia.enviarNotificaciones();
       }else{
            System.out.println("Muchas gracias.");
        }
       
       
       
       
       
    }
    
}
