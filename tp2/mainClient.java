import java.io.*;
import java.net.*;
import java.util.*;

public class mainClient {
	public static void main(String [] args){
		int port;
		String nameServer;
		int rayon;
		EnvoiRond r;

		if(args.length != 3){
			System.out.println("usage : mainClient rayon nameServer port");
			System.exit(1);
		}

		rayon = Integer.parseInt(args[0]);
		port = Integer.parseInt(args[2]);
		nameServer = args[1];
		try{
			r = new EnvoiRond(nameServer,port,rayon);
			r.requestLoop();
		} catch(IOException e){
			System.out.println("err" + e.getMessage());
		}


	}	
}
