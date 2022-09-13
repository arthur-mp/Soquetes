package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

public class Comunication {
    DataInputStream inClient1;
    DataOutputStream outClient1;

    DataInputStream inClient2;
    DataOutputStream outClient2;
    Socket clientSocket1;
    Socket clientSocket2;

    public Comunication(List<Socket> clients) {
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

            outClient1.writeUTF("Sua vez");

            String[] message;

            while(true){
                message = inClient1.readUTF().split("");
                if(message.length == 1) break;

                outClient2.writeUTF(Arrays.toString(message));

                message = inClient2.readUTF().split("");
                if(message.length == 1) break;
            }

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