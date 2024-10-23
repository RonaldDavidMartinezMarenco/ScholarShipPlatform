package plataformabeca;

public class User {
      //Atributos
    private int identificacion;
    private String correo;
    private String nombre;
    private String estadoPostulacion = null; //Null al registrarse sino se postula.
    private boolean documentosSubidos = false; //False si no sube documentos.
    
    
    public User() {
    }
    
    public User(int identificacion, String correo, String nombre) {
        this.identificacion = identificacion;
        this.correo = correo;
        this.nombre = nombre;
    }
    
    public int getIdentificacion() {
        return identificacion;
    }
    
    public void setIdentificacion(int identificacion) {
       if (identificacion < 0) {
            throw new IllegalArgumentException("identificacion no puede ser"
                    + " negativo");
        }
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
       if (correo == null) {
            throw new IllegalArgumentException("correo no puede ser "
                    + "nulo");
        }
        this.correo = correo;
    }

    public String getNombre() {
       return nombre;
    }

    public void setNombre(String nombre) {
          if (nombre == null) {
            throw new IllegalArgumentException("nombre no puede ser "
                    + "nulo");
        }
            this.nombre = nombre;
    }
    //Postulamos al cargar los metodos. 
    public void postular(){
        this.estadoPostulacion = "Postulacion en revision";
    }
    //Se puede estadoPostulacion por un booleano
    //Aceptamos el estado de postulacion.
    public void aceptar(){
        this.estadoPostulacion = "Has sido aceptado.";
    }
    //Rechazamos el estado de postulacion. 
    public void rechazar(){
       this.estadoPostulacion = "Has sido rechazado.";
    }
    
    //Get y sets para los estados postulacion.
    public String getEstadoPostulacion() {
        return estadoPostulacion;
    }
    
    public void setEstadoPostulacion(String estadoPostulacion) {
        if (estadoPostulacion == null) {
            throw new IllegalArgumentException("Estado de postulacion no puede ser"
                    + "nulo");
        }
        this.estadoPostulacion = estadoPostulacion;
    }
    //Muestra para estudiante respectivo, tambien se puede mostrar creando objeto beca.
    public void mostrarNotificacion(){
        if (estadoPostulacion!=null) {
            System.out.println("Notificacion para "+nombre+":"+estadoPostulacion);
        }
    }
    //El estudiante sube los documentos
    public void subirDocumentos(){
        this.documentosSubidos=true;
        System.out.println(nombre+" ha subido sus documentos.");
    }
    //El estudiante valida los documentos subidos.
    public boolean documentosSubidos(){
        return documentosSubidos;
    }
    //Mostramos atributos de registro de estudiante. 
    public void mostrar (){
        System.out.println("Nombre : "+nombre+"\n"+"identificacion: "+identificacion+"\n"+"Correo: "+correo);
        System.out.println("Te registraste correctamente, puedes acceder a la opcion postular.");
    }
 }
    



