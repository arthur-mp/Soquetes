package Utils;

import Interface.Aplication;
import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Window  {

    /*
     * Variables
     * */
    JFrame jFrame = new JFrame();
    Font big = new Font("Serif", Font.BOLD, 30);
    Font small = new Font("Serif", Font.BOLD, 15);
    Font button = new Font("Tahoma", Font.BOLD, 90);

    String[][] table = new String[3][3];

    String player;
    String played = "";

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
        jFrame.add(header);
        header.setFont(big);
        header.setBounds(100, 10, 600, 50);

        // Conexion
        JLabel typeConnection = new JLabel("Tipo de Conexão:");
        jFrame.add(typeConnection);
        typeConnection.setFont(small);
        typeConnection.setBounds(100, 80, 150, 20);


        ButtonGroup groupTypeConnection = new ButtonGroup();

        optionTCP = new JRadioButton("TCP");
        jFrame.add(optionTCP);
        optionTCP.setBounds(100, 105, 150, 20);


        optionUDP = new JRadioButton("UDP");
        jFrame.add(optionUDP);
        optionUDP.setBounds(100, 125, 150, 20);


        groupTypeConnection.add(optionTCP);
        groupTypeConnection.add(optionUDP);

        // Aplication
        JLabel typeApplication = new JLabel("Tipo de Aplicação:");
        jFrame.add(typeApplication);
        typeApplication.setFont(small);
        typeApplication.setBounds(260, 80, 150, 20);


        ButtonGroup groupTypeApplication = new ButtonGroup();

        optionServer = new JRadioButton("Servidor");
        jFrame.add(optionServer);
        optionServer.setBounds(260, 105, 150, 20);


        optionClient = new JRadioButton("Cliente");
        jFrame.add(optionClient);
        optionClient.setBounds(260, 125, 150, 20);


        groupTypeApplication.add(optionServer);
        groupTypeApplication.add(optionClient);

        // Gamer
        gamer = new JLabel("Jogador:");
        jFrame.add(gamer);
        gamer.setFont(small);
        gamer.setBounds(420, 80, 150, 20);

        nameGamer = new JTextField(30);
        jFrame.add(nameGamer);
        nameGamer.setBounds(420, 120, 140, 20);
        nameGamer.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        // Host Conexion
        JLabel ipConnection = new JLabel("Ip para Conexão:");
        jFrame.add(ipConnection);
        ipConnection.setFont(small);
        ipConnection.setBounds(570, 80, 150, 20);

        ip = new JTextField(30);
        jFrame.add(ip);
        ip.setBounds(570, 120, 140, 20);
        ip.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        connectionAplication = new JButton("Conectar");
        jFrame.add(connectionAplication);
        connectionAplication.setFont(small);
        connectionAplication.setBounds(570, 150, 140, 20);
        connectionAplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                initializeAplication();
            }
        });


        // Funcionality
        JLabel functionality = new JLabel("Funcionalidade:");
        jFrame.add(functionality);
        functionality.setFont(small);
        functionality.setBounds(100, 210, 150, 20);


        JLabel typeFunctionality = new JLabel("Jogo da Velha");
        jFrame.add(typeFunctionality);
        typeFunctionality.setFont(small);
        typeFunctionality.setBounds(350, 210, 150, 20);


        // Buttons

        btn1 = new javax.swing.JButton();
        jFrame.add(btn1);
        btn1.setFont(button);
        btn1.setBounds(200, 250, 140, 140);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn1ActionPerformed();
            }
        });


        btn2 = new javax.swing.JButton();
        jFrame.add(btn2);
        btn2.setFont(button);
        btn2.setBounds(350, 250, 140, 140);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn2ActionPerformed();
            }
        });


        btn3 = new javax.swing.JButton();
        jFrame.add(btn3);
        btn3.setFont(button);
        btn3.setBounds(500, 250, 140, 140);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn3ActionPerformed();
            }
        });


        btn4 = new javax.swing.JButton();
        jFrame.add(btn4);
        btn4.setFont(button);
        btn4.setBounds(200, 400, 140, 140);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn4ActionPerformed();
            }
        });


        btn5 = new javax.swing.JButton();
        jFrame.add(btn5);
        btn5.setFont(button);
        btn5.setBounds(350, 400, 140, 140);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn5ActionPerformed();
            }
        });


        btn6 = new javax.swing.JButton();
        jFrame.add(btn6);
        btn6.setFont(button);
        btn6.setBounds(500, 400, 140, 140);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn6ActionPerformed();
            }
        });


        btn7 = new javax.swing.JButton();
        jFrame.add(btn7);
        btn7.setFont(button);
        btn7.setBounds(200, 550, 140, 140);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn7ActionPerformed();
            }
        });


        btn8 = new javax.swing.JButton();
        jFrame.add(btn8);
        btn8.setFont(button);
        btn8.setBounds(350, 550, 140, 140);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn8ActionPerformed();
            }
        });


        btn9 = new javax.swing.JButton();
        jFrame.add(btn9);
        btn9.setFont(button);
        btn9.setBounds(500, 550, 140, 140);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn9ActionPerformed();
            }
        });


    }//

    private void setConfigsWindow() {
        jFrame.setTitle("Aplicação de Soquetes");
        jFrame.setSize(800, 800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    private void btn1ActionPerformed() {

        if (Objects.equals(player, "1")) {
            btn1.setText("X");
            btn1.setEnabled(false);
            table[0][0] = "X";
            played = "00X";
            verifyWinner();
        } else {
            if (Objects.equals(player, "2")) {
                btn1.setText("O");
                btn1.setEnabled(false);
                table[0][0] = "O";
                played = "00O";
                verifyWinner();
            }
        }
    }

    private void btn2ActionPerformed() {

        if (Objects.equals(player, "1")) {
            btn2.setText("X");
            btn2.setEnabled(false);
            table[0][1] = "X";
            played = "01X";
            verifyWinner();
        } else {
            if (Objects.equals(player, "2")) {
                btn2.setText("O");
                btn2.setEnabled(false);
                table[0][1] = "O";
                played = "01O";
                verifyWinner();
            }
        }
    }

    private void btn3ActionPerformed() {

        if (Objects.equals(player, "1")) {
            btn3.setText("X");
            btn3.setEnabled(false);
            table[0][2] = "X";
            played = "02X";
            verifyWinner();
        } else {
            if (Objects.equals(player, "2")) {
                btn3.setText("O");
                btn3.setEnabled(false);
                table[0][2] = "O";
                played = "02O";
                verifyWinner();
            }
        }
    }

    private void btn4ActionPerformed() {

        if (Objects.equals(player, "1")) {
            btn4.setText("X");
            btn4.setEnabled(false);
            table[1][0] = "X";
            played = "10X";
            verifyWinner();
        } else {
            if (Objects.equals(player, "2")) {
                btn4.setText("O");
                btn4.setEnabled(false);
                table[1][0] = "O";
                played = "10O";
                verifyWinner();
            }
        }
    }

    private void btn5ActionPerformed() {

        if (Objects.equals(player, "1")) {
            btn5.setText("X");
            btn5.setEnabled(false);
            table[1][1] = "X";
            played = "11X";
            verifyWinner();
        } else {
            if (Objects.equals(player, "2")) {
                btn5.setText("O");
                btn5.setEnabled(false);
                table[1][1] = "O";
                played = "11O";
                verifyWinner();
            }
        }
    }

    private void btn6ActionPerformed() {

        if (Objects.equals(player, "1")) {
            btn6.setText("X");
            btn6.setEnabled(false);
            table[1][2] = "X";
            played = "12X";
            verifyWinner();
        } else {
            if (Objects.equals(player, "2")) {
                btn6.setText("O");
                btn6.setEnabled(false);
                table[1][2] = "O";
                played = "12O";
                verifyWinner();
            }
        }
    }

    private void btn7ActionPerformed() {

        if (Objects.equals(player, "1")) {
            btn7.setText("X");
            btn7.setEnabled(false);
            table[2][0] = "X";
            played = "20X";
            verifyWinner();
        } else {
            if (Objects.equals(player, "2")) {
                btn7.setText("O");
                btn7.setEnabled(false);
                table[2][0] = "O";
                played = "20O";
                verifyWinner();
            }
        }
    }

    private void btn8ActionPerformed() {

        if (Objects.equals(player, "1")) {
            btn8.setText("X");
            btn8.setEnabled(false);
            table[2][1] = "X";
            played = "21X";
            verifyWinner();
        } else {
            if (Objects.equals(player, "2")) {
                btn8.setText("O");
                btn8.setEnabled(false);
                table[2][1] = "O";
                played = "21O";
                verifyWinner();
            }
        }
    }

    private void btn9ActionPerformed() {

        if (Objects.equals(player, "1")) {
            btn9.setText("X");
            btn9.setEnabled(false);
            table[2][2] = "X";
            played = "22X";
            verifyWinner();
        } else {
            if (Objects.equals(player, "2")) {
                btn9.setText("O");
                btn9.setEnabled(false);
                table[2][2] = "O";
                played = "22O";
                verifyWinner();
            }
        }
    }

    private void initializeAplication() {
        if (getOptionConnection() == null) {
            alertMessage("É preciso informar um tipo de conexão!");
        } else {
            if (getAplicationConnection() == null) {
                alertMessage("É preciso informar um tipo de Aplicação!");
            } else {
                if (getAplicationConnection() == "Server") {
                    setIpConnection("127.0.0.1");
                    startAplication();
                } else {
                    if (nameGamer.getText().isEmpty()) {
                        alertMessage("É preciso informar um nome!");
                    } else {
                        if (ip.getText().isEmpty()) {
                            alertMessage("É preciso informar um Ip!");
                        } else {
                            startAplication();
                        }
                    }
                }

            }
        }
    }

    private void sendMove(){
        Aplication inOut = new Main();
        inOut.sendClient();
    }

    private void startAplication() {
        connectionAplication.setEnabled(false);
        Aplication aplication = new Main();
        aplication.initialize();
    }

    private void verifyWinner() {
        //Check Lines
        for (int i = 0; i < 3; i++) {
            if (table[i][0] == "X" && table[i][1] == "X" && table[i][2] == "X") {
                JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
                endOfTheGame();
            }
            if (table[i][0] == "O" && table[i][1] == "O" && table[i][2] == "O") {
                JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
                endOfTheGame();
            }
        }

        //Check Columns
        for (int i = 0; i < 3; i++) {
            if (table[0][i] == "X" && table[1][i] == "X" && table[2][i] == "X") {
                JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
                endOfTheGame();
            }
            if (table[0][i] == "O" && table[1][i] == "O" && table[2][i] == "O") {
                JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
                endOfTheGame();
            }
        }

        //Check Main Diagonal
        if (table[0][0] == "X" && table[1][1] == "X" && table[2][2] == "X") {
            JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
            endOfTheGame();
        }
        if (table[0][0] == "O" && table[1][1] == "O" && table[2][2] == "O") {
            JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
            endOfTheGame();
        }

        //Check Secondary Diagonal
        if (table[0][2] == "X" && table[1][1] == "X" && table[2][0] == "X") {
            JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
            endOfTheGame();
        }
        if (table[0][2] == "O" && table[1][1] == "O" && table[2][0] == "O") {
            JOptionPane.showMessageDialog(null, nameGamer.getText() + " ganhador!!!");
            endOfTheGame();
        }

        verifyLoss();
    }

    private void verifyLoss() {
        if(!played.equals(Messages.FINISH.getValueString())){
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
                endOfTheGame();
            }
        }

        sendMove();
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

    public void updateTable(String coordinates) {
        enableTable();
        String[] values = coordinates.split("");
        int x = Integer.parseInt(values[0]);
        int y = Integer.parseInt(values[1]);
        if (table[x][y] == null) {
            table[x][y] = values[2];
            updateTableButtons();
        }
    }
    private void updateTableButtons() {
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
        ip.setText(address);
        ip.setEditable(false);
    }

    public String getIpConnection() {
        return ip.getText();
    }

    public void alertMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public String getOptionConnection() {
        if (optionTCP.isSelected()) {
            return "TCP";
        }
        if (optionUDP.isSelected()) {
            return "UDP";
        }
        return null;
    }

    public String getAplicationConnection() {
        if (optionServer.isSelected()) {
            return "Server";
        }
        if (optionClient.isSelected()) {
            return "Client";
        }
        return null;
    }

    public void endOfTheGame(){
        played = Messages.FINISH.getValueString();
    }
    public void resetPlayed(){
        played = "";
    }

    public String getPlayed(){
        return played;
    }


    public void isServer() {
        disabledTable();
        nameGamer.setText("Servidor");
        nameGamer.setEditable(false);
        disableOptionsConnections();
        alertMessage("Servidor Inicializado");
    }

    public void isClient(String idPlayer){
        disabledTable();
        nameGamer.setEditable(false);
        player = idPlayer;
        ip.setEditable(false);
        disableOptionsConnections();
        alertMessage(nameGamer.getText() + " conectado ao servidor!");
    }
    private void disableOptionsConnections(){
        optionClient.setEnabled(false);
        optionServer.setEnabled(false);
        optionTCP.setEnabled(false);
        optionUDP.setEnabled(false);
    }

}