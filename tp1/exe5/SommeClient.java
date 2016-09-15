import java.io.*;
import java.net.*;
import java.util.*;

class SommeClient {
	public static void main (String [] args){

		Socket sock = null;
		BufferedReader br = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		int port;
		List<Integer> listOfInt = null;
		String ligne = null;
		String [] tableOfInt = null;
		int somme;

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

			br = new BufferedReader(new InputStreamReader(System.in));
			listOfInt = new ArrayList();
			do {
				ligne = br.readLine();
				tableOfInt = ligne.split(",");

				for(String i : tableOfInt){
					listOfInt.add(Integer.parseInt(i));
				}
				oos.writeObject(listOfInt);

				System.out.println(listOfInt.size() + " nombres envoyés au serveur");

				somme = ois.readInt();
				System.out.println("la somme envoyée par le serveur est : " + somme);



			}while(ligne != null && !ligne.equals(""));

			oos.close();
			ois.close();
			


		}catch (IOException e){
			System.out.println("err: "+e.getMessage());
		}


	}
}