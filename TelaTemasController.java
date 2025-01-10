package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelaTemasController {

    @FXML
    private CheckBox cbAnimais;
    @FXML
    private CheckBox cbAlimentos;
    @FXML
    private CheckBox cbDiversos;
    @FXML
    private CheckBox cbEsportes;
    @FXML
    private CheckBox cbNovelas;
    @FXML
    private CheckBox cbObjetos;
    @FXML
    private CheckBox cbPC;
    @FXML
    private CheckBox cbProfissoes;
    @FXML
    private Button btnIniciar;

    @FXML
    public void initialize() {
        btnIniciar.setOnAction(e -> {
            System.out.println("Temas selecionados:");
            if (cbAnimais.isSelected())
                System.out.println("Tema 1 ");
            if (cbAlimentos.isSelected())
                System.out.println("Tema 2");
            if (cbDiversos.isSelected())
                System.out.println("Tema 3");
            if (cbEsportes.isSelected())
                System.out.println("Tema 4");
            if (cbNovelas.isSelected())
                System.out.println("Tema 5");
            if (cbObjetos.isSelected())
                System.out.println("Tema 6");
            if (cbPC.isSelected())
                System.out.println("Tema 7");
            if (cbProfissoes.isSelected())
                System.out.println("Tema 8");
        });
    }

    public void iniciarJogo() {
        // Inicializa o mapa de palavras por tema dentro deste método
        Map<String, List<String>> palavrasPorTema = new HashMap<>();
        palavrasPorTema.put("Animais", new ArrayList<String>() {
            {
                add("Cachorro");
                add("Gato");
                add("Elefante");
            }
        });
        palavrasPorTema.put("Alimentos", new ArrayList<String>() {
            {
                add("Arroz");
                add("Feijão");
                add("Pizza");
            }
        });
        palavrasPorTema.put("Diversos", new ArrayList<String>() {
            {
                add("Mesa");
                add("Árvore");
                add("Lâmpada");
            }
        });
        palavrasPorTema.put("Esportes", new ArrayList<String>() {
            {
                add("Futebol");
                add("Basquete");
                add("Vôlei");
            }
        });
        palavrasPorTema.put("Novelas", new ArrayList<String>() {
            {
                add("Amor");
                add("Segredo");
                add("Destino");
            }
        });
        palavrasPorTema.put("Objetos", new ArrayList<String>() {
            {
                add("Copo");
                add("Cadeira");
                add("Telefone");
            }
        });
        palavrasPorTema.put("PC", new ArrayList<String>() {
            {
                add("Teclado");
                add("Mouse");
                add("Monitor");
            }
        });
        palavrasPorTema.put("Profissões", new ArrayList<String>() {
            {
                add("Médico");
                add("Engenheiro");
                add("Professor");
            }
        });
        // Obtém os temas selecionados
        List<String> temasSelecionados = selecionarTema();

        // Carrega as palavras associadas aos temas selecionados
        List<String> palavrasParaOJogo = new ArrayList<>();
        for (String tema : temasSelecionados) {
            palavrasParaOJogo.addAll(palavrasPorTema.getOrDefault(tema, new ArrayList<>()));
        }

        // Exibe os temas e as palavras selecionadas no console (para teste)
        System.out.println("Temas selecionados: " + temasSelecionados);
        System.out.println("Palavras para o jogo: " + palavrasParaOJogo);

        // Lógica de navegação para outra tela pode ser adicionada aqui
    }

    public List<String> selecionarTema() {
        List<String> temasSelecionados = new ArrayList<>();

        if (cbAnimais.isSelected()) temasSelecionados.add("Animais");
        if (cbAlimentos.isSelected()) temasSelecionados.add("Alimentos");
        if (cbDiversos.isSelected()) temasSelecionados.add("Diversos");
        if (cbEsportes.isSelected()) temasSelecionados.add("Esportes");
        if (cbNovelas.isSelected()) temasSelecionados.add("Novelas");
        if (cbObjetos.isSelected()) temasSelecionados.add("Objetos");
        if (cbPC.isSelected()) temasSelecionados.add("PC");
        if (cbProfissoes.isSelected()) temasSelecionados.add("Profissões");

        return temasSelecionados;
    }
}