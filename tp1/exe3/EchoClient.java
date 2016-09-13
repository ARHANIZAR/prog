import java.io.*;
import java.net.*;
 
class EchoClient  {
 
    public static void main(String []args) {
 	
 	BufferedReader input = null;
	BufferedReader br = null;
	PrintStream ps = null;
	String line = null;
	String lineInput = null;
	Socket sock = null;
	int port = -1;
 
	if (args.length != 2) {
	    System.out.println("usage: EchoClient ip_server port");
	    System.exit(1);
	}
 
	try {
	    port = Integer.parseInt(args[1]);
	    sock = new Socket(args[0],port);
	}
	catch(IOException e) {
	    System.out.println("problème de connexion au serveur : "+e.getMessage());
	    System.exit(1);
	}
 
	try {
		input = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
	   	ps = new PrintStream(sock.getOutputStream());
	   	boolean stop = false;
		while(!stop){
 			lineInput = input.readLine();
 			stop = lineInput.equals("") || lineInput==null ? true : false;
	    	ps.println(lineInput);
	    	line = br.readLine();
	    	System.out.println("le serveur me repond : "+line);
		}
		br.close();
	    ps.close();

	}
	catch(IOException e) {
	    System.out.println(e.getMessage());
	}
    }
}