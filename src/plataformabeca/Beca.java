package plataformabeca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
  
public class Beca {
    private int idBeca;
    private String nombre;
    private double monto;
    private Date fechaLimite;
    private List <User> postulantes = new ArrayList<>();

    public Beca() {
    }
    //Recibe parametros tales como, identificacion beca, nombre beca, el monto y la fecha limite de postuacion.
    public Beca(int identificacion, String nombre, double monto,Date fechaLimite) {
        setIdentificacion(identificacion);        
        setNombre(nombre);
        setMonto(monto);
        setFechaLimite(fechaLimite);
    }
    public void agregarPostulante (User estudiante){
        if (estudiante.documentosSubidos()) {
            postulantes.add(estudiante);
            estudiante.postular();//Aqui postulamos al estudiante
            System.out.println(estudiante.getNombre()+" se ha postulado a la "+nombre);
            
        }else{
            System.out.println("Error: "+ estudiante.getNombre()+"No ha subido los documentos.");
        }
    }
    public void revisarPostulaciones (Date fechaActual, User estudiante){
        if (fechaActual.after(fechaLimite))
        {
            for (int i = 0; i < postulantes.size(); i++) {
                if (i%2==0) { //Simulando que los estudiantes pares son los que aceptamos.
                    estudiante.aceptar();
                }else{
                    estudiante.rechazar();
                }
            }
        }else{
            System.out.println("Aun no es la fecha correcta.");
        }
    }
    public void enviarNotificaciones(){
        for(User estudiante : postulantes){
            System.out.println("Notificacion para "+estudiante.getNombre()+" : "+estudiante.getEstadoPostulacion());
        }
    }
    public int getIdentificacion() {
        return idBeca;
    }

    public void setIdentificacion(int identificacion) {
        if (identificacion < 0) {
            throw new IllegalArgumentException("identificacion no puede ser"
                    + " negativo");
        }
        this.idBeca = identificacion;
    }

    public String getCorreo() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre== null) {
            throw new IllegalArgumentException("nombre no puede ser "
                    + "nulo");
        }
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("monto no puede ser negativo");
        }
        this.monto = monto;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechalimite) {
        this.fechaLimite = fechalimite;
    }
    
    public String detallarBeca(){
        String mensaje = "Beca: "+nombre+"\n"+"Monto USD: "+monto+"\n"+"FechaLimite: "+fechaLimite;
        return mensaje;
    }  
 }

