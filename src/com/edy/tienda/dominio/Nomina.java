package com.edy.tienda.dominio;

import java.util.ArrayList;
import java.util.List;

public class Nomina {
    public long gananciaMes=0;

    public List<Empleado> empleados = new ArrayList<>();

    public long getGananciaMes() {
        return gananciaMes;
    }

    public void setGananciaMes(long gananciaMes) {
        this.gananciaMes = gananciaMes;
    }
}
