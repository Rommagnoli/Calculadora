package calculadora;

import java.util.ArrayList;

/**
 * Clase que describe la logica de la calculadora.
 * @author Román Magnoli.
 *
 */
public class Calculadora {
	
	private static ArrayList<String> calculo;
	
	/**
	 * Metodo constructor de la clase.
	 * @param calculo Parámetro donde se guarda la expresión a calcular.
	 */
	public Calculadora (String calculo) {
		this.calculo = Calculadora.toArray(calculo);
	}

	/**
	 * Método que dado una cadena que representa un calculo matemático,
	 * va guardando sus operandos y operadores en un arreglo, respetando paretensis.
	 * @param calculo String donde se encuentra en cálculo a realizar.
	 * @return Un arreglo con el calculo a realizar.
	 */
	public static ArrayList<String> toArray(String calculo) {
		ArrayList<String> calculoArray = new ArrayList<String>();
		int indice = 0;
		while (indice < calculo.length()) {
			switch (calculo.charAt(indice)) {
				case '(':
					int posParFinal = Calculadora.parentesisFinal(calculo.substring(indice + 1, calculo.length()));
					calculoArray.add(calculo.substring(indice + 1, indice + posParFinal));
					indice = indice + posParFinal;
					indice++;
					break;
					
				case 'l':
					indice = indice + 3;
					posParFinal = Calculadora.parentesisFinal(calculo.substring(indice + 1, calculo.length()));
					calculoArray.add("log(" + calculo.substring(indice + 1, indice + posParFinal + 1));
					indice = indice + posParFinal;
					indice++;
					break;
				
				case 'e':
					indice = indice + 3;
					posParFinal = Calculadora.parentesisFinal(calculo.substring(indice + 1, calculo.length()));
					calculoArray.add("exp(" + calculo.substring(indice + 1, indice + posParFinal + 1));
					indice = indice + posParFinal;
					indice++;
					break;
				
				case '+':
					calculoArray.add("+");
					indice++;
					break;
					
				case '-':
					calculoArray.add("-");
					indice++;
					break;
					
				case '*':
					calculoArray.add("*");
					indice++;
					break;
					
				case '/':
					calculoArray.add("/");
					indice++;
					break;
					
				default:
					int indiceInicio = indice;
					while (indice < calculo.length() && calculo.charAt(indice) != '+' && calculo.charAt(indice) != '-' && calculo.charAt(indice) != '*' && calculo.charAt(indice) != '/') {
						indice++;
					}
					calculoArray.add(calculo.substring(indiceInicio,indice));
					break;
			}
		}
		return calculoArray;
	}
	
	/**
	 * Método que determina la posición de cierre de un parentesis que abre en la posicion inicial del texto del parámetro
	 * @param texto String al que quiero encontrar el parentesis que cierra el parentesis inicial.
	 * @return La posición de cierre del parentesis.
	 */
	private static int parentesisFinal(String texto) {
		int cont = 1;
		int indice = 0;
		while (cont != 0 && indice < texto.length()) {
			if (texto.charAt(indice) == '(') cont++;
			if (texto.charAt(indice) == ')') cont--;
			indice++;
		}
		return indice;
	}
	
	public static double resolBasicas(ArrayList<String> calculo) {
		double resultado = 0;
		switch (calculo.get(1)) {
			case "+":
				resultado = Double.parseDouble(calculo.get(0)) + Double.parseDouble(calculo.get(2));
				break;
			case "-":
				resultado = Double.parseDouble(calculo.get(0)) - Double.parseDouble(calculo.get(2));
				break;
			case "*":
				resultado = Double.parseDouble(calculo.get(0)) * Double.parseDouble(calculo.get(2));
				break;
			case "/":
				if (calculo.get(2) == "0") throw new IllegalArgumentException("Error de Sintaxis: El denominador de una division no puede ser cero");
				resultado = Double.parseDouble(calculo.get(0)) / Double.parseDouble(calculo.get(2));
				break;
			}
		return resultado;
	}

			
	public static void resolArreglo(ArrayList<String> calculo) {
		int indice = 0;
		while (indice < calculo.size()) {
			if (calculo.get(indice).length() == 3) {
				ArrayList<String> arrStrAux = Calculadora.toArray(calculo.get(indice));
				System.out.println(arrStrAux.toString());
				calculo.set(indice, String.valueOf(resolBasicas(arrStrAux)));
			} else {
				if (calculo.get(indice).length() >= 3) {
					ArrayList<String> arrStrAux = Calculadora.toArray(calculo.get(indice));
					System.out.println(arrStrAux.toString());
					resolArreglo(arrStrAux);
				}
			}
			indice++;
		}
	}
			
	
	/**
	 * Método que calcula el logaritmo. Ingresa una String desde la calculadora con el valor a calcular y retorna un Double con el resultado. 
	 * @param calculo String que es ingresado a la calculadora para su calculo.
	 * @return Retorna el logaritmo del numero ingresado.
	 */
	private static Double resolLog(String calculo) { 
		int indice = 4;
		String paramString = calculo.substring(indice,calculo.length());
		double paramDouble = Double.parseDouble(paramString);
		return Math.log(paramDouble);
	}
	
	//public static String simpParamLog(String calculo) {
	//	int indice = 4;
	//	String paramString = calculo.substring(indice,calculo.length());
	//}
}
















