public class Rectangle{

	private double largeur;
	private double longeur;

	public Rectangle( double largeur, double longeur){
		this.largeur = largeur;
		this.longeur = longeur;
	}

	public String toString(){
		return getClass().getName() + " : " + "largeur : " + largeur + ", longeur :" + longeur;
	}

	public static void main( String [] args ){
		Rectangle r1 = new Rectangle(5,6);

		System.out.println(r1.toString());
	}

}