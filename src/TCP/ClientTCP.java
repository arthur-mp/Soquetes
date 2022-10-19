package TCP;

import Interface.InOut;
import Utils.Messages;
import Utils.Window;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/*
* Cliente TCP
*/
public class ClientTCP implements InOut {

    public   DataInputStream in;
    public   DataOutputStream out;
    public  Socket s;

    public  Window window;

    public ClientTCP(Window windowParam){
        window = windowParam;
    }

    /*
     * Funcao que efetua o inicio da comunicacao do Cliente
     */
    public void initializeTCPClient(){
        String host = window.getIpConnection();
        try {
            int serverPort = 7896;
            //Connection
            s = new Socket(host, serverPort);
            in = new DataInputStream(s.getInputStream());
            out = new DataOutputStream(s.getOutputStream());

            // mensagem de inicializacao enviado pelo servidor
            // esta mensagem inicial diferencia o tipo de cliente
            byte message = in.readByte();

            if (message == Messages.CONNECTCLIENT1.getValue()) {
                window.isClient("1");
                window.enableTable();
            } else {
                if (message == Messages.CONNECTCLIENT2.getValue()) {
                    window.isClient("2");
                    receive();
                }
            }

        } catch (UnknownHostException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        }
    }

    /*
    * Funcao que efetua o recebimento de mensagem
    */
    @Override
    public  void receive() {
        new Thread(){

            @Override
            public void run() {
                try {
                    byte[] message = new byte[3];
                     in.read(message);
                    if(message[0] == Messages.FINISH.getValue()){
                        s.close();
                        System.exit(0);
                    }else {
                        window.updateTable(new String(message, "UTF-8"));
                    }
                } catch (IOException e) {
                    System.out.println("readline:" + e.getMessage());
                }
            }
        }.start();

    }

    /*
     * Funcao que efetua o envio de mensagem
     */
    @Override
    public  void send() {
        try {
            window.enableTable();
            byte[] message = window.getPlayed().getBytes();
            out.write(message);
            window.resetPlayed();
            window.disabledTable();
            receive();
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        }
    }

}
