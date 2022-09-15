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

                if (!containsClient(request)) {
                    clientsUDP.add(request);
                }
            }

            ComunicationUDP comunication = new ComunicationUDP(clientsUDP, aSocket);

        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        }
    }


    private boolean containsClient(DatagramPacket clientDatagram) {
        boolean contains = false;
        String addressExisting;
        String address = String.valueOf(clientDatagram.getAddress()) +"/"+ String.valueOf(clientDatagram.getPort());
        for (DatagramPacket client : clientsUDP) {
            addressExisting = String.valueOf(client.getAddress()) +"/"+ String.valueOf(client.getPort());
            if (addressExisting.equals(address)) {
                contains = true;
                break;
            }
        }

        return contains;
    }

}
