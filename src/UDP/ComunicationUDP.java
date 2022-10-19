package UDP;

import Utils.Messages;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.List;

/*
 * Classe onde a logica do jogo e executada
 */
public class ComunicationUDP {

    private DatagramSocket aSocket = null;
    DatagramPacket clientSocket1;
    DatagramPacket clientSocket2;

    public ComunicationUDP(List<DatagramPacket> clients, DatagramSocket aSocket) {
      clientSocket1 = clients.get(0);
      clientSocket2 = clients.get(1);
      this.aSocket = aSocket;
      comunicationClients();
    }

    private void comunicationClients(){
        try {

            // Servidor enviar mensagem informando aos clientes a ordem de prioridade
            // e que o jogo iniciou

            byte[] messageConection = new byte[]{Messages.CONNECTCLIENT1.getValue()};

            DatagramPacket request =
                    new DatagramPacket(messageConection, messageConection.length, clientSocket1.getAddress(), clientSocket1.getPort());
            aSocket.send(request);

            messageConection = new byte[]{Messages.CONNECTCLIENT2.getValue()};

            request =
                    new DatagramPacket(messageConection, messageConection.length, clientSocket2.getAddress(), clientSocket2.getPort());
            aSocket.send(request);

            byte[] message = new byte[3];

            while(true){
                DatagramPacket reply = new DatagramPacket(message, message.length);
                aSocket.receive(reply);

                String value = String.valueOf((char)message[0]);
                String finish = Messages.FINISH.getValueString();
                if(value.equals(finish)) break;


                request =
                        new DatagramPacket(message, message.length, clientSocket2.getAddress(), clientSocket2.getPort());
                aSocket.send(request);

                reply = new DatagramPacket(message, message.length);
                aSocket.receive(reply);
                value = String.valueOf((char)message[0]);
                if(value.equals(finish)) break;

                request =
                        new DatagramPacket(message, message.length, clientSocket1.getAddress(), clientSocket1.getPort());
                aSocket.send(request);
            }

            byte[] messageFinish = new byte[]{Messages.FINISH.getValue()};

            request =
                    new DatagramPacket(messageFinish, messageFinish.length, clientSocket1.getAddress(), clientSocket1.getPort());
            aSocket.send(request);

            request =
                    new DatagramPacket(messageFinish, messageFinish.length, clientSocket2.getAddress(), clientSocket2.getPort());
            aSocket.send(request);

            System.exit(0);

        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

}