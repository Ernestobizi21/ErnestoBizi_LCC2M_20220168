package view;

import model.Aluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginView extends JFrame {
    private JTextField txtUsuario;
    private JTextField txtMatricula;
    private JPasswordField txtSenha;
    private JButton btnLogin;

    // Lista de Alunos
    private ArrayList<Aluno> alunos;

    public LoginView() {
        setTitle("LOGIN - GESTAO DE NOTAS");
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(Color.RED);

        // Adicionando alunos estáticos
        alunos = new ArrayList<>();
        alunos.add(new Aluno("001", "João", 10, 9, 10, 6, 8));
        alunos.add(new Aluno("002", "Maria", 9, 8, 7, 9, 8));
        alunos.add(new Aluno("003", "Pedro", 7, 10, 10, 5, 9));
        alunos.add(new Aluno("004", "Ana", 8, 7, 9, 10, 7));
        alunos.add(new Aluno("005", "Lucas", 10, 8, 9, 10, 4));

        JLabel lblUsuario = new JLabel("Nome:");
        lblUsuario.setBounds(30, 30, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(110, 30, 130, 25);
        add(txtUsuario);

        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setBounds(30, 70, 80, 25);
        add(lblMatricula);

        txtMatricula = new JTextField();
        txtMatricula.setBounds(110, 70, 130, 25);
        add(txtMatricula);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(30, 110, 80, 25);
        add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(110, 110, 130, 25);
        add(txtSenha);

        btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(90, 160, 100, 30);
        add(btnLogin);

        // Evento de Login
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtUsuario.getText();
                String matricula = txtMatricula.getText();
                String senha = new String(txtSenha.getPassword());

                // Login como Professor
                if (nome.equalsIgnoreCase("professor") && senha.equals("1234")) {
                    dispose();
                    new ProfessorView().setVisible(true);
                    return;
                }

                // Login como Aluno
                for (Aluno aluno : alunos) {
                    if (aluno.getNome().equalsIgnoreCase(nome) && aluno.getMatricula().equals(matricula)) {
                        dispose();
                        new AlunoView(aluno).setVisible(true);
                        return;
                    }
                }

                JOptionPane.showMessageDialog(null, "Nome, matrícula ou senha incorretos!");
            }
        });
    }
}
