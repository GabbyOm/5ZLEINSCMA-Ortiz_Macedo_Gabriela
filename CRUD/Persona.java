
public class Persona{
private int id;
private String Nombre;
private int edad;
public Persona(){
   }
public Persona (int id, String nombre, int edad){
this.id = id;
this.Nombre = nombre;
this.edad = edad;
  }
public int getId(){
return id;
}
public void setId(int id){
this.id = id;
}
public String getNombre(){
return Nombre;
}
public void setNombre(String Nombre){
this.Nombre = Nombre;
}
public int getEdad(){
return edad;
}
public void setEdad(int Edad){
this.edad = Edad;
}
}