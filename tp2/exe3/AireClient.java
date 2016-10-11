import java.net.*;
import java.io.*;
import java.util.*;

public class AireClient{
	Socket comm;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	Rectangle rectangle;
	List listOfForm;

	public AireClient(String serverAdress, int port, List listOfForm)throws IOException{
		this.listOfForm = listOfForm;
		comm = new Socket(serverAdress,port);
		oos = new ObjectOutputStream(comm.getOutputStream());
		ois = new ObjectInputStream(comm.getInputStream());
	}


	public void requestLoop()throws IOException{
		try{

			oos.writeInt(listOfForm.size());

			for (Object o : listOfForm){
				if ( o instanceof Rond ){
					oos.writeInt(1);
				} else{
					oos.writeInt(2);
				}

				oos.writeObject(o);
				oos.flush();
			}

			for (Object o : listOfForm){
				double aire = ois.readDouble();
				double perimetre = ois.readDouble();

				System.out.println(" aire : " + aire + " / perimetre : " + perimetre);
			}

		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}