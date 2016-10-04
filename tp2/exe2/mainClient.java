import java.net.*;
import java.io.*;

public class mainClient{
	public static void main(String [] args){
		int port;
		String serverAdress;
		AireClient aireClient = null;

		try{

			if(args.length == 3){
				port = Integer.parseInt(args[1]);
				serverAdress = args[0];
				double rayon = Double.parseDouble(args[2]);
				aireClient = new AireClient(serverAdress,port,rayon);
			}else if(args.length == 4){
				port = Integer.parseInt(args[1]);
				serverAdress = args[0];
				double largeur = Double.parseDouble(args[2]);
				double longeur = Double.parseDouble(args[3]);
				aireClient = new AireClient(serverAdress,port,largeur,longeur);

			}else {
				System.out.println("usage : mainClient serverAdress port rayon ou mainClient serverAdress port largeur longeur");
				System.exit(1);
			}

			aireClient.requestLoop();


		}catch(IOException e){
			System.out.println(e.getMessage());
		}

	}
}