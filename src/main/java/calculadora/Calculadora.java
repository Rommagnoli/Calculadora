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
	 * Metodo que dado dos párametros, los suma.
	 * @param a Parámetro al que se le suma el segundo.
	 * @param b Parámetro a sumar al primero.
	 * @return Retorna la suma de ambos parámetros.
	 */
	public double suma(double a, double b) {
		return a + b;
	}
	
	/**
	 * Método que dado dos parámetros, los resta.
	 * @param a Parámetro al que se le resta el segundo.
	 * @param b Parámetro a restar al primero.
	 * @return Retorna la resta de los parámetros.
	 */
	public double resta(double a, double b) {
		return a - b;
	}

	/**
	 * Método que dado dos parámetros, los multiplica.
	 * @param a Primer parámetro a multiplicar.
	 * @param b Segudno parámetro a multiplicar.
	 * @return Retorna la multiplicacion de ambos parámetros.
	 */
	public double multip(double a, double b) {
		return a * b;
	}
	
	/**
	 * Metodo que dado dos parametros divide el primero por el segundo.
	 * @param num Numerador de la división.
	 * @param den Denominador de la division.
	 * @return Retorna la division de ambos parámetros.
	 * @throws IllegalArgumentException Lanza la excepción cuando el denominador es cero.
	 */
	public double div(double num, double den) throws IllegalArgumentException  {
		if (den == 0) throw new IllegalArgumentException("El denominador de una division debe ser distinto de cero");
		else return num / den;
	}
	
	/**
	 * Método que dado dos parametros, calcula la n-ecima potencia del primer parámetro.
	 * @param base Parámetro que representa la base de la potencia.
	 * @param potencia Parámetro que representa el exponente.
	 * @return Retorna el resultado de multiplicar n veces la base de la potencia.
	 */
	public double pot(double base, double potencia) {
		return Math.pow(base,potencia);
	}
	
	/**
	 * Método que dado un numero, calcula su logartimo neperiano.
	 * @param a Parámetro al que calcularle el logaritmo
	 * @return Retorna el logaritmo neperiano del parámetro
	 */
	public double logNep(double a) {
		return Math.log(a);
	}
	
	/**
	 * Método privado que dado una cadena que representa un calculo matemático,
	 * va guardando sus operandos y operadores en un arreglo, respetando paretensis.
	 * @param calculo String donde se encuentra en cálculo a realizar.
	 * @return Un arreglo con el calculo a realizar.
	 */
	public static ArrayList<String> toArray(String calculo) {
		ArrayList<String> calculoArray = new ArrayList<String>();
		for (int indice = 0; indice < calculo.length(); indice++) {
			if (calculo.charAt(indice) == '(') {
				int posParFinal = Calculadora.parentesisFinal(calculo.substring(indice + 1, calculo.length()));
				calculoArray.add(calculo.substring(indice + 1, indice + posParFinal));
				indice = indice + posParFinal;
			} else {
				if (calculo.charAt(indice) == 'l') {
					calculoArray.add("log");
					indice = indice + 3;
				} else {
					if (calculo.charAt(indice) == 'e') {
						calculoArray.add("exp");
						indice = indice + 3;
					} else {
						int indiceInicio = indice;
						while (calculo.length() > indice && calculo.charAt(indice) != '+' && calculo.charAt(indice) != '-' && calculo.charAt(indice) != '*' && calculo.charAt(indice) != '/') {
							indice++;
						}	
						if (indiceInicio != indice) {
							calculoArray.add(calculo.substring(indiceInicio,indice));
						}
						calculoArray.add(calculo.substring(indice, indice + 1));
					}
				}
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
	
	//public 
}
