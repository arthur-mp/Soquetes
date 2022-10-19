package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
* Servidor TCP
*/
public class ServerTCP {

    private final int serverPort = 7896;

    /*
    * Lista de Clientes que realizaram conexao com o servidor
    */
    private  List<Socket> clientsTCP = new ArrayList<Socket>();

    public void initializeTCPServer(){
        try {
            // Inicializacao do servidor
            int serverPort = 7896; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("Server TCP Initialized");

            /*
            * Conexao
            * Servidor receber 2 clientes
            */
            while (clientsTCP.size() < 2) {
                // Aceita novo cliente
                Socket clientSocket = listenSocket.accept();
                if (!containsClient(clientSocket)) {
                    clientsTCP.add(clientSocket);
                }
            }

            /*
            * Apos ter sido realizada a conexao com os 2 clientes
            * E inicializado a comunicacao de fato
            */
            ComunicationTCP comunication = new ComunicationTCP(clientsTCP);

        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        }
    }


    /*
    * Analisa se o cliente ja se conectou
    * Ou seja, um cliente pode efetuar apenas uma conexao
    */
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
