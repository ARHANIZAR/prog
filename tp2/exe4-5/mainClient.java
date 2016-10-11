import java.net.*;
import java.io.*;
import java.util.regex.*;
import java.util.*;

public class mainClient{
	public static void main(String [] args){
		int port;
		String serverAdress;
		AireClient aireClient = null;
		BufferedReader br;
		int idReq;
		String line = "";
		String [] params;
		List listOfForm = null;
		int nbForm;

		

		if(args.length != 2) {
			System.out.println("usage : mainClient serverAdress port");
			System.exit(1);
		}
		try{
			System.out.println("insérez le nombre de forme à traiter : ");
			br = new BufferedReader(new InputStreamReader(System.in));
			listOfForm = new ArrayList<Form>();
			nbForm = Integer.parseInt(br.readLine());

			for (int i = 0; i < nbForm; i++){
				line = br.readLine();
				if(line.isEmpty()){
					System.exit(1);
				}else{
					params = line.split(",");
					if ( params.length == 1 ){
						listOfForm.add(new Rond(Double.parseDouble(params[0])));
					}else if( params.length == 2){
						listOfForm.add(new Rectangle(Double.parseDouble(params[0]), Double.parseDouble(params[1])));
					}else{
						System.out.println(" erreur syntaxe : largeur,longeur / rayon");
						System.exit(1);
					}
				}


			}

				port = Integer.parseInt(args[1]);
				serverAdress = args[0];
				aireClient = new AireClient(serverAdress,port,listOfForm);

			

			aireClient.requestLoop();


		}catch( PatternSyntaxException | IOException | NullPointerException ex){
			System.out.println("erreur Syntaxe de largeur/longeur ");
		}

	}
}