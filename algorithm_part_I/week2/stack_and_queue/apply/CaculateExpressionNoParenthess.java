package algorithm_part_I.week2.stack_and_queue.apply;

import java.util.Stack;

/*Example: When we enter: 9 3 / 5 + 7 2 - * the output will be 40*/
public class CaculateExpressionNoParenthess {
    String input = new String();

    public CaculateExpressionNoParenthess(String input) {
        this.input = input;
    }
    public double caculating(){
        double result = 0;
        String[] part = input.split(" ");
        Stack<Double> st = new Stack<>();
        for(String s : part){
            try{
                if(s.equals("+")){
                    result = st.pop() + st.pop();
                    st.push(result);
                }else if(s.equals("-")){
                    result = st.pop() - st.pop();
                    result = -1 * result;
                    st.push(result);
                }else if(s.equals("*")){
                    result = st.pop() * st.pop();
                    result = result;
                    st.push(result);
                } else if(s.equals("/")) {
                    Double divisor = st.pop();
                    result = st.pop()/divisor;
                    st.push(result);
                }else{
                    st.push(Double.parseDouble(s));
                }
            }catch (Exception e){
                System.out.println("Exception" + e.getMessage());
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        CaculateExpressionNoParenthess cenp = new CaculateExpressionNoParenthess("9 3 / 5 + 7 2 - *");
        System.out.println(cenp.caculating());
    }
}
