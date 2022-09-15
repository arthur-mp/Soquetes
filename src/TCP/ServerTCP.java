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
                if (!containsClient(clientSocket)) {
                    clientsTCP.add(clientSocket);
                }
            }

            ComunicationTCP comunication = new ComunicationTCP(clientsTCP);

        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        }
    }


    private boolean containsClient(Socket clientSocket) {
        boolean contains = false;
        String addressExisting;
        String address = String.valueOf(clientSocket.getInetAddress()) +"/"+ String.valueOf(clientSocket.getPort());
        for (Socket client : clientsTCP) {
            addressExisting = String.valueOf(client.getInetAddress()) +"/"+ String.valueOf(client.getPort());
            if (addressExisting.equals(address)) {
                contains = true;
                break;
            }
        }

        return contains;
    }

}
