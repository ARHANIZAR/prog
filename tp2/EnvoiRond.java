import java.net.*;
import java.util.*;
import java.io.*;

public class EnvoiRond{
	private Socket comm;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Rond r;

	public EnvoiRond(String nameServer, int port, int rayon) throws IOException{
		r = new Rond(rayon);
		comm = new Socket(nameServer,port);
		oos = new ObjectOutputStream(comm.getOutputStream());
		ois = new ObjectInputStream(comm.getInputStream());
		
	}

	public void requestLoop() throws IOException{
		oos.writeInt(1);
		oos.writeObject(r);
		oos.flush();
		try{
			Rond cloneRond = (Rond) ois.readObject();

			if (r.equals(cloneRond)){
				System.out.println("Ok !");
			}else {
				System.out.println("mauvais clonage !!");
			}
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}

	}
}