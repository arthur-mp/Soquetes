package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

/*
 * Servidor UDP
 */
public class ServerUDP {

    private final int serverPort = 7896;

    private DatagramSocket aSocket = null;

    private List<DatagramPacket> clientsUDP = new ArrayList<DatagramPacket>();

    public void initializeUDPServer() {
        try {
            aSocket = new DatagramSocket(serverPort);
            System.out.println("Server UDP Initialized");
            byte[] message = new byte[1];
            /*
             * Conexao
             * Servidor receber 2 clientes
             */
            while (clientsUDP.size() < 2) {
                // Aceita novo cliente
                DatagramPacket request = new DatagramPacket(message, message.length);
                aSocket.receive(request);

                if (!containsClient(request)) {
                    clientsUDP.add(request);
                }
            }

            /*
             * Apos ter sido realizada a conexao com os 2 clientes
             * E inicializado a comunicacao de fato
             */
            ComunicationUDP comunication = new ComunicationUDP(clientsUDP, aSocket);

        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        }
    }


    /*
     * Analisa se o cliente ja se conectou
     * Ou seja, um cliente pode efetuar apenas uma conexao
     */
    private boolean containsClient(DatagramPacket clientDatagram) {
        boolean contains = false;
        String addressExisting;
        String address = String.valueOf(clientDatagram.getAddress()) + "/" + String.valueOf(clientDatagram.getPort());
        for (DatagramPacket client : clientsUDP) {
            addressExisting = String.valueOf(client.getAddress()) + "/" + String.valueOf(client.getPort());
            if (addressExisting.equals(address)) {
                contains = true;
                break;
            }
        }

        return contains;
    }

}
