package calculadora;

import java.util.ArrayList;

public class AppCalculadora {

	public static void main(String[] args) {
		String ejemplo = "2.14+3*log(5)+(exp(5*8, 3))";
		ArrayList<String> ejemploArray = new ArrayList<String>();
		ejemploArray = Calculadora.toArray(ejemplo);
		System.out.println(ejemploArray.toString());
	}

}
