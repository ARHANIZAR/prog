import java.net.*;
import java.io.*;

public class mainServer{
	public static void main(String [] args){
		int port;
		AireServer aireServer;

		if (args.length != 1){
			System.out.println("usage : mainServer port");
			System.exit(1);
		}
		port = Integer.parseInt(args[0]);
		try{
			aireServer = new AireServer(port);
			aireServer.connectionLoop();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}