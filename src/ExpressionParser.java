import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpressionParser {

	private static final Logger log = LoggerFactory
			.getLogger(ExpressionParser.class);

	public static void main(String[] args) {
		Stack<String> operations = new Stack<String>();
		Stack<Double> values = new Stack<Double>();
		String exp = "( 11 + ( ( exp ( ( 2.010635 + ( sin ( ( PI / 2 ) ) * 3 ) ) ) + 50 ) ) / 2 )";
		// String exp = "( 10 + 2 )";
		String[] chars = exp.split(" ");
		for (int i = 0; i < chars.length; i++) {
			String character = chars[i];
			if (character.equals("("))
				;
			else if (character.equals("+")) {
				operations.push(character);
				log.info("Добавление операции: +");
			} else if (character.equals("-")) {
				operations.push(character);
				log.info("Добавление операции: -");
			} else if (character.equals("*")) {
				operations.push(character);
				log.info("Добавление операции: *");
			} else if (character.equals("/")) {
				operations.push(character);
				log.info("Добавление операции: /");
			} else if (character.equals("sqrt")) {
				operations.push(character);
				log.info("Добавление операции: sqrt");
			} else if (character.equals("cos")) {
				operations.push(character);
				log.info("Добавление операции: cos");
			} else if (character.equals("sin")) {
				operations.push(character);
				log.info("Добавление операции: sin");
			} else if (character.equals("exp")) {
				operations.push(character);
				log.info("Добавление операции: exp");
			} else if (character.equals("PI")) {
				values.push(Math.PI);
				log.info("Добавление значения: PI");
			} else if (character.equals("E")) {
				values.push(Math.E);
				log.info("Добавление значения: E");
			} else if (character.equals(")")) {
				String operation = operations.pop();
				double v = values.pop();
				if (operation.equals("+")) {
					v = values.pop() + v;
					log.info("Вычисленная сумма: " + v);
				} else if (operation.equals("-")) {
					v = values.pop() - v;
					log.info("Вычисленная разность: " + v);
				} else if (operation.equals("*")) {
					v = values.pop() * v;
					log.info("Вычисленное умножение: " + v);
				} else if (operation.equals("/")) {
					v = values.pop() / v;
					log.info("Вычисленное частное " + v);
				} else if (operation.equals("sqrt")) {
					v = Math.sqrt(v);
					log.info("Вычисленный квадратный корень: " + v);
				} else if (operation.equals("cos")) {
					v = Math.cos(v);
					log.info("Вычисленный коснус: " + v);
				} else if (operation.equals("sin")) {
					v = Math.sin(v);
					log.info("Вычисленный синус: " + v);
				} else if (operation.equals("exp")) {
					v = Math.exp(v);
					log.info("Вычисленная экспонента: " + v);
				}
				values.push(v);
			} else {
				values.push(Double.parseDouble(character));
				log.info("Добавление значения: "
						+ Double.parseDouble(character));
			}
		}
		System.out.printf("%.5f", values.pop());
	}
}
