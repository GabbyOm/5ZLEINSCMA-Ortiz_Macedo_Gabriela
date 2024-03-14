
package Modelo;

public class Persona {
    int id;
    int edad;
    String ape;
    String nom;

    public Persona() {
    }

    public Persona(String aped, String nom) {
        this.ape = aped;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String aped) {
        this.ape = aped;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    
}
