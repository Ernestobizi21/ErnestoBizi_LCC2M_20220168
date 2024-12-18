package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorView extends JFrame {
    private JTable tabela;
    private DefaultTableModel modelo;

    public ProfessorView() {
        setTitle("Gerenciar Notas - Professor");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        String[] colunas = {"Nome", "Matrícula", "Português", "Matemática", "Estudo do Meio", "Música", "Plástica"};
        modelo = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modelo);
        JScrollPane pane = new JScrollPane(tabela);
        pane.setBounds(20, 20, 550, 250);
        add(pane);

        // Botão Adicionar
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(50, 300, 100, 30);
        add(btnAdicionar);

        // Botão Remover
        JButton btnRemover = new JButton("Remover");
        btnRemover.setBounds(170, 300, 100, 30);
        add(btnRemover);

        // Botão Gravar
        JButton btnGravar = new JButton("Gravar");
        btnGravar.setBounds(290, 300, 100, 30);
        add(btnGravar);

        // Botão Terminar Sessão
        JButton btnTerminarSessao = new JButton("Terminar Sessão");
        btnTerminarSessao.setBounds(410, 300, 140, 30);
        add(btnTerminarSessao);

        // Evento para adicionar uma nova linha
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.addRow(new Object[]{"Novo Aluno", "000", 0, 0, 0, 0, 0});
            }
        });

        // Evento para remover a linha selecionada
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada != -1) {
                    modelo.removeRow(linhaSelecionada);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma linha para remover!");
                }
            }
        });

        // Evento para gravar as notas (simulação)
        btnGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Notas gravadas com sucesso!");
            }
        });

        // Evento para terminar sessão
        btnTerminarSessao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela atual
                new LoginView().setVisible(true); // Retorna para a tela de login
            }
        });
    }
}
