import java.io.*;
import java.net.*;
import java.util.*;

class SommeClient {
	pulic static void main (String [] args){

		Socket sock = null;
		BufferedReader bf = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		int port;
		int [] tabOfInt = null;

		if (args.length != 2){
			System.out.println("usage SommeClient [ip_adress] [port]");
			System.exit(1);
		}

		try {
			port = Integer.parseInt(args [1]);
			sock = new Socket(args[0],port);			
		} catch (IOException e){
			System.out.println("err de connection au serveur : " + e.getMessage());
			System.exit(1);
		}

		try {
			oos = new ObjectOutputStream(sock.getOutputStream());
			ois = new ObjectInputStream(sock.getInputStream());

			bf = new BufferedReader(System.in);


		}


	}
}