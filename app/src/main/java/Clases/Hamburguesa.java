package Clases;

import java.io.Serializable;

public class Hamburguesa implements Serializable {

    private String tipo;
    private boolean cebolla;

    public Hamburguesa(String tip, boolean b)
    {
        tipo = tip;
        cebolla = b;
    }
    public String getTipo()
    {
        return tipo;
    }

    public boolean getCebolla()
    {
        return cebolla;
    }

}
