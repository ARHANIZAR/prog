import java.net.*;
import java.io.*;

public class AireServer {
	ObjectInputStream ois;
	ObjectOutputStream oos;
	ServerSocket conn;
	Socket comm;
	int port;

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
		int idReq = ois.readInt();

		if( idReq == 1 ){
			processRond();
		}else if( idReq == 2 ){
			processRectangle();
		} 
	}

	public void processRond()throws IOException, ClassNotFoundException{
		Rond r = (Rond) ois.readObject();
		oos.writeDouble(r.aire());
		oos.writeDouble(r.perimetre());
		oos.flush();
	}

	public void processRectangle()throws IOException, ClassNotFoundException{
		Rectangle r = (Rectangle) ois.readObject();
		oos.writeDouble(r.aire());
		oos.writeDouble(r.perimetre());
		oos.flush();
	}


}