import java.io.*;
import java.net.*;
import java.util.*;

public class EchoRond {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ServerSocket conn;
	private Socket comm;
	private int port;

	public EchoRond(int port)throws IOException{
		this.port = port;
		conn = new ServerSocket(port);
	}

	public void connectionLoop()throws IOException{
		while(true){
			comm = conn.accept();
			ois = new ObjectInputStream(comm.getInputStream());
			oos = new ObjectOutputStream(comm.getOutputStream());

			try{
				requestLoop();
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
	}

	public void requestLoop()throws IOException{

		int idReq = ois.readInt();

		if(idReq == 1){
			try {
				Rond r = (Rond) ois.readObject();
				System.out.println(r.toString());
				oos.writeObject(r.clone());
				oos.flush();
			}catch(ClassNotFoundException e){
				System.out.println(e.getMessage());
			}
		}

		else {
			oos.writeObject(null);
			oos.flush();
		}
	}
}