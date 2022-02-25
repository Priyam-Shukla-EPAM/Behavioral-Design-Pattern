import java.util.*;
public class Interpreter_design_Pattern {
    public static void main(String[] args) {
        Scanner S=new Scanner(System.in);
        String str=S.nextLine();
        String str1=S.nextLine();
        evaluate_pattern_interpreter eval=new evaluate_pattern_interpreter(new Interpreter());
        System.out.println(eval.interpret(str));
        System.out.println(eval.interpret(str1));


    }
}

interface expression{
    String evaluate(Interpreter interpret);
}

class Interpreter{
    public String decimal_to_binary(int exp){
        return Integer.toBinaryString(exp);
    }

    public int binary_to_decimal(String exp){
        return Integer.parseInt(exp,2);
    }

    public String decimal_to_octal(int exp){
        return Integer.toOctalString(exp);
    }

    public int octal_to_decimal(String exp){
        return Integer.parseInt(exp,3);
    }

    public String decimal_to_hexadecimal(int exp){
        return Integer.toHexString(exp);
    }
}

class decimal_to_binary implements expression{
    private int num;
    public decimal_to_binary(int num){
        this.num=num;
    }

    @Override
    public String evaluate(Interpreter interpret) {
        return interpret.decimal_to_binary(num);
    }
}

class decimal_to_octal implements expression{
    private int num;
    public decimal_to_octal(int num){
        this.num=num;
    }

    @Override
    public String evaluate(Interpreter interpret) {
        return interpret.decimal_to_octal(num);
    }
}

class decimal_to_hexadecimal implements expression{
    private int num;
    public decimal_to_hexadecimal(int num){
        this.num=num;
    }

    @Override
    public String evaluate(Interpreter interpret) {
        return interpret.decimal_to_hexadecimal(num);
    }
}

class binary_to_decimal implements expression{
    private String exp;
    public binary_to_decimal(String exp){
        this.exp=exp;
    }

    @Override
    public String evaluate(Interpreter interpret) {
        int val=interpret.binary_to_decimal(exp);
        return Integer.toString(val);
    }
}

class octal_to_decimal implements expression{
    private String exp;
    public octal_to_decimal(String exp){
        this.exp=exp;
    }

    @Override
    public String evaluate(Interpreter interpret) {
        int val=interpret.octal_to_decimal(exp);
        return Integer.toString(val);
    }
}

class evaluate_pattern_interpreter{
    public Interpreter interpreter;
    public evaluate_pattern_interpreter(Interpreter interpreter){
        this.interpreter=interpreter;
    }

    public String interpret(String exp){
        expression ex=null;
        if (exp.contains("tobinary")){
            ex=new decimal_to_binary(Integer.valueOf(exp.substring(0,exp.indexOf(" "))));
        }
        else if(exp.contains("tooctal")){
            ex=new decimal_to_octal(Integer.valueOf(exp.substring(0,exp.indexOf(" "))));
        }
        else if(exp.contains("tohex")){
            ex=new decimal_to_hexadecimal(Integer.valueOf(exp.substring(0,exp.indexOf(" "))));
        }
        else if(exp.contains("bintodecimal")){
            ex=new binary_to_decimal(exp.substring(0,exp.indexOf(" ")));
        }
        else if(exp.contains("octtodecimal")){
            ex=new octal_to_decimal(exp.substring(0,exp.indexOf(" ")));
        }
        return ex.evaluate(interpreter);
    }
}