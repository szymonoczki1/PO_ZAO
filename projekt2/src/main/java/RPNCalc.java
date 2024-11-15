public class RPNCalc {
    public String[] sequence;
    private Stack stack = new Stack();
    

    public void transformInput(String input){
        sequence = input.split(" ");
    }


    public boolean isRPNSequenceValid(){
        int numbers_count = 0;
        if (sequence.length < 3){
            return false;
        }

        for ( String i : sequence){
            if ( !i.matches("\\d+\\.\\d*|\\d*\\.\\d+|\\d+|\\+|-|\\*|\\/") ){
                return false;
            }
            if (i.matches("\\d+\\.\\d*|\\d*\\.\\d+|\\d+")){
                numbers_count += 1;
            } else {
                if (numbers_count < 2){
                    return false;
                } else {
                    numbers_count -= 1;
                }
            }

        }
        return numbers_count == 1;
    }

    public void calculateFromStack(){
        for(String i : sequence){
            if(i.matches("\\d+\\.\\d*|\\d*\\.\\d+|\\d+")){
                stack.push(i);
            } else {
                double num1 = Double.parseDouble(stack.pop());
                double num2 = Double.parseDouble(stack.pop());
                double result;

                switch (i) {
                    case "+":
                        result = num2 + num1;
                        stack.push(Double.toString(result));
                        break;
                    case "-":
                        result = num2 - num1;
                        stack.push(Double.toString(result));
                        break;
                    case "*":
                        result = num2 * num1;
                        stack.push(Double.toString(result));
                        break;
                    case "/":
                        if ( num1 == 0 ){
                            throw new ArithmeticException("dividing by 0");
                        }
                        result = num2 / num1;
                        stack.push(Double.toString(result));
                        break;
                
                    default:
                        throw new IllegalArgumentException("operator unknown: " + i);
            }
            }
        }
    }

    public String getResult(){
        if(stack.size == 1){
            return String.format("%.2f", Double.parseDouble(stack.pop()));
        } else {
            throw new IllegalStateException("more than 1 number left on stack");
        }
    }
}
