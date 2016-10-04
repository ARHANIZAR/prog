import java.net.*;
import java.io.*;

public class mainClient{
	public static void main(String [] args){
		int port;
		String serverAdress;
		AireClient aireClient = null;
		BufferedReader br;
		int idReq;

		

		if(args.length != 2) {
			System.out.println("usage : mainClient serverAdress port rayon ou mainClient serverAdress port largeur longeur");
			System.exit(1);
		}
		try{
			System.out.println("insérez le nombre de forme à traiter : ")
			br = new BufferedReader(new InputStream(System.in));
			idreq = Integer.parseInt(br.readLine());
			if(idReq == 1){
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

			}

			aireClient.requestLoop();


		}catch(IOException e){
			System.out.println(e.getMessage());
		}

	}
}