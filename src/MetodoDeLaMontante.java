import java.util.Scanner;

public class MetodoDeLaMontante {

	Scanner S=new Scanner(System.in);
	double[][] M,MCopia;
	public static void main(String a[]) {
		new MetodoDeLaMontante();
	}

	public MetodoDeLaMontante() {
		ImprimePortada();
		int Orden;
		while(true) {
			System.out.print("\nIngrese el orden de la matriz: ");
			Orden=S.nextInt();
			if(Orden<2 || Orden>5) {
				System.out.println("Ingrese orden entre 2-5");
				continue;
			}
			break;
		}
		LlenarMatriz(Orden);
		System.out.println("Datos adicionales");
		String[] x=new String[Orden];
		for(int i=0 ; i<Orden ; i++) {
			System.out.println("Que representa X"+(i+1));
			x[i]=S.next();
		}
		MostrarMatriz(true);
		
		System.out.println("\nProceso de la montante\n");
		double pivant=1,piv;
		for(int p=0 ; p<Orden ; p++) {
			piv=M[p][p];
			for(int f=0 ; f<Orden ; f++) {
				if(f==p)
					continue;
				for(int c=0 ; c<=Orden ; c++) {
					if(c==p)
						continue;
					M[f][c]=( (piv*M[f][c])-(M[f][p]*M[p][c]) )/pivant;
				}
			}
			for(int f=0 ; f<Orden ; f++) {
				if(f==p)
					continue;
				M[f][p]=0;
			}
			pivant=piv;
		}
		
		MostrarMatriz(true);
		System.out.println("\nGenerar Matriz unitaria\n");
		for(int f=0 ; f<Orden ; f++) {			
			M[f][Orden]=M[f][Orden]/M[f][f];
			M[f][f]=1;
		}
		MostrarMatriz(true);
		for(int i=0 ; i<x.length ; i++) 
			System.out.println(x[i]+"= "+M[i][Orden]);
	}

	public void MostrarMatriz(boolean matriz) {
		if(matriz) {
			for(int i=0 ; i<M.length ; i++) {
				System.out.print("|");
				for(int j=0 ; j<M.length+1 ; j++) {
					System.out.print(M[i][j]+(j==M.length?"":j==M.length-1?"\t|":"\t"));
				}
				System.out.print("|\n");
			}
			return;
		}
		for(int i=0 ; i<MCopia.length ; i++) {
			System.out.print("|\t");
			for(int j=0 ; j<MCopia.length+1 ; j++) 
				System.out.print(MCopia[i][j]+"\t");
			System.out.print("|\n");
		}
	}

	public void LlenarMatriz(int o){
		M=new double[o][o+1];
		MCopia=new double[o][o+1];
		for(int i=0 ; i<o ; i++) {
			for(int j=0 ; j<o+1 ; j++) {
				System.out.print("Ingrese valor en posición ("+(i+1)+","+(j+1)+"): ");
				M[i][j]=S.nextDouble();
				MCopia[i][j]=M[i][j];
			}
		}
	}

	public void ImprimePortada() {
		System.out.println("Métodos númericos");
		System.out.println("Solución de sistemas de ecuaciones");
		System.out.println("Método de la montante");
		System.out.println("Tecnológico Nacional de México");
		System.out.println("Ing en Sistemas Computacionales");
		System.out.println("\nProblema: Utilice el método de la montante para calcular cuántos peces\n"
				+ "de cada especia habita en el lago, suponiendo que todo el alimento\nsuministrado"
				+ " se consume");
	}
}


