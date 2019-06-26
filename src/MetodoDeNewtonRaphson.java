import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Vector;

public class MetodoDeNewtonRaphson {

	Scanner S = new Scanner(System.in);
	int tc;
	double a,b,e;
	DecimalFormat df=new DecimalFormat("0.0000");
	Vector<Double> vs = new Vector<Double>();
	
	public MetodoDeNewtonRaphson() {
		EscribePortada();
		LeerAtributos();
		TerminaEncabezado();
		
		boolean band=false,band2=false;
		int nc=1;
		double x1=a,x2,fx1,fx1_1raD,fx1_2daD,fx2;
		fx1=((x1*x1) + Math.cos(x1*x1) - 2);
		while(true) {
			fx1_1raD=( (2*x1) - (2*x1*Math.sin(x1*x1)) );
			fx1_2daD=( 2 - (4*x1*x1*Math.cos(x1*x1)) - (2*Math.sin(x1*x1)) );
			x2=x1-( fx1 / ( fx1_1raD - ( (fx1*fx1_2daD) / (2 * fx1_1raD) ) ) );
			fx2=((x2*x2) + Math.cos(x2*x2) - 2);
			
			if(x2<a) {
				a=a+0.25;
				x1=a;
				fx1=((x1*x1) + Math.cos(x1*x1) - 2);
				continue;
			}
			if(x2>b) {
				if(!band) 
					System.out.println("No se encontraron soluciones dentro de los intervalos otorgados");
				break;
			}
			if(nc==1)
				System.out.println("nc\tx1\t\tfx1\t\tf'x1\t\tf''x1\t\tx2\t\tfx2");
			MostrarDatos(nc,x1,fx1,fx1_1raD,fx1_2daD,x2,fx2);
			
			if(Math.abs(fx2)<e) {
				System.out.println("\nUna Raíz solución es: "+x2+"\n");
				band2=false;
				for(int i=0 ; i<vs.size() ; i++) {
					double dif= (vs.get(i)>x2?vs.get(i)-x2:x2-vs.get(i));
					if(dif<0.01) {
						band2=true;
					}
				}
				if(!band2) 
					vs.add(x2);
				nc=1;
				band=true;
				x1=x2+1;
				fx1=((x1*x1) + Math.cos(x1*x1) - 2);
				continue;

			}
			nc++;
			if(nc>tc) {
				System.out.println("\nTotal de cálculos sobrepasado\n");
				nc=1;
				x1=x2+1;
				fx1=((x1*x1) + Math.cos(x1*x1) - 2);
				continue;
			}
			x1=x2;
			fx1=fx2;
		}
		if(vs.size()>0) {
			System.out.println("Las Raíces encontradas dentro de los intervalos son: ");
			for(int j=0 ; j<vs.size() ; j++)
				System.out.println(df.format(vs.get(j)));
		}else
			System.out.println("No se encontraron raíces solución");
	}
	
	private void MostrarDatos(int nc, double x1, double fx1, double fx1_1raD, double fx1_2daD, double x2, double fx2) {
		System.out.println(nc+"\t"+df.format(x1)+"\t\t"+df.format(fx1)+"\t\t"+df.format(fx1_1raD)+"\t\t"+
				df.format(fx1_2daD)+"\t\t"+df.format(x2)+"\t\t"+df.format(fx2)+"\t\t");
	}

	private void LeerAtributos() {
		while(true) {
			System.out.print("Defina los interválos para trabajar:\nmenor: ");
			a=S.nextDouble();
			System.out.print("mayor: ");
			b=S.nextDouble();
			if(a==b) {
				System.out.println("Los valores otorgados son iguales");
				continue;
			}
			if(a>b) {
				double aux=a;
				a=b;
				b=aux;
				System.out.println("El intervalo izquierdo es mayor por lo cual se invirtieron ["+a+","+b+"]");
			}
			break;
		}
		while(true) {
			System.out.print("Defina el error ha aceptar(menor a 0.01): ");
			e= Math.abs(S.nextDouble());
			if(e>0.01) {
				System.out.println("Error demasiado grande, dismunuya el error para mejores resultados");
				continue;
			}
			break;
		}
		while(true) {
			System.out.print("Ingrese el total de cálculos a tolerar: ");
			tc=S.nextInt();
			if(tc<1) {
				System.out.println("Ingrese un valor positivo");
				continue;
			}
			break;
		}
	}

	private void EscribePortada() {
		System.out.println("Iván Humberto Sánchez Aispuro");
		System.out.println("Tecnológico Nacional de México");
		System.out.println("Ingeniería en Sistemas Computacionales");
		System.out.println("Métodos Númericos");
		System.out.println("10 - 11 am");
		System.out.println("Método de Newton Raphson\n");
	}
	
	private void TerminaEncabezado() {
		System.out.println("\nProblema: Encontrar la/s raíz/ces solución de la ecuación\n"
				+ "f(x)= x^2 + cos(x^2) - 2, dentro de los intervalos ["+a+","+b+"]\n"
						+ "con un error de "+e+" tolerando "+tc+" cálculos\n");
	}
	
	public static void main(String[] args) {
		//Se invoca al constructor de la misma clase para salir del mundo 'static'
		new MetodoDeNewtonRaphson();
	}



}
