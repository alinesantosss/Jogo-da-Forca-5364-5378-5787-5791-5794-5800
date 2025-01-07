package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TelaDicasController {

    @FXML
    private Label dica; // Label para exibir a dica

    /**
     * Atualiza o texto do Label com a dica fornecida.
     * @param dicaTexto Texto da dica a ser exibido.
     */
    public void exibirDica(String dicaTexto) {
        if (dicaTexto != null && !dicaTexto.isEmpty()) {
            dica.setText("Dica: " + dicaTexto);
        } else {
            dica.setText("Nenhuma dica disponível.");
        }
    }
}