import java.text.DecimalFormat;
import java.util.Scanner;

public class MetodoDeGaussSeidel {
	
	String[] AConceptos;
	static double[] VIniciales,VFinales;
	static double[][] M;
	static Scanner S=new Scanner(System.in);
	static DecimalFormat df=new DecimalFormat("#.000000");
	
	public static void main(String []a) {
		System.out.println("Métodos númericos");
		System.out.println("Solución de sistemas de ecuaciones");
		System.out.println("Método de gauss-seidel");
		System.out.println("Tecnológico Nacional de México");
		System.out.println("Ing en Sistemas Computacionales");
		System.out.println("Iván Humberto Sánchez Aispuro");
		System.out.println("\nProblema: Utilice el método de gauss-seidel para calcular cuántos peces\n"
				+ "de cada especia habita en el lago, suponiendo que todo el alimento\nsuministrado"
				+ " se consume");
		int Orden;
		while(true) {
			System.out.print("\nIngrese el orden de la matriz: ");
			Orden=S.nextInt();
			if(Orden<2 || Orden>6) {
				System.out.println("Ingrese orden entre 2-6");
				continue;
			}
			break;
		}
		LlenarMatriz(Orden);
		System.out.println("\nDatos adicionales y valores iniciales");
		String[] x=new String[Orden];
		VFinales=new double[Orden];
		VIniciales=new double[Orden];
		for(int i=0 ; i<Orden ; i++) {
			System.out.print("Que representa X"+(i+1)+": ");
			x[i]=S.next();
			System.out.print("Valor inicial de X"+(i+1)+": ");
			VIniciales[i]=S.nextDouble();
		}
		System.out.print("Capture unidad de medida: ");
		String unidad=S.next();
		System.out.println("\nMatriz de datos");
		MostrarMatriz();
		
		System.out.println("\nProceso de gauss-seidel\n");
		System.out.print("|  N  |");
		for(int i=0 ; i<Orden ; i++) 
			System.out.print(" X"+(i+1)+"\t\t|");
		System.out.println(" Error\t\t|");
		double error=0,suma,coef;
		int n=0;
		System.out.print("|  "+n+"  |");
		for(int i=0 ; i<Orden ; i++) 
			System.out.print(" "+VIniciales[i]+"\t\t|");
		System.out.println(" "+error+"\t\t|");
		
		while(error>0.001 || n==0) {
			n++;
			for(int i=0 ; i<Orden ; i++) {
				coef=M[i][i];
				suma=M[i][Orden];
				for(int j=0 ; j<Orden ; j++) {
					if(i==j)
						continue;
					if(j<i) 
						suma-=(M[i][j]*VFinales[j]);
					else
						suma-=(M[i][j]*VIniciales[j]);
				}
				suma/=coef;
				VFinales[i]=suma;
			}
			System.out.print("|  "+n+"  |");
			error=0;
			for(int i=0 ; i<Orden ; i++) {
				System.out.print(" "+df.format(VFinales[i])+"\t|");
				error+=Math.abs(VFinales[i]-VIniciales[i]);
				VIniciales[i]=VFinales[i];
			}
			System.out.println(" "+df.format(error)+"\t|");			
		}
		
		System.out.println("\nResultados:");
		for(int i=0 ; i<Orden ; i++) 
			System.out.println(x[i]+": "+df.format(VFinales[i])+" "+unidad);
		
	}
	//4 20 3 6 8 3000 9 18 5 3 4200 3 3 12 7 4800 2 2 6 19 3600 PezHacha 100 PezGato 100 PezMono 100 PezLagarto 100 peces
	public static void MostrarMatriz() {
			for(int i=0 ; i<M.length ; i++) {
				System.out.print("|");
				for(int j=0 ; j<M.length+1 ; j++) {
					System.out.print(M[i][j]+(j==M.length?"":j==M.length-1?"\t|":"\t"));
				}
				System.out.print("|\n");
			}
		
	}
	
	public static void LlenarMatriz(int o){
		M=new double[o][o+1];
		for(int i=0 ; i<o ; i++) {
			for(int j=0 ; j<o+1 ; j++) {
				System.out.print("Ingrese valor en posición ("+(i+1)+","+(j+1)+"): ");
				M[i][j]=S.nextDouble();
			}
		}
	}
}
