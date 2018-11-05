package redes.com.pruebaanswer.firebase.Dto;

import android.support.annotation.NonNull;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DtoSimpleSeccion extends RealmObject {
    @PrimaryKey
    @NonNull
    private String IdSeccion;
    private String Description;
    private String Idform;
    private String name;


    public String getIdSeccion() {
        return IdSeccion;
    }

    public void setIdSeccion(String idSeccion) {
        IdSeccion = idSeccion;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getIdform() {
        return Idform;
    }

    public void setIdform(String idform) {
        Idform = idform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
