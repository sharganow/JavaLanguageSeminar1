import java.lang.Double;
import java.lang.Integer;
import java.util.Scanner;
public class Simple_calculator {
    public static void main(String[] args) {
        System.out.println("Напишите задание для калькулятора в виде \"12 * 3 = \" без кавычек: ");
        Scanner iScanner = new Scanner(System.in);
        String user_task = iScanner.nextLine();
        iScanner.close();
        if(user_task.charAt(user_task.length()-1) != ' '){ user_task += ' ';}
        System.out.printf(user_task);
        System.out.println(execute_task(user_task));
    }
    public static int execute_task(String user_task) {
        int arg1 = 0;
        int arg2 = 0;
        StringBuilder operand = new StringBuilder();
        operand.append("Nothing");
        String state = "Найти первый аргумент";
        StringBuilder arg = new StringBuilder();
        for(int i = 0; i<user_task.length(); i++){
            switch(state){
                case "Найти первый аргумент": {
                    int[] getArg = get_arg(i, user_task);
                    i = getArg[0];
                    arg1 = getArg[1];
                    state = "Определить операнд";
                }break;
                case "Определить операнд":{
                    i = get_operand(i, user_task, operand);
                    state = "Найти второй аргумент";
                }break;
                case "Найти второй аргумент":{
                    int[] getArg = get_arg(i, user_task);
                    i = getArg[0];
                    arg2 = getArg[1];
                    state = "Произвести вычисление";
                }break;
                case "Произвести вычисление":{
                    return  get_calculate(i, user_task, operand, arg1, arg2);
                }
            }
        }
        return -1;
    }/**/
    public static int[] get_arg(int index, String user_task) {
        int[] takeArg = new int[] {index, -1};
        StringBuilder arg = new StringBuilder();
        String typeArg = "int";
        for(;index < user_task.length(); index++){
            switch (user_task.charAt(index)) {
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9': {
                    arg.append(user_task.charAt(index));
                }break;
                case ',', '.': {
                    if(typeArg == "int"){
                        arg.append('.');
                        typeArg = "double";
                    }
                }break;
                case ' ':{
                    if(arg.length() > 0){
                        if (index > 0){
                            takeArg[0] = index - 1;
                        }
                        else{
                            takeArg[0] = 0;
                        }
                        index = user_task.length();
                    }
                }break;
                case '-': {
                    if (arg.length() == 0) {
                        arg.append('-');
                    }
                    else {
                        if (index > 0){
                            takeArg[0] = index - 1;
                        }
                        else{
                            takeArg[0] = 0;
                        }
                        index = user_task.length();
                    }
                }break;
                default:{
                    if (index > 0){
                        takeArg[0] = index - 1;
                    }
                    else{
                        takeArg[0] = 0;
                    }
                    index = user_task.length();
                }
            }
        }
        if(arg.length() == 0){
            takeArg[0] = user_task.length();
        }
        else{
            switch(typeArg){
                case "int":{
                    takeArg[1] = Integer.parseInt(arg.toString());
                }break;
                case "double":{
                    takeArg[1] = (int) Double.parseDouble(arg.toString());
                }break;
            }
        }
        return   takeArg;
    }
    public static int get_operand(int index, String user_task, StringBuilder operand){
        for(;index < user_task.length(); index++){
            switch (user_task.charAt(index)) {
                case '-', '+', '*', ':': {
                    operand.delete(0, operand.length());
                    operand.append(Character.toString(user_task.charAt(index)));
                    return index;
                }
                case ' ':{}
                break;
                default:{
                    return index;
                }
            }
        }
        return index;
    }
    public static int get_calculate(int index, String user_task, StringBuilder operand, int arg1, int arg2){
        for(;index < user_task.length(); index++){
            switch (user_task.charAt(index)) {
                case '=': {
                    switch (operand.toString()){
                        case "-":{
                            return arg1 - arg2;
                        }
                        case "+":{
                            return arg1 + arg2;
                        }
                        case "*":{
                            return arg1 * arg2;
                        }
                        case ":":{
                            return arg1 / arg2;
                        }
                        case "Nothing":{
                            return -2;
                        }
                    }
                }
                case ' ':{}break;
                default:{
                    return -3;
                }
            }
        }
        return -4;
    }
}
