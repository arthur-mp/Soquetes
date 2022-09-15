package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerTCP {

    private final int serverPort = 7896;

    private  List<Socket> clientsTCP = new ArrayList<Socket>();

    public void initializeTCPServer(){
        try {
            int serverPort = 7896; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("Server TCP Initialized");

            // Connection
            while (clientsTCP.size() < 2) {
                // Aceita novo cliente
                Socket clientSocket = listenSocket.accept();
                if (!containsClient(clientSocket.getPort())) {
                    clientsTCP.add(clientSocket);
                }
            }

            ComunicationTCP comunication = new ComunicationTCP(clientsTCP);

        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        }
    }


    private boolean containsClient(int port) {
        boolean contains = false;
        //TODO: VALIDAR IP/PORT
        for (Socket client : clientsTCP) {
            if (client.getPort() == port) {
                contains = true;
                break;
            }
        }

        return contains;
    }

}
