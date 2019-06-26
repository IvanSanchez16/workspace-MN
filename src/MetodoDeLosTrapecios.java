import java.text.DecimalFormat;
import java.util.Scanner;

public class MetodoDeLosTrapecios {
	
	static Scanner S=new Scanner(System.in);
	
	public static void main(String []args ) {
		System.out.println("M�todos n�mericos");
		System.out.println("Integraci�n num�rica");
		System.out.println("M�todo de los trapecios");
		System.out.println("Tecnol�gico Nacional de M�xico");
		System.out.println("Ing en Sistemas Computacionales");
		System.out.println("Iv�n Humberto S�nchez Aispuro");
		System.out.println("\nProblema: En una jugeter�a la producci�n de un empleado est� dada y\ndefinida cada d�a del mes"
				+ "que trabaja por la integral definida en\nf(x)= (x^3 - sen(x+1))");
		System.out.println("Nota: El programa en los resultados solamente muestra 2 decimales\nm�s sin embargo trabaja con todos");
	
		System.out.print("\nInserte el valor real de la integral: ");
		float vreal=S.nextFloat();
		System.out.print("Inserte el intervalo menor: ");
		int a=S.nextInt();
		System.out.print("Inserte el intervalo mayor: ");
		int b=S.nextInt();
		System.out.print("Inserte el error de aproximaci�n a tolerar: ");
		int error=S.nextInt();
		System.out.print("Inserte el m�ximo total de calculos: ");
		int tc=S.nextInt();
		float vcal=0,errorcal;
		int n=2,cal=0;
		double a2=a,ah,fah;
		double fa,area;
		while(true) {
			float h=(float)(b-a)/(float)n;
			DecimalFormat df=new DecimalFormat("#.00");
			System.out.println("|i\t|a\t|ah\t|fa\t|fah\t|Area\t|");
			for(int i=0 ; i<n ; i++) {
				fa=Math.pow(a2,3)-Math.sin(a2+1);
				ah=a2+h;
				fah=Math.pow(ah,3)-Math.sin(ah+1);
				area=(h/2)*(fa+fah);
				vcal+=area;
				System.out.println("|"+(i+1)+"\t|"+a2+"\t|"+ah+"\t|"+df.format(fa)+"\t|"+df.format(fah)+"\t|"+df.format(area)+"\t|");
				a2=ah;
			}
			System.out.println("Area calculada: "+vcal); 
			System.out.println();
			errorcal=Math.abs(vreal-vcal);
			if(errorcal<=error) {
				System.out.println("Resultados:");
				System.out.println("Total de c�lculos: "+(++cal));
				System.out.println("Valor real: "+vreal);
				System.out.println("Valor calculado: "+vcal);
				System.out.println("Error del problema: "+error);
				System.out.println("Error del c�lculo: "+errorcal);
				return;
			}
			if(++cal>=tc) {
				System.out.println("Resultados:");
				System.out.println("Total de c�lculos: "+cal);
				System.out.println("No se ha encontrado la mejor aproximaci�n");
				return;
			}
			vcal=0;
			a2=a;
			n*=2;
		}
	}
	//320 2 6 2 20
}
