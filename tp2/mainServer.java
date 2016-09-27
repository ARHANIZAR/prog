import java.util.*;
import java.net.*;
import java.io.*;

public class mainServer{
	public static void main(String [] args){
		int port;
		EchoRond r; 

		if (args.length != 1){
			System.out.println("usage mainServer port");
			System.exit(1);
		}

		try{

			port = Integer.parseInt(args[0]);
			r = new EchoRond(port);
			r.connectionLoop();
		} catch(IOException e){
			System.out.println("err : " + e.getMessage());
		}

	}
}