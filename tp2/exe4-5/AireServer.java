import java.net.*;
import java.io.*;
import java.util.*;

public class AireServer {
	ObjectInputStream ois;
	ObjectOutputStream oos;
	ServerSocket conn;
	Socket comm;
	int port;
	List listOfForm;


	public AireServer(int port)throws IOException{
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
			}catch(ClassNotFoundException e2){
				System.out.println(e2.getMessage());
			}
		}
	}

	public void requestLoop()throws IOException, ClassNotFoundException{

		listOfForm = (List) ois.readObject();

		for (Object o : listOfForm) {
			process((Form) o);
		}


	}

	public void process(Form o)throws IOException, ClassNotFoundException{
		oos.writeDouble(o.aire());
		oos.writeDouble(o.perimetre());
		oos.flush();
	}

}