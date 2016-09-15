public class Rond {
	private float rayon;

	public Rond(float rayon){
		this.rayon = rayon;
	}

	public String toString(){
		return getClass().getName() + rayon;
	}

	public static void main(String [] args){

		Rond r = new Rond(3);
		System.out.println(r.toString());

	}
}