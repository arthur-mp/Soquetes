package Main;

import Interface.Aplication;
import TCP.ClientTCP;
import TCP.ServerTCP;
import UDP.ClientUDP;
import UDP.ServerUDP;
import Utils.Window;

import java.io.IOException;
import java.net.*;

public  class Main implements Aplication {

    public static Window window;

    public static ClientTCP tcpClient;

    public static ServerTCP tcpServer;

    public static ClientUDP udpClient;

    public static ServerUDP udpServer;

    public  static void main(String[] args) {
        window = new Window();
    }

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
     * Conexão UDP
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
     * Conexão TCP
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
     * Initialize Aplication
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
