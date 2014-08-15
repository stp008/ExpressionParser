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
				log.info("���������� ��������: +");
			} else if (character.equals("-")) {
				operations.push(character);
				log.info("���������� ��������: -");
			} else if (character.equals("*")) {
				operations.push(character);
				log.info("���������� ��������: *");
			} else if (character.equals("/")) {
				operations.push(character);
				log.info("���������� ��������: /");
			} else if (character.equals("sqrt")) {
				operations.push(character);
				log.info("���������� ��������: sqrt");
			} else if (character.equals("cos")) {
				operations.push(character);
				log.info("���������� ��������: cos");
			} else if (character.equals("sin")) {
				operations.push(character);
				log.info("���������� ��������: sin");
			} else if (character.equals("exp")) {
				operations.push(character);
				log.info("���������� ��������: exp");
			} else if (character.equals("PI")) {
				values.push(Math.PI);
				log.info("���������� ��������: PI");
			} else if (character.equals("E")) {
				values.push(Math.E);
				log.info("���������� ��������: E");
			} else if (character.equals(")")) {
				String operation = operations.pop();
				double v = values.pop();
				if (operation.equals("+")) {
					v = values.pop() + v;
					log.info("����������� �����: " + v);
				} else if (operation.equals("-")) {
					v = values.pop() - v;
					log.info("����������� ��������: " + v);
				} else if (operation.equals("*")) {
					v = values.pop() * v;
					log.info("����������� ���������: " + v);
				} else if (operation.equals("/")) {
					v = values.pop() / v;
					log.info("����������� ������� " + v);
				} else if (operation.equals("sqrt")) {
					v = Math.sqrt(v);
					log.info("����������� ���������� ������: " + v);
				} else if (operation.equals("cos")) {
					v = Math.cos(v);
					log.info("����������� ������: " + v);
				} else if (operation.equals("sin")) {
					v = Math.sin(v);
					log.info("����������� �����: " + v);
				} else if (operation.equals("exp")) {
					v = Math.exp(v);
					log.info("����������� ����������: " + v);
				}
				values.push(v);
			} else {
				values.push(Double.parseDouble(character));
				log.info("���������� ��������: "
						+ Double.parseDouble(character));
			}
		}
		System.out.printf("%.5f", values.pop());
	}
}
