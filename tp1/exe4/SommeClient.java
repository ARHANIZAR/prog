import java.io.*;
import java.net.*;

class SommeClient{

	public static void main(String [] args){

		Bufferedreader input = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Socket sock = null;
		int port;

		if ( args.length != 2 ){
			System.out.println("usage: SommeClient ip_server port ");
			System.exit(1);
		}

		try {
			port = Integer.parseInt(args[1]);
			sock = new Socket(args[0],port);
		}catch(IOException e){
			System.out.println("Erreur de connection");
		}

	}
}