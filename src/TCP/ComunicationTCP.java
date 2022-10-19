package TCP;

import Utils.Messages;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

/*
* Classe onde a logica do jogo e executada
*/
public class ComunicationTCP {
    DataInputStream inClient1;
    DataOutputStream outClient1;

    DataInputStream inClient2;
    DataOutputStream outClient2;
    Socket clientSocket1;
    Socket clientSocket2;

    public ComunicationTCP(List<Socket> clients) {
      clientSocket1 = clients.get(0);
      clientSocket2 = clients.get(1);
      comunicationClients();
    }

    private void comunicationClients(){
        try {
            inClient1 = new DataInputStream(clientSocket1.getInputStream());
            outClient1 = new DataOutputStream(clientSocket1.getOutputStream());

            inClient2 = new DataInputStream(clientSocket2.getInputStream());
            outClient2 = new DataOutputStream(clientSocket2.getOutputStream());

            // Servidor enviar mensagem informando aos clientes a ordem de prioridade
            // e que o jogo iniciou
            outClient1.writeByte(Messages.CONNECTCLIENT1.getValue());
            outClient2.writeByte(Messages.CONNECTCLIENT2.getValue());

            byte[] message = new byte[3];

            while(true){
                inClient1.read(message);
                String value = String.valueOf((char)message[0]);
                String finish = Messages.FINISH.getValueString();
                if(value.equals(finish)) break;

                outClient2.write(message);

                inClient2.read(message);
                value = String.valueOf((char)message[0]);
                if(value.equals(finish)) break;

                outClient1.write(message);
            }

            outClient1.writeByte(Messages.FINISH.getValue());
            outClient2.writeByte(Messages.FINISH.getValue());
            System.exit(0);

        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        } finally {
            try {
                clientSocket1.close();
                clientSocket2.close();
            } catch (IOException e) {/*close failed*/}
        }

    }

}