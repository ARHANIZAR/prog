import java.io.*;
import java.net.*;

class SommeServeur {
	public static void main(String [] args){
		DataOutputStream dos = null;
		DataInputStream dis = null;
		int [] tabInt = null;
		int somme = 0;
		ServerSocket conn = null;
		Socket comm = null;
		int port;
		int nombreInt;

		if (args.length !=1){
			System.out.println("usage : SommeServeur server port");
			System.exit(1);
		}

		try {
			port = Integer.parseInt(args[0]);
			conn = new ServerSocket(port);
		} catch(IOException e){
			System.out.println("problème de création socket serveur : " + e.getMessage());
			System.exit(1);
		}



		while (true){
			try{
				comm = conn.accept();
				boolean stop = false;
				dis = new DataInputStream(comm.getInputStream());
				dos = new DataOutputStream(comm.getOutputStream());

				while(!stop){


					nombreInt = dis.readInt();

					stop = nombreInt == 0 ? true : false;

					for (int i = 0; i < nombreInt; i++){
						somme = somme + dis.readInt();
					}
					System.out.println("Somme envoyée : " + somme);

					dos.writeInt(somme);
				}



				dis.close();
				dos.close();
				somme = 0;
				nombreInt = 0;

			}catch(IOException e){
					System.out.println(e.getMessage());
			}
		}
	}
}