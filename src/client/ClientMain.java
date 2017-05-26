package client;

import java.net.*;

import common.Calculable;

import java.io.*;

public class ClientMain {
	
	private static int serverPort = 7777;
	private static String localhost = "127.0.0.1";
	
    public static void main(String[] ar) {

        InetAddress ipAddress = null;
        try {
        	ipAddress = InetAddress.getByName(localhost);
        } catch(UnknownHostException e) {
        	e.printStackTrace();
        }

        if(ipAddress == null) {
        	return;
        }
        
        try(Socket socket = new Socket(ipAddress, serverPort)) {
            System.out.println("Chat client started");

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            DataInputStream dataIn = new DataInputStream(in);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            
            Calculable calculable = new CalculableImpl();
            objOut.writeObject(calculable);
            
            String result = dataIn.readUTF();
            System.out.println("The answer is " + result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}