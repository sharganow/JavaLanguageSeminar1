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
        String operand = "Nothing";
        String state = "Найти первый аргумент";
        StringBuilder arg = new StringBuilder();
        for(int i = 0; i<user_task.length(); i++){
            switch(state){
                case "Найти первый аргумент": {
                    switch (user_task.charAt(i)) {
                        case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9': {
                            arg.append(user_task.charAt(i));
                        }break;
                        case ',', '.': {
                            arg.append('.');
                        }break;
                        case ' ':{
                            arg1 = Integer.decode(arg.toString());
                            state = "Определить операнд";
                            arg.delete(0, arg.length());
                        }break;
                        case '-', '+', '*', ':': {
                            if (user_task.charAt(i) == '-' && arg.length() == 0) {
                                arg.append(user_task.charAt(i));
                            }
                            else {
                                arg1 = Integer.decode(arg.toString());
                                operand = Character.toString(user_task.charAt(i));
                                state = "Найти второй аргумент";
                                arg.delete(0, arg.length());
                            }
                        }break;
                    }
                }break;
                case "Определить операнд":{
                    switch (user_task.charAt(i)) {
                        case '-', '+', '*', ':': {
                            operand = Character.toString(user_task.charAt(i));
                            state = "Найти второй аргумент";
                        }break;
                    }
                }break;
                case "Найти второй аргумент":{
                    switch (user_task.charAt(i)) {
                        case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9': {
                            arg.append(user_task.charAt(i));
                        }break;
                        case ',', '.': {
                            arg.append('.');
                        }break;
                        case ' ':{
                            if(arg.length() > 0){
                                arg2 = Integer.decode(arg.toString());
                                arg.delete(0, arg.length());
                                state = "Произвести вычисление";
                            }
                        }break;
                        case '-', '=': {
                            if (user_task.charAt(i) == '-' && arg.length() == 0) {
                                arg.append(user_task.charAt(i));
                            } else {
                                arg2 = Integer.decode(arg.toString());
                                state = "Произвести вычисление";
                                switch (user_task.charAt(i)) {
                                    case '=': {
                                        switch (operand){
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
                                        }
                                    }
                                }
                            }
                        }break;
                    }
                }break;
                case "Произвести вычисление":{
                    switch (user_task.charAt(i)) {
                        case '=': {
                            switch (operand){
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
                            }
                        }
                    }
                }break;
            }
        }
        return -1;
    }/**/
}
