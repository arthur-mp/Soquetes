package UDP;

import Interface.InOut;
import Utils.Messages;
import Utils.Window;

import java.io.EOFException;
import java.io.IOException;
import java.net.*;

public class ClientUDP implements InOut {
    public  Window window;

    DatagramSocket aSocket = null;

    InetAddress aHost;

    int serverPort = 7896;

    public ClientUDP(Window windowParam){
        window = windowParam;
    }

    public void initializeUDPClient(){
        String host = "127.0.0.1";
        try {
            aSocket = new DatagramSocket();
            aHost = InetAddress.getByName(host);

            byte[] message = {Messages.CONNECTSERVER.getValue()};

            DatagramPacket request =
                    new DatagramPacket(message, message.length, aHost, serverPort);
            aSocket.send(request);

            DatagramPacket reply = new DatagramPacket(message, message.length);
            aSocket.receive(reply);

            if (message[0] == Messages.CONNECTCLIENT1.getValue()) {
                window.isClient("1");
                window.enableTable();
            } else {
                if (message[0] == Messages.CONNECTCLIENT2.getValue()) {
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
    @Override
    public  void receive() {
        new Thread(){

            @Override
            public void run() {
                try {
                    byte[] message = new byte[3];
                    DatagramPacket reply = new DatagramPacket(message, message.length);
                    aSocket.receive(reply);
                    if(message[0] == Messages.FINISH.getValue()){
                        aSocket.close();
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

    @Override
    public  void send() {
        try {
            window.enableTable();
            byte[] message = window.getPlayed().getBytes();
            DatagramPacket request = new DatagramPacket(message, message.length, aHost, serverPort);
            aSocket.send(request);
            window.resetPlayed();
            window.disabledTable();
            receive();
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        }
    }

}
