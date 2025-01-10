package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JogoDaForca extends Application {
    private String palavraAtual;
    private String dicaAtual;
    private List<String[]> palavrasEDicas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carregue o arquivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TelaInicial.fxml"));
        Parent root = loader.load();

        // Crie a cena
        Scene scene = new Scene(root);

        // Adicione o CSS, se necessário
        scene.getStylesheets().add(getClass().getResource("/css/telainicial.css").toExternalForm());

        // Configure o Stage (janela)
        primaryStage.setTitle("Jogo da Forca");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Carrega o tema a partir de um arquivo TXT.
     * O arquivo deve ter a primeira linha como o nome do tema,
     * seguido por linhas no formato "palavra;dica".
     *
     * @param caminhoArquivo O caminho do arquivo TXT do tema.
     * @throws IOException Se houver erro ao ler o arquivo.
     */
    public void carregarTema(String caminhoArquivo) throws IOException {
        palavrasEDicas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            // Ignora a primeira linha (nome do tema)
            br.readLine();

            // Lê as palavras e dicas
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 2) {
                    palavrasEDicas.add(partes);
                }
            }
        }

        // Seleciona aleatoriamente uma palavra e dica
        if (!palavrasEDicas.isEmpty()) {
            Random random = new Random();
            String[] selecionado = palavrasEDicas.get(random.nextInt(palavrasEDicas.size()));
            palavraAtual = selecionado[0];
            dicaAtual = selecionado[1];
        } else {
            palavraAtual = null;
            dicaAtual = null;
        }
    }

    /**
     * Reinicia o jogo selecionando uma nova palavra e dica do mesmo tema.
     */
    public void reiniciarJogo() {
        if (palavrasEDicas != null && !palavrasEDicas.isEmpty()) {
            Random random = new Random();
            String[] selecionado = palavrasEDicas.get(random.nextInt(palavrasEDicas.size()));
            palavraAtual = selecionado[0];
            dicaAtual = selecionado[1];
        } else {
            palavraAtual = null;
            dicaAtual = null;
        }
    }

    public static void main(String[] args) {
        launch(args); // Inicia o JavaFX
    }
}
