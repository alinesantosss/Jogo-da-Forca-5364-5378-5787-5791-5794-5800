/*
/*
 * TelaPerdeuController.java
 * Controlador da tela de derrota do jogo da forca.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import principal.JogoDaForca; // Classe principal do jogo que controla a lógica principal.

/**
 * Controlador da tela de derrota (TelaPerdeu).
 */
public class TelaPerdeuController implements Initializable {

    @FXML
    private Button botaoRecomecar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //funcao caso fosse pra sair pro menu em vez de reiniciar , porem nao temos esse botao
    }

    /**
     * Evento acionado ao clicar no botão "Recomeçar".
     *
     * @param event Evento do clique.
     */
    @FXML
    private void handleBotaoRecomecar(ActionEvent event) {
        reiniciarPalavra(); // Chama a função que reinicia o jogo com a mesma palavra.
    }


    private void reiniciarPalavra() {
        // Obtém o controlador principal do jogo.
        JogoDaForca controladorPrincipal = JogoDaForca.getInstancia();

        if (controladorPrincipal != null) {
            controladorPrincipal.reiniciarJogo(); //Chama o método para reiniciar o jogo , que ta na classe principal
        } else {
            System.err.println("Erro: Não foi possível acessar o controlador principal do jogo.");
        }
    }
}