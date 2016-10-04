import java.net.*;
import java.io.*;

public class AireClient{
	Socket comm;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	Rectangle rectangle;
	Rond rond;

	public AireClient(String serverAdress, int port, double rayon)throws IOException{
		rond = new Rond(rayon);
		comm = new Socket(serverAdress,port);
		oos = new ObjectOutputStream(comm.getOutputStream());
		ois = new ObjectInputStream(comm.getInputStream());
	}

	public AireClient(String serverAdress, int port, double largeur, double longeur)throws IOException{
		rectangle = new Rectangle(largeur,longeur);
		comm = new Socket(serverAdress,port);
		oos = new ObjectOutputStream(comm.getOutputStream());
		ois = new ObjectInputStream(comm.getInputStream());

	}

	public void requestLoop()throws IOException{
		try{

			if( rond != null ){
				oos.writeInt(1);
				oos.writeObject(rond);
			}
			else if( rectangle != null ){
				oos.writeInt(2);
				oos.writeObject(rectangle);
			}else {
				oos.writeInt(0);
			}

			double aire = ois.readDouble();
			double perimetre = ois.readDouble();

			System.out.println(" aire : " + aire + " / perimetre : " + perimetre);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}