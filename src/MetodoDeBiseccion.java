import java.text.DecimalFormat;
public class MetodoDeBiseccion {
	/*
	 * Iván Humberto Sánchez Aispuro
	 * Ing en Sistemas Computacionales
	 * Tecnológico Nacional de México
	 * 
	 */
	public static void main(String[] args) {
		DecimalFormat df=new DecimalFormat("#.0000");
		System.out.println("f(x)= xcos(x^2)-4");
		System.out.println("\nnc\tA\t\tB\t\tC\t\tfa\t\tfb\t\tfc");
		double A=-14,B,C=-5,fa,fb,fc,e=0.001;
		int nc=1,tc=50;
		fa=(A*Math.cos( Math.pow(A,2) * (Math.PI/180) ))-4;
		fc=(C*Math.cos( Math.pow(C,2) * (Math.PI/180) ))-4;
		while(true) {
			if((fa*fc)>0) {
				System.out.println("No hay solución");
				break;
			}
			B=(A+C)/2;
			fb=(B*Math.cos( Math.pow(B,2) * (Math.PI/180) ))-4;
			
			System.out.println(nc+"\t"+df.format(A)+"\t"+df.format(B)+
			((B>-10)?"\t\t":"\t")+df.format(C)+((fa<1 && C<-10)?"\t":"\t\t")+df.format(fa)+
			"\t\t"+df.format(fb)+"\t\t"+df.format(fc)+"\t\t");
			
			if(Math.abs(fb)<=e) {
				System.out.println("\nLa Raiz = "+B);
				break;
			}
			nc++;
			if(nc>tc) {
				System.out.println("\nNúmero de cálculos superados");
				break;
			}
			if((fb*fc)<0) {
				A=B;
				fa=fb;
			}else {
				C=B;
				fc=fb;
			}
		}
	}


}
