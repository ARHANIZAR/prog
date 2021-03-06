import java.io.*;
import java.net.*;

class SommeClient{

	public static void main(String [] args){

		BufferedReader input = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Socket sock = null;
		int port;
		String line;
		String[] tab; // tab of int set by the user
		int somme;
		int nombreInt;

		if ( args.length != 2 ){
			System.out.println("usage: SommeClient ip_server port ");
			System.exit(1);
		}

		try {
			port = Integer.parseInt(args[1]);
			sock = new Socket(args[0],port);
		}catch(IOException e){
			System.out.println("problème de conection au serveur" + e.getMessage());
			System.exit(1);
		}

		try {
			input = new BufferedReader(new InputStreamReader(System.in));
			dos = new DataOutputStream(sock.getOutputStream());
			dis = new DataInputStream(sock.getInputStream());
			boolean stop = false;
			while(!stop){
				System.out.println("enter le nombre d'entier : ");
				line = input.readLine();
				if ( line.equals("0") || line == null || line.equals("")){
					stop = true;
					System.exit(1);
				}
				nombreInt = Integer.parseInt(line);
				dos.writeInt(nombreInt);

				System.out.println("entrer votre série d'entier (val1,val2,val3,..) :");
				line = input.readLine();
				if(line.equals("") || line == null){
					stop = true;
					System.out.println("erreur : entrer correctement les nombres ");
					System.exit(1);
				} 
				tab = line.split(",");

				for(String t : tab){
					dos.writeInt(Integer.parseInt(t));
				}

				somme = dis.readInt();

				System.out.println("Le serveur me dit : La somme de vous nombres est : " + somme);
			}


			dos.close();
			dis.close();

			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}

	}
}