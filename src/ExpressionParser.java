import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpressionParser {

	private static final Logger log = LoggerFactory
			.getLogger(ExpressionParser.class);

	public static void main(String[] args) {
		Stack<String> operations = new Stack<String>();
		Stack<Double> values = new Stack<Double>();
		// String exp =
		// "( 11 + ( ( exp ( ( 2.010635 + ( sin ( ( PI / 2 ) ) * 3 ) ) ) + 50 ) / 2 ) )";
		String exp = "( ( ( 10 + 2 ) ) )";
		String[] chars = exp.split(" ");
		for (int i = 0; i < chars.length; i++) {
			String character = chars[i];
			if (character.equals("("))
				;
			else if (character.equals("+")) {
				operations.push(character);
				log.debug("���������� ��������: +");
			} else if (character.equals("-")) {
				operations.push(character);
				log.debug("���������� ��������: -");
			} else if (character.equals("*")) {
				operations.push(character);
				log.debug("���������� ��������: *");
			} else if (character.equals("/")) {
				operations.push(character);
				log.debug("���������� ��������: /");
			} else if (character.equals("sqrt")) {
				operations.push(character);
				log.debug("���������� ��������: sqrt");
			} else if (character.equals("cos")) {
				operations.push(character);
				log.debug("���������� ��������: cos");
			} else if (character.equals("sin")) {
				operations.push(character);
				log.debug("���������� ��������: sin");
			} else if (character.equals("exp")) {
				operations.push(character);
				log.debug("���������� ��������: exp");
			} else if (character.equals("PI")) {
				values.push(Math.PI);
				log.debug("���������� ��������: PI");
			} else if (character.equals("E")) {
				values.push(Math.E);
				log.debug("���������� ��������: E");
			} else if (character.equals(")")) {
				String operation;
				try {
					operation = operations.pop();
				} catch (Exception e) {
					operation = "empty";
					log.debug("��������� ������");
				}
				double v = values.pop();
				if (operation.equals("+")) {
					v = values.pop() + v;
					log.debug("����������� �����: " + v);
				} else if (operation.equals("-")) {
					v = values.pop() - v;
					log.debug("����������� ��������: " + v);
				} else if (operation.equals("*")) {
					v = values.pop() * v;
					log.debug("����������� ���������: " + v);
				} else if (operation.equals("/")) {
					v = values.pop() / v;
					log.debug("����������� ������� " + v);
				} else if (operation.equals("sqrt")) {
					v = Math.sqrt(v);
					log.debug("����������� ���������� ������: " + v);
				} else if (operation.equals("cos")) {
					v = Math.cos(v);
					log.debug("����������� ������: " + v);
				} else if (operation.equals("sin")) {
					v = Math.sin(v);
					log.debug("����������� �����: " + v);
				} else if (operation.equals("exp")) {
					v = Math.exp(v);
					log.debug("����������� ����������: " + v);
				}
				values.push(v);
			} else {
				values.push(Double.parseDouble(character));
				log.debug("���������� ��������: "
						+ Double.parseDouble(character));
			}
		}
		System.out.printf("%.5f", values.pop());
	}
}
