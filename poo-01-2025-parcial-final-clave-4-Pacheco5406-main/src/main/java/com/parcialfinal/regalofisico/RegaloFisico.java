package com.parcialfinal.regalofisico;

import java.time.LocalDate;

/**
 * Representa un regalo físico con destinatario, remitente, mensaje,
 * tipo de regalo, fecha de envío y tipo de entrega.
 */
public class RegaloFisico {

    private int regaloID;
    private String destinatario;
    private String remitente;
    private String mensaje;
    private String tipoRegalo;
    private LocalDate fechaEnvio;
    private String tipoEnvio;

    /**
     * Constructor vacío.
     */
    public RegaloFisico() {}

    /**
     * Constructor con ID.
     *
     * @param regaloID ID del regalo.
     * @param destinatario Persona que recibe el regalo.
     * @param remitente Persona que envía el regalo.
     * @param mensaje Mensaje del regalo.
     * @param tipoRegalo Tipo de regalo.
     * @param fechaEnvio Fecha de envío.
     * @param tipoEnvio Tipo de entrega.
     */
    public RegaloFisico(int regaloID, String destinatario, String remitente, String mensaje,
                        String tipoRegalo, LocalDate fechaEnvio, String tipoEnvio) {
        this.regaloID = regaloID;
        this.destinatario = destinatario;
        this.remitente = remitente;
        this.mensaje = mensaje;
        this.tipoRegalo = tipoRegalo;
        this.fechaEnvio = fechaEnvio;
        this.tipoEnvio = tipoEnvio;
    }

    /**
     * Constructor sin ID.
     *
     * @param destinatario Persona que recibe el regalo.
     * @param remitente Persona que envía el regalo.
     * @param mensaje Mensaje del regalo.
     * @param tipoRegalo Tipo de regalo.
     * @param fechaEnvio Fecha de envío.
     * @param tipoEnvio Tipo de entrega.
     */
    public RegaloFisico(String destinatario, String remitente, String mensaje,
                        String tipoRegalo, LocalDate fechaEnvio, String tipoEnvio) {
        this.destinatario = destinatario;
        this.remitente = remitente;
        this.mensaje = mensaje;
        this.tipoRegalo = tipoRegalo;
        this.fechaEnvio = fechaEnvio;
        this.tipoEnvio = tipoEnvio;
    }

    public int getRegaloID() {
        return regaloID;
    }

    public void setRegaloID(int regaloID) {
        this.regaloID = regaloID;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipoRegalo() {
        return tipoRegalo;
    }

    public void setTipoRegalo(String tipoRegalo) {
        this.tipoRegalo = tipoRegalo;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }
}
