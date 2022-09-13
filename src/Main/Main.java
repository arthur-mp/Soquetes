package Main;

import Interface.CalllBack;
import TCP.Comunication;
import TCP.Connection;
import Utils.Window;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main implements CalllBack {

    public static Window window;

    public static String[][] table = new String[3][3];

    public static List<Socket> clientsTCP = new ArrayList<Socket>();

    public static void main(String[] args) {
        window = new Window();
    }

    public void methodToCallBack(){
        initializeAplication(window);
    }

    /*
     *
     * Conexão UDP
     */
    private static void udpClient() {
        String host = "127.0.0.1";
        String message = "Oi";
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket();
            byte[] m = message.getBytes();
            InetAddress aHost = InetAddress.getByName(host);
            int serverPort = 6789;
            DatagramPacket request =
                    new DatagramPacket(m, message.length(), aHost, serverPort);
            aSocket.send(request);
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println("Reply: " + new String(reply.getData()));
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) aSocket.close();
        }
    }

    private static void udpServer() {
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket(6789);
            System.out.println("Server UDP Initialized");
            // create socket at agreed port
            byte[] buffer = new byte[1000];
            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(),
                        request.getAddress(), request.getPort());
                aSocket.send(reply);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) aSocket.close();
        }
    }

    /*
     *
     * Conexão TCP
     */
    private static void tcpClient(Window window) {
        // arguments supply message and hostname
        Socket s = null;
        String host = "127.0.0.1";
        try {
            int serverPort = 7896;
            //Connection
            s = new Socket(host, serverPort);

            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());



            while(true){

            }

            out.writeUTF(window.getNameGamer());        // UTF is a string encoding see Sn. 4.4
            String name = in.readUTF();        // read a line of data from the stream
            window.isClient(name);


        } catch (UnknownHostException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            if (s != null) try {
                s.close();
            } catch (IOException e) {
                System.out.println("close:" + e.getMessage());
            }
        }
    }

    private static void tcpServer() {
        try {
            int serverPort = 7896; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("Server TCP Initialized");

            // Connection
            while (clientsTCP.size() < 2) {
                // Aceita novo cliente
                Socket clientSocket = listenSocket.accept();
                if(!containsClient(clientSocket.getPort())){
                    Connection c = new Connection(clientSocket);
                    clientsTCP.add(clientSocket);
                }
            }

            Comunication comunication = new Comunication(clientsTCP);

        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        }
    }

    /*
     *
     * Metodos
     */
    private static void initializeAplication(Window window) {
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
                        udpClient();
                    }
                }
            }
        }
    }

    private static void setPlayer(Window window, String player){
        window.setPlayer(player);
    }

    private static boolean containsClient(int port){
        boolean contains = false;

        for (Socket client : clientsTCP) {
            if (client.getPort() == port) {
                contains = true;
                break;
            }
        }

        return  contains;
    }
}
