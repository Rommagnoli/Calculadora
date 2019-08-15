package calculadora;

import java.util.ArrayList;

public class AppCalculadora {

	public static void main(String[] args) {
		String ejemplo = "2.14+3*(5/8)+log(5)+(exp(5*8, 3))";
		ArrayList<String> ejemploArray = new ArrayList<String>();
		ejemploArray = Calculadora.toArray(ejemplo);
		//System.out.println(ejemploArray.toString());
		ejemplo = "5+2*(2/3)-1+(2*(3/2))";
		ejemploArray = Calculadora.toArray(ejemplo);
		System.out.println(ejemploArray.toString());
		Calculadora.resolArreglo(ejemploArray);
		System.out.println(ejemploArray.toString());
		//System.out.println(Calculadora.resolArreglo(ejemploArray));
	}
}
