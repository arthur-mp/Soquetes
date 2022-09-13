package Utils;

import Interface.CalllBack;
import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    /*
     * Variables
     * */
    Font big = new Font("Serif", Font.BOLD, 30);
    Font small = new Font("Serif", Font.BOLD, 15);
    Font button = new Font("Tahoma", Font.BOLD, 90);

    String[][] table = new String[3][3];

    String player;

    // Type Connection
    JRadioButton optionTCP;
    JRadioButton optionUDP;

    // Type Aplication
    JRadioButton optionServer;
    JRadioButton optionClient;

    // Connection IP
    JButton connectionAplication;

    // Gamer

    JLabel gamer;
    JTextField nameGamer;

    // Address ip
    JTextField ip;

    // Table buttons
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;
    JButton btn6;
    JButton btn7;
    JButton btn8;
    JButton btn9;


    public Window() {
        initComponents();
    }

    private void initComponents() {
        setConfigsWindow();
        // Title
        JLabel header = new JLabel("Aplicação de conexão UDP/TCP");
        add(header);
        header.setFont(big);
        header.setBounds(100, 10, 600, 50);

        // Conexion
        JLabel typeConnection = new JLabel("Tipo de Conexão:");
        add(typeConnection);
        typeConnection.setFont(small);
        typeConnection.setBounds(100, 80, 150, 20);


        ButtonGroup groupTypeConnection = new ButtonGroup();

        optionTCP = new JRadioButton("TCP");
        add(optionTCP);
        optionTCP.setBounds(100, 105, 150, 20);


        optionUDP = new JRadioButton("UDP");
        add(optionUDP);
        optionUDP.setBounds(100, 125, 150, 20);


        groupTypeConnection.add(optionTCP);
        groupTypeConnection.add(optionUDP);

        // Aplication
        JLabel typeApplication = new JLabel("Tipo de Aplicação:");
        add(typeApplication);
        typeApplication.setFont(small);
        typeApplication.setBounds(260, 80, 150, 20);


        ButtonGroup groupTypeApplication = new ButtonGroup();

        optionServer = new JRadioButton("Servidor");
        add(optionServer);
        optionServer.setBounds(260, 105, 150, 20);


        optionClient = new JRadioButton("Cliente");
        add(optionClient);
        optionClient.setBounds(260, 125, 150, 20);


        groupTypeApplication.add(optionServer);
        groupTypeApplication.add(optionClient);

        // Gamer
        gamer = new JLabel("Jogador:");
        add(gamer);
        gamer.setFont(small);
        gamer.setBounds(420, 80, 150, 20);

        nameGamer = new JTextField(30);
        add(nameGamer);
        nameGamer.setBounds(420, 120, 140, 20);
        nameGamer.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        // Host Conexion
        JLabel ipConnection = new JLabel("Ip para Conexão:");
        add(ipConnection);
        ipConnection.setFont(small);
        ipConnection.setBounds(570, 80, 150, 20);

        ip = new JTextField(30);
        add(ip);
        ip.setBounds(570, 120, 140, 20);
        ip.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        connectionAplication = new JButton("Conectar");
        add(connectionAplication);
        connectionAplication.setFont(small);
        connectionAplication.setBounds(570, 150, 140, 20);
        connectionAplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                initializeAplication(actionEvent);
            }
        });


        // Funcionality
        JLabel functionality = new JLabel("Funcionalidade:");
        add(functionality);
        functionality.setFont(small);
        functionality.setBounds(100, 210, 150, 20);


        JLabel typeFunctionality = new JLabel("Jogo da Velha");
        add(typeFunctionality);
        typeFunctionality.setFont(small);
        typeFunctionality.setBounds(350, 210, 150, 20);


        // Buttons

        btn1 = new javax.swing.JButton();
        add(btn1);
        btn1.setFont(button);
        btn1.setBounds(200, 250, 140, 140);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn1ActionPerformed(actionEvent);
            }
        });


        btn2 = new javax.swing.JButton();
        add(btn2);
        btn2.setFont(button);
        btn2.setBounds(350, 250, 140, 140);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn2ActionPerformed(actionEvent);
            }
        });


        btn3 = new javax.swing.JButton();
        add(btn3);
        btn3.setFont(button);
        btn3.setBounds(500, 250, 140, 140);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn3ActionPerformed(actionEvent);
            }
        });


        btn4 = new javax.swing.JButton();
        add(btn4);
        btn4.setFont(button);
        btn4.setBounds(200, 400, 140, 140);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn4ActionPerformed(actionEvent);
            }
        });


        btn5 = new javax.swing.JButton();
        add(btn5);
        btn5.setFont(button);
        btn5.setBounds(350, 400, 140, 140);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn5ActionPerformed(actionEvent);
            }
        });


        btn6 = new javax.swing.JButton();
        add(btn6);
        btn6.setFont(button);
        btn6.setBounds(500, 400, 140, 140);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn6ActionPerformed(actionEvent);
            }
        });


        btn7 = new javax.swing.JButton();
        add(btn7);
        btn7.setFont(button);
        btn7.setBounds(200, 550, 140, 140);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn7ActionPerformed(actionEvent);
            }
        });


        btn8 = new javax.swing.JButton();
        add(btn8);
        btn8.setFont(button);
        btn8.setBounds(350, 550, 140, 140);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn8ActionPerformed(actionEvent);
            }
        });


        btn9 = new javax.swing.JButton();
        add(btn9);
        btn9.setFont(button);
        btn9.setBounds(500, 550, 140, 140);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn9ActionPerformed(actionEvent);
            }
        });


    }//

    private void setConfigsWindow() {
        setTitle("Aplicação de Soquetes");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    private void btn1ActionPerformed(ActionEvent event) {

        if (player == "1") {
            btn1.setText("X");
            btn1.setEnabled(false);
            table[0][0] = "X";
            verifyWinner();
        } else {
            if (player == "2") {
                btn1.setText("O");
                btn1.setEnabled(false);
                table[0][0] = "O";
                verifyWinner();
            }
        }
    }

    private void btn2ActionPerformed(ActionEvent event) {

        if (player == "1") {
            btn2.setText("X");
            btn2.setEnabled(false);
            table[0][1] = "X";
            verifyWinner();
        } else {
            if (player == "2") {
                btn2.setText("O");
                btn2.setEnabled(false);
                table[0][1] = "O";
                verifyWinner();
            }
        }
    }

    private void btn3ActionPerformed(ActionEvent event) {

        if (player == "1") {
            btn3.setText("X");
            btn3.setEnabled(false);
            table[0][2] = "X";
            verifyWinner();
        } else {
            if (player == "2") {
                btn3.setText("O");
                btn3.setEnabled(false);
                table[0][2] = "O";
                verifyWinner();
            }
        }
    }

    private void btn4ActionPerformed(ActionEvent event) {

        if (player == "1") {
            btn4.setText("X");
            btn4.setEnabled(false);
            table[1][0] = "X";
            verifyWinner();
        } else {
            if (player == "2") {
                btn4.setText("O");
                btn4.setEnabled(false);
                table[1][0] = "O";
                verifyWinner();
            }
        }
    }

    private void btn5ActionPerformed(ActionEvent event) {

        if (player == "1") {
            btn5.setText("X");
            btn5.setEnabled(false);
            table[1][1] = "X";
            verifyWinner();
        } else {
            if (player == "2") {
                btn5.setText("O");
                btn5.setEnabled(false);
                table[1][1] = "O";
                verifyWinner();
            }
        }
    }

    private void btn6ActionPerformed(ActionEvent event) {

        if (player == "1") {
            btn6.setText("X");
            btn6.setEnabled(false);
            table[1][2] = "X";
            verifyWinner();
        } else {
            if (player == "2") {
                btn6.setText("O");
                btn6.setEnabled(false);
                table[1][2] = "O";
                verifyWinner();
            }
        }
    }

    private void btn7ActionPerformed(ActionEvent event) {

        if (player == "1") {
            btn7.setText("X");
            btn7.setEnabled(false);
            table[2][0] = "X";
            verifyWinner();
        } else {
            if (player == "2") {
                btn7.setText("O");
                btn7.setEnabled(false);
                table[2][0] = "O";
                verifyWinner();
            }
        }
    }

    private void btn8ActionPerformed(ActionEvent event) {

        if (player == "1") {
            btn8.setText("X");
            btn8.setEnabled(false);
            table[2][1] = "X";
            verifyWinner();
        } else {
            if (player == "2") {
                btn8.setText("O");
                btn8.setEnabled(false);
                table[2][1] = "O";
                verifyWinner();
            }
        }
    }

    private void btn9ActionPerformed(ActionEvent event) {

        if (player == "1") {
            btn9.setText("X");
            btn9.setEnabled(false);
            table[2][2] = "X";
            verifyWinner();
        } else {
            if (player == "2") {
                btn9.setText("O");
                btn9.setEnabled(false);
                table[2][2] = "O";
                verifyWinner();
            }
        }
    }

    private void initializeAplication(ActionEvent event) {
        if (getOptionConnection() == null) {
            this.alertMessage("É preciso informar um tipo de conexão!");
        } else {
            if (getAplicationConnection() == null) {
                this.alertMessage("É preciso informar um tipo de Aplicação!");
            } else {
                if (getAplicationConnection() == "Server") {
                    this.setIpConnection("127.0.0.1");
                    startCallBack();
                } else {
                    if (this.nameGamer.getText().isEmpty()) {
                        this.alertMessage("É preciso informar um nome!");
                    } else {
                        if (this.ip.getText().isEmpty()) {
                            this.alertMessage("É preciso informar um Ip!");
                        } else {
                            startCallBack();
                        }
                    }
                }

            }
        }
    }

    private void startCallBack() {
        connectionAplication.setEnabled(false);
        CalllBack calllBack = new Main();
        register(calllBack);
    }

    public void register(CalllBack calllBack) {
        calllBack.methodToCallBack();
    }

    private void verifyWinner() {
        //Check Lines
        for (int i = 0; i < 3; i++) {
            if (table[i][0] == "X" && table[i][1] == "X" && table[i][2] == "X") {
                JOptionPane.showMessageDialog(null, nameGamer + " ganhador!!!");
                ResetTable();
            }
            if (table[i][0] == "O" && table[i][1] == "O" && table[i][2] == "O") {
                JOptionPane.showMessageDialog(null, nameGamer + " ganhador!!!");
                ResetTable();
            }
        }

        //Check Columns
        for (int i = 0; i < 3; i++) {
            if (table[0][i] == "X" && table[1][i] == "X" && table[2][i] == "X") {
                JOptionPane.showMessageDialog(null, nameGamer + " ganhador!!!");
                ResetTable();
            }
            if (table[0][i] == "O" && table[1][i] == "O" && table[2][i] == "O") {
                JOptionPane.showMessageDialog(null, nameGamer + " ganhador!!!");
                ResetTable();
            }
        }

        //Check Main Diagonal
        if (table[0][0] == "X" && table[1][1] == "X" && table[2][2] == "X") {
            JOptionPane.showMessageDialog(null, nameGamer + " ganhador!!!");
            ResetTable();
        }
        if (table[0][0] == "O" && table[1][1] == "O" && table[2][2] == "O") {
            JOptionPane.showMessageDialog(null, nameGamer + " ganhador!!!");
            ResetTable();
        }

        //Check Secondary Diagonal
        if (table[0][2] == "X" && table[1][1] == "X" && table[2][0] == "X") {
            JOptionPane.showMessageDialog(null, nameGamer + " ganhador!!!");
            ResetTable();
        }
        if (table[0][2] == "O" && table[1][1] == "O" && table[2][0] == "O") {
            JOptionPane.showMessageDialog(null, nameGamer + " ganhador!!!");
            ResetTable();
        }

        verifyLoss();
    }

    private void verifyLoss() {
        boolean loss = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == null) {
                    loss = false;
                }
            }
        }

        if (loss) {
            JOptionPane.showMessageDialog(null, "VELHA! :(");
            ResetTable();
        }
    }

    public void ResetTable() {
        btn1.setText(null);
        btn1.setEnabled(true);
        btn2.setText(null);
        btn2.setEnabled(true);
        btn3.setText(null);
        btn3.setEnabled(true);
        btn4.setText(null);
        btn4.setEnabled(true);
        btn5.setText(null);
        btn5.setEnabled(true);
        btn6.setText(null);
        btn6.setEnabled(true);
        btn7.setText(null);
        btn7.setEnabled(true);
        btn8.setText(null);
        btn8.setEnabled(true);
        btn9.setText(null);
        btn9.setEnabled(true);

        table = new String[3][3];
    }

    public void disabledTable() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }

    public void enableTable() {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
    }

    private void updateTable() {
        if (table[0][0] != null) {
            btn1.setText(table[0][0]);
            btn1.setEnabled(false);
        }
        if (table[0][1] != null) {
            btn2.setText(table[0][1]);
            btn2.setEnabled(false);
        }
        if (table[0][2] != null) {
            btn3.setText(table[0][2]);
            btn3.setEnabled(false);
        }
        if (table[1][0] != null) {
            btn4.setText(table[1][0]);
            btn4.setEnabled(false);
        }
        if (table[1][1] != null) {
            btn5.setText(table[1][1]);
            btn5.setEnabled(false);
        }
        if (table[1][2] != null) {
            btn6.setText(table[1][2]);
            btn6.setEnabled(false);
        }
        if (table[2][0] != null) {
            btn7.setText(table[2][0]);
            btn7.setEnabled(false);
        }
        if (table[2][1] != null) {
            btn8.setText(table[2][1]);
            btn8.setEnabled(false);
        }
        if (table[2][2] != null) {
            btn9.setText(table[2][2]);
            btn9.setEnabled(false);
        }

    }

    private void setIpConnection(String address) {
        this.ip.setText(address);
        this.ip.setEditable(false);
    }

    public String getIpConnection() {
        return this.ip.getText();
    }

    public void alertMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public String getOptionConnection() {
        if (this.optionTCP.isSelected()) {
            return "TCP";
        }
        if (this.optionUDP.isSelected()) {
            return "UDP";
        }
        return null;
    }

    public String getAplicationConnection() {
        if (this.optionServer.isSelected()) {
            return "Server";
        }
        if (this.optionClient.isSelected()) {
            return "Client";
        }
        return null;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getNameGamer(){
        return this.nameGamer.getText();
    }
    public void isServer() {
        disabledTable();
        nameGamer.setText("Servidor");
        nameGamer.setEditable(false);
        disableOptionsConnections();
        alertMessage("Servidor Inicializado");
    }

    public void isClient(String name){
        disabledTable();
        nameGamer.setText(name);
        nameGamer.setEditable(false);
        ip.setEditable(false);
        disableOptionsConnections();
        alertMessage(name + " conectado ao servidor!");
    }
    private void disableOptionsConnections(){
        optionClient.setEnabled(false);
        optionServer.setEnabled(false);
        optionTCP.setEnabled(false);
        optionUDP.setEnabled(false);
    }
}