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

		try{

			while (true){
				comm = conn.accept();

				dis = new DataInputStream(comm.getInputStream());
				dos = new DataOutputStream(comm.getOutputStream());

				nombreInt = dis.readInt();

				for (int i = 0; i < nombreInt; i++){

					somme = somme + dis.readInt();
				}

				dos.writeInt(somme);

				dis.close();
				dos.close();

			}
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}