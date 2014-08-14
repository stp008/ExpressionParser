import java.util.Stack;


public class ExpressionParser {
	    public static void main(String[] args) { 
	        Stack<String> operations  = new Stack<String>();
	        Stack<Double> values = new Stack<Double>();
	        String exp = "( 11 + ( ( exp ( ( 2.010635 + ( sin ( ( PI / 2 ) ) * 3 ) ) ) + 50 ) ) / 2 )";
	        String[] chars = exp.split(" ");
	        for (int i = 0; i < chars.length; i++) {
	            String character = chars[i];
	            if      (character.equals("("))               ;
	            else if (character.equals("+"))    operations.push(character);
	            else if (character.equals("-"))    operations.push(character);
	            else if (character.equals("*"))    operations.push(character);
	            else if (character.equals("/"))    operations.push(character);
	            else if (character.equals("sqrt")) operations.push(character);
	            else if (character.equals("cos"))  operations.push(character);
                else if (character.equals("sin"))  operations.push(character);
                else if (character.equals("exp"))  operations.push(character);
                else if (character.equals("PI"))   values.push(Math.PI);
                else if (character.equals("E"))    values.push(Math.E);
	            else if (character.equals(")")) {
	                String operation = operations.pop();
	                double v = values.pop();
	                if      (operation.equals("+"))    v = values.pop() + v;
	                else if (operation.equals("-"))    v = values.pop() - v;
	                else if (operation.equals("*"))    v = values.pop() * v;
	                else if (operation.equals("/"))    v = values.pop() / v;
	                else if (operation.equals("sqrt")) v = Math.sqrt(v);
	                else if (operation.equals("cos")) v = Math.cos(v);
	                else if (operation.equals("sin")) v = Math.sin(v);
	                else if (operation.equals("exp")) v = Math.exp(v);
	                values.push(v);
	            }
	            else values.push(Double.parseDouble(character));
	        }
	        System.out.printf("%.5f", values.pop());
	    }
}
