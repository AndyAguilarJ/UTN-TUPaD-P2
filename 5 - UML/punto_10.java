package prog2.tp_5;

class ClaveSeguridad {
    private String codigo;
    private String ultimaModificacion;

    public ClaveSeguridad(String codigo, String ultimaModificacion) {
        this.codigo = codigo;
        this.ultimaModificacion = ultimaModificacion;
    }
}

class TitularCB {
    private String nombre;
    private String dni;
    private CuentaBancaria cuenta;

    public TitularCB(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }
}

class CuentaBancaria {
    private String cbu;
    private double saldo;
    private ClaveSeguridad clave;
    private TitularCB titular;

    public CuentaBancaria(String cbu, double saldo, String codigo, String ultimaModificacion) {
        this.cbu = cbu;
        this.saldo = saldo;
        this.clave = new ClaveSeguridad(codigo, ultimaModificacion);
    }

    public void setTitular(TitularCB titular) {
        this.titular = titular;
        titular.setCuenta(this);
    }
}

public class punto_10 {
    
}
