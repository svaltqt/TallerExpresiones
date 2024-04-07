package org.svaltqt.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class VentanaPrincipalController {

    /* Labels de la App*/
    public Label LabelTipoTarjeta;
    public Label LabelNumero;
    public Label LabelNombre;
    public Label LabelApellido;
    public Label LabelFecha;
    public Label labelCVV;
    /* Botones */
    @FXML
    public Button BotonAlmacenar;
    @FXML
    public Button BotonBuscar;

    /*TextFields de la App*/
    @FXML
    public TextField txtTipo;
    @FXML
    public TextField txtNumero;
    @FXML
    public TextField txtFecha;
    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtApellido;
    @FXML
    public TextField txtCVV;
    public Label LabelError;



    private void MensajeError(Label label, String mensaje) {
        label.setText(mensaje);
        label.setStyle("-fx-text-fill: red;");
    }
    @FXML
    private void initialize() {

        // Validación para el campo txtTipo
        Pattern tipoPattern = Pattern.compile("^(MasterCard|Visa)$");

        txtTipo.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!tipoPattern.matcher(newValue).matches()) {
                MensajeError(LabelError, "'MasterCard' o 'Visa'");
            } else {
                LabelError.setText("");
            }
        });

        // Validación para el campo txtNumero
        Pattern numeroPattern = Pattern.compile("\\d{16}");

        txtNumero.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!numeroPattern.matcher(newValue).matches()) {
                MensajeError(LabelError, "Deben ser 16 Digitos");
            } else {
                LabelError.setText("");
            }
        });

        // Validación para el campo txtFecha
        Pattern fechaPattern = Pattern.compile("^(0?[1-9]|1[0-2])/\\d{2}$");

        txtFecha.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!fechaPattern.matcher(newValue).matches()) {
                MensajeError(LabelError, "mm/yy");
            } else {
                LabelError.setText("");
            }
        });

        // Validación para el campo txtNombre
        Pattern nombrePattern = Pattern.compile("^[A-Z]+$");

        txtNombre.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!nombrePattern.matcher(newValue).matches()) {
                MensajeError(LabelError, "En Mayúsculas");
            } else {
                LabelError.setText("");
            }
        });

        // Validación para el campo txtApellido
        Pattern apellidoPattern = Pattern.compile("^[A-Z]+$");

        txtApellido.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!apellidoPattern.matcher(newValue).matches()) {
                MensajeError(LabelError, "En Mayúsculas");
            } else {
                LabelError.setText("");
            }
        });

        // Validación para el campo txtCVV
        Pattern cvvPattern = Pattern.compile("\\d{3}");

        txtCVV.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!cvvPattern.matcher(newValue).matches()) {
                MensajeError(LabelError, "tres Digitos");
            } else {
                LabelError.setText("");
            }
        });
    }




    // Controla el Boton Almacenar
    public void BotonAlmacenarOnAction(ActionEvent actionEvent) {
        // Patrones de expresiones regulares
        Pattern tipoPattern = Pattern.compile("^(MasterCard|Visa)$");
        Pattern numeroPattern = Pattern.compile("\\d{16}");
        Pattern fechaPattern = Pattern.compile("^(0?[1-9]|1[0-2])/\\d{2}$");
        Pattern nombrePattern = Pattern.compile("^[A-Z]+$");
        Pattern apellidoPattern = Pattern.compile("^[A-Z]+$");
        Pattern cvvPattern = Pattern.compile("\\d{3}");





    }
    // Controla el Boton Buscar
    public void BotonBuscarOnAction(ActionEvent actionEvent) {
    }
}
