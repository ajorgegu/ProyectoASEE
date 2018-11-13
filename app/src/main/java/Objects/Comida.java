package Objects;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.util.ArrayList;

@Entity
public class Comida {

    @PrimaryKey

    private String nombre;
    private ArrayList<Alimento> alimentos;


    public Comida(String nombre){
        this.nombre=nombre;
        this.alimentos=new ArrayList<>();
    }
    public Comida(String nombre, ArrayList<Alimento> alimentos) {
        this.nombre = nombre;
        this.alimentos = alimentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(ArrayList<Alimento> alimentos) {
        this.alimentos = alimentos;
    }
}
