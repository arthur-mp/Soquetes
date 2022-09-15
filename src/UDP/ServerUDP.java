package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

public class ServerUDP {

    private final int serverPort = 7896;

    private DatagramSocket aSocket = null;

    private  List<DatagramPacket> clientsUDP = new ArrayList<DatagramPacket>();

    public void initializeUDPServer(){
        try {
            aSocket = new DatagramSocket(serverPort);
            System.out.println("Server UDP Initialized");
            byte[] message = new byte[1];
            // Connection
            while (clientsUDP.size() < 2) {
                // Aceita novo cliente
                DatagramPacket request = new DatagramPacket(message, message.length);
                aSocket.receive(request);

                if (!containsClient(request.getPort())) {
                    clientsUDP.add(request);
                }
            }

            ComunicationUDP comunication = new ComunicationUDP(clientsUDP, aSocket);

        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        }
    }


    private boolean containsClient(int port) {
        boolean contains = false;
        //TODO: VALIDAR IP/PORT
        for (DatagramPacket client : clientsUDP) {
            if (client.getPort() == port) {
                contains = true;
                break;
            }
        }

        return contains;
    }

}
