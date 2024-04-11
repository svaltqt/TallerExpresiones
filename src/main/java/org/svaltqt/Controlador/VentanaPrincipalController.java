package org.svaltqt.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import org.svaltqt.Modelo.TarjetaCredito;

import java.util.ArrayList;
import java.util.List;
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
    List<TarjetaCredito> listaTarjetas = new ArrayList<>();
    List<TarjetaCredito> listaVisa = new ArrayList<>();
    List<TarjetaCredito> listaMasterCard = new ArrayList<>();



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

        TarjetaCredito tarjeta = new TarjetaCredito();

        // Patrones de expresiones regulares
        Pattern tipoPattern = Pattern.compile("^(MasterCard|Visa)$");
        Pattern numeroPattern = Pattern.compile("\\d{16}");
        Pattern fechaPattern = Pattern.compile("^(0?[1-9]|1[0-2])/\\d{2}$");
        Pattern nombrePattern = Pattern.compile("^[A-Z]+$");
        Pattern apellidoPattern = Pattern.compile("^[A-Z]+$");
        Pattern cvvPattern = Pattern.compile("\\d{3}");

        // esto se va usar para la discriminacion de los arraylist jeje
        Pattern visaPattern = Pattern.compile("^Visa$");
        Pattern masterCardPattern = Pattern.compile("^MasterCard$");


        // Validar el campo txtTipo
        if (!tipoPattern.matcher(txtTipo.getText()).matches()) {
            return;
        } else tarjeta.setTipo(txtTipo.getText());

        // Validar el campo txtNumero
        if (!numeroPattern.matcher(txtNumero.getText()).matches()) {
            return;
        } else  tarjeta.setNumero(txtNumero.getText());

        // Validar el campo txtFecha
        if (!fechaPattern.matcher(txtFecha.getText()).matches()) {
            return;
        } else tarjeta.setFecha(txtFecha.getText());

        // Validar el campo txtNombre
        if (!nombrePattern.matcher(txtNombre.getText()).matches()) {
            return;
        } else tarjeta.setNombre(txtNombre.getText());

        // Validar el campo txtApellido
        if (!apellidoPattern.matcher(txtApellido.getText()).matches()) {
            return;
        } else tarjeta.setApellido(txtApellido.getText());

        // Validar el campo txtCVV
        if (!cvvPattern.matcher(txtCVV.getText()).matches()) {
            return;
        }   else tarjeta.setCvv(Integer.parseInt(txtCVV.getText()));

        listaTarjetas.add(tarjeta);
        listaVisa.clear();
        listaMasterCard.clear();

        for (TarjetaCredito t : listaTarjetas) {
            System.out.println(t.toString());
                if (visaPattern.matcher(t.getTipo()).matches()) {
                listaVisa.add(t);
            }
            else
                if (masterCardPattern.matcher(t.getTipo()).matches()) {
                listaMasterCard.add(t);
            }
        }

        // Imprimir las tarjetas Visa
        System.out.println("Tarjetas Visa:");
        for (TarjetaCredito visa : listaVisa) {
            System.out.println(visa.toString());
        }

        // Imprimir las tarjetas MasterCard
        System.out.println("Tarjetas MasterCard:");
        for (TarjetaCredito masterCard : listaMasterCard) {
            System.out.println(masterCard.toString());
        }


        // Limpiar Campos
        txtTipo.setText("");
        txtFecha.setText("");
        txtNumero.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtCVV.setText("");
        LabelError.setText("");



    }
    // Controla el Boton Buscar
    public void BotonBuscarOnAction(ActionEvent actionEvent) {
    }
}
