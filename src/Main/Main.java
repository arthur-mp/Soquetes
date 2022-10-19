package Main;

import Interface.Aplication;
import TCP.ClientTCP;
import TCP.ServerTCP;
import UDP.ClientUDP;
import UDP.ServerUDP;
import Utils.Window;


public  class Main implements Aplication {

    /*
    * Variaveis Estaticas
    * */
    public static Window window;

    public static ClientTCP tcpClient;

    public static ServerTCP tcpServer;

    public static ClientUDP udpClient;

    public static ServerUDP udpServer;

    /*
    * Inicializa a aplicacao,
    * e a Jframe nomeada de Window
    */
    public  static void main(String[] args) {
        window = new Window();
    }

    /*
    * Call back
    * Quando clicado em conectar na Jframe
    * será direcionado para esta funcao
    */
    @Override
    public  void initialize() {
        initializeAplication(window);
    }
    @Override
    public void sendClient(){
        if(tcpClient != null){
            tcpClient.send();
        }else{
            if(udpClient != null){
                udpClient.send();
            }
        }

    }



    /*
     *
     * Conexao UDP
     */
    private  void udpClient(Window window) {
        udpClient = new ClientUDP(window);
        udpClient.initializeUDPClient();
    }

    private  void udpServer() {
       udpServer = new ServerUDP();
       udpServer.initializeUDPServer();
    }

    /*
     *
     * Conexao TCP
     */
    private void tcpClient(Window window) {
        // arguments supply message and hostname
        tcpClient = new ClientTCP(window);
        tcpClient.initializeTCPClient();
    }

    private void tcpServer() {
        tcpServer = new ServerTCP();
        tcpServer.initializeTCPServer();
    }



    /*
     *
     * Inicializa Aplicacao
     * com base nas configuracoes informadas pelo usuario na Jfram
     */
    private  void initializeAplication(Window window) {
        if (window.getOptionConnection() == "TCP") {
            if (window.getAplicationConnection() == "Server") {
                window.isServer();
                tcpServer();
            } else {
                if (window.getAplicationConnection() == "Client") {
                    tcpClient(window);
                }
            }
        } else {
            if (window.getOptionConnection() == "UDP") {
                if (window.getAplicationConnection() == "Server") {
                    window.isServer();
                    udpServer();
                } else {
                    if (window.getAplicationConnection() == "Client") {
                        udpClient(window);
                    }
                }
            }
        }
    }

}
