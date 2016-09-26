import java.io.*;
import java.net.*;
import java.util.*;

class SommeServeur {

	public static void main(String [] args){

		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		int somme = 0;
		ServerSocket conn = null;
		Socket comm = null;
		int port;
		List<Integer> listOfInt = new ArrayList<Integer>();

		if (args.length != 1) {
			System.out.println("usage SommeServeur [port]");
			System.exit(1);
		}

		try {
			port = Integer.parseInt(args[0]);
			conn = new ServerSocket(port);
		} catch (IOException e){
			System.out.println("Erreur: création socket de connection");
		}

		

			while(true){
				try {
				comm = conn.accept();

				ois = new ObjectInputStream(comm.getInputStream());
				oos = new ObjectOutputStream(comm.getOutputStream());
				boolean stop = false;

				while(!stop){
					listOfInt.removeAll(listOfInt);
					somme = 0;
					listOfInt = (List<Integer>)ois.readObject();
					System.out.println(listOfInt.size() + " nombres envoyés par le client ");

					for (int i : listOfInt){
						somme += i;
					}

					stop = (listOfInt == null || listOfInt.size() == 0) ? true : false;

					oos.writeInt(somme);
					oos.flush();

					System.out.println("La somme des nombres est : " + somme);
				}

				oos.close();
				ois.close();
				
				System.out.println("bye bye !!");
			
			} catch(IOException | ClassNotFoundException e){
				System.out.println("err : " + e.getMessage());
			}
		}
	}
}