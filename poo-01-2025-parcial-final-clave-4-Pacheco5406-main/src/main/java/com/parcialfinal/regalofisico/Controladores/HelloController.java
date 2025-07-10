package com.parcialfinal.regalofisico.Controladores;

import com.parcialfinal.regalofisico.Controladores.DAO.RegaloFisicoDAO;
import com.parcialfinal.regalofisico.RegaloFisico;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador principal que gestiona la vista y las operaciones
 * de registro y visualización de regalos físicos.
 */
public class HelloController {

    @FXML private TextField tf_destinatario;
    @FXML private TextField tf_remitente;
    @FXML private TextArea ta_mensaje;
    @FXML private DatePicker dp_fechaEnvio;
    @FXML private ComboBox<String> cb_tipoRegalo;
    @FXML private ComboBox<String> cb_tipoEntrega;
    @FXML private VBox lv_mostrarRegalos;

    private RegaloFisicoDAO regaloDAO = new RegaloFisicoDAO();

    /**
     * Evento para agregar un nuevo regalo a la base de datos.
     */
    @FXML
    protected void onAgregarClick() {
        try {
            String destinatario = tf_destinatario.getText();
            String remitente = tf_remitente.getText();
            String mensaje = ta_mensaje.getText();
            String tipoRegalo = cb_tipoRegalo.getValue();
            LocalDate fechaEnvio = dp_fechaEnvio.getValue();
            String tipoEnvio = cb_tipoEntrega.getValue();

            if (destinatario.isEmpty() || remitente.isEmpty() || tipoRegalo == null || fechaEnvio == null || tipoEnvio == null) {
                System.out.println("Complete todos los campos.");
                return;
            }

            RegaloFisico regalo = new RegaloFisico(destinatario, remitente, mensaje, tipoRegalo, fechaEnvio, tipoEnvio);

            regaloDAO.insertarRegalo(regalo);
            cargarRegalos();
            System.out.println("Regalo agregado correctamente.");
            limpiarCampos();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Inicializa la vista con opciones y datos existentes.
     */
    @FXML
    public void initialize() {
        cb_tipoRegalo.getItems().addAll("Flores", "Chocolate", "Juguete", "Libro");
        cb_tipoEntrega.getItems().addAll("Domicilio", "Recoger en tienda", "Correo postal");
        cargarRegalos();
    }

    /**
     * Carga y muestra la lista de regalos.
     */
    public void cargarRegalos() {
        lv_mostrarRegalos.getChildren().clear();
        List<RegaloFisico> regalos = regaloDAO.obtenerRegalos();
        for (RegaloFisico r : regalos) {
            Label label = new Label(
                    "ID: " + r.getRegaloID() +
                            ", Destinatario: " + r.getDestinatario() +
                            ", Remitente: " + r.getRemitente() +
                            ", Fecha: " + r.getFechaEnvio() +
                            ", Mensaje: " + r.getMensaje() +
                            ", Tipo: " + r.getTipoRegalo() +
                            ", Entrega: " + r.getTipoEnvio()
            );
            lv_mostrarRegalos.getChildren().add(label);
        }
    }

    /**
     * Limpia los campos de entrada.
     */
    private void limpiarCampos() {
        tf_destinatario.clear();
        tf_remitente.clear();
        ta_mensaje.clear();
        dp_fechaEnvio.setValue(null);
        cb_tipoRegalo.setValue(null);
        cb_tipoEntrega.setValue(null);
    }
}
