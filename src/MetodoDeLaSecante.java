import java.text.DecimalFormat;

public class MetodoDeLaSecante {

	/*
	 * Iv�n Humberto S�nchez Aispuro 
	 */
	public static void main(String[] args) {
		System.out.println("Iv�n Humberto S�nchez Aispuro\n"
				+ "Tecnol�gico Nacional de M�xico\n"
				+ "Ingenier�a en Sistemas Computacionales\n");
		System.out.println("Encontrar la ra�z soluci�n de la ecuaci�n:\n"
				+ "f(x)=x^3 + 2x^2 + 7x -20\n"
				+ "en un intervalo abierto de (-2 a 2)\n"
				+ "con un error tolerante de 0.0001 en un m�ximo de 50 c�lculos");
		DecimalFormat df = new DecimalFormat("#.0000");
		double x1,x2,x3,fx1,fx2,fx3,e=0.0001;
		int nc=1,tc=50;
		x1=-2;
		x2=2;
		fx1=(Math.pow(x1,3) + (2*Math.pow(x1,2)) + (7*x1) - 20);
		fx2=(Math.pow(x2,3) + (2*Math.pow(x2,2)) + (7*x2) - 20);
		System.out.println("nc\tx1\t\tx2\t\tfx1\t\tfx2\t\tx3\t\tfx3");
		while(true) {
			x3=(x1-( (x1-x2) *fx1) / (fx1 - fx2) );
			fx3=(Math.pow(x3,3) + (2*Math.pow(x3,2)) + (7*x3) - 20);
			System.out.println(nc+ "\t"+ df.format(x1) + "\t\t" +df.format(x2) 
			+ "\t\t" +df.format(fx1)+ (fx1<-10?"\t":"\t\t") +df.format(fx2)+ "\t\t" +df.format(x3)
			+ "\t\t" +df.format(fx3));
			if(Math.abs(fx3)<=e) {
				System.out.println("\nLa Ra�z es igual a: "+x3);
				break;
			}
			nc++;
			if(nc>tc) {
				System.out.println("\tNo hay soluci�n");
				break;
			}
			x1=x2;
			x2=x3;
			fx1=fx2;
			fx2=fx3;
		}
	}

}
