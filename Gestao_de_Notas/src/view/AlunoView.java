package view;

import model.Aluno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlunoView extends JFrame {
    private JTable tabela;
    private DefaultTableModel modelo;

    public AlunoView(Aluno aluno) {
        setTitle("Notas do Aluno");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Notas de: " + aluno.getNome());
        lblTitulo.setBounds(20, 10, 300, 25);
        add(lblTitulo);

        String[] colunas = {"Disciplina", "Nota"};
        modelo = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modelo);
        JScrollPane pane = new JScrollPane(tabela);
        pane.setBounds(20, 50, 450, 250);
        add(pane);

        // Adicionar as notas
        modelo.addRow(new Object[]{"Português", aluno.getPortugues()});
        modelo.addRow(new Object[]{"Matemática", aluno.getMatematica()});
        modelo.addRow(new Object[]{"Estudo do Meio", aluno.getEstudoDoMeio()});
        modelo.addRow(new Object[]{"Educação Musical", aluno.getEducacaoMusical()});
        modelo.addRow(new Object[]{"Educação Plástica", aluno.getEducacaoPlastica()});

        // Botão Terminar Sessão
        JButton btnTerminarSessao = new JButton("Terminar Sessão");
        btnTerminarSessao.setBounds(180, 320, 140, 30);
        add(btnTerminarSessao);

        btnTerminarSessao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela atual
                new LoginView().setVisible(true); // Retorna para a tela de login
            }
        });
    }
}
