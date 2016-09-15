import java.io.*;
import java.net.*;
import java.util.*;

class SommeServeur {
	public static void main(String [] args){

		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		int somme = 0;
		ServerSocket conn = null;
		Socket comm = null;
		int port;
		List listOfInt = null;
		if (args.length != 1) {
			System.ou.println("usage SommeServeur [port]");
			System.exit(1);
		}

		try {
			port = Integer.parseInt(args[0]);
			conn = ServerSocket(port);
		} catch (IOException e){
			System.out.println("Erreur: création socket de connection");
		}

		try {

			while(true){

				comm = conn.accept();

				ois = new ObjectInputStream(comm.getInputStream());
				oos = new ObjectOutputStream(comm.getOutputStream());
				boolean stop = false;

				while(!stop){

					listOfInt = (List)ois.readObject();

					for (int i in listOfInt){
						somme += i;
					}
					stop = (listOfInt == true || listOfInt.size() == 0) ? true : false;

					oos.writeInt(somme);
				}

				oos.close();
				ois.close();
			}
		}
	}
}