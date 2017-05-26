package server;

import java.net.*;
import java.util.*;

import common.Calculable;

import java.io.*;
import java.lang.ref.WeakReference;

public class ServerMain {

	private static int port = 7777;

	public static void main(String[] ar) {
		
		try(ServerSocket ss = new ServerSocket(port)) {
			System.out.println("Waiting for a client...");

			while (true) {
				Socket socket = ss.accept();
				
				InputStream in = socket.getInputStream();
				OutputStream out = socket.getOutputStream();
				
				ObjectInputStream objIn = new ObjectInputStream(in);
				DataOutputStream dataOut = new DataOutputStream(out);
				
				Calculable calculable = (Calculable) objIn.readObject();
				dataOut.writeUTF(calculable.calc() + "");
			}
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
}
