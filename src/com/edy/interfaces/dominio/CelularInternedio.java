package com.edy.interfaces.dominio;

public class CelularInternedio extends CelularBasico implements Desbloqueable {
    private String passwordCorrecto;

    public CelularInternedio(String marca, Persona propietario) {
        super(marca, propietario);
        this.passwordCorrecto = propietario.getPassword();
    }

    @Override
    public boolean desbloquear(Persona persona) {
        return passwordCorrecto.equals(persona.getPassword());
    }
}