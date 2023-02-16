import java.lang.Double;
public class Simple_calculator {
    public static void main(String[] args) {
        System.out.println("Напишите задание для калькулятора в виде \"12 * 3 = \" без кавычек: ");
 //       Scanner iScanner = new Scanner(System.in);
        String user_task = "-12 - 2.456 =";
                //iScanner.toString();
//        iScanner.close();
        System.out.printf(user_task);
        System.out.println(execute_task(user_task));
    }
    public static double execute_task(String user_task) {
        double arg1 = 0;
        double arg2 = 0;
        String operand = "Nothing";
        String state = "Найти первый аргумент";
        StringBuilder arg = new StringBuilder();
        for(int i = 0; i<user_task.length(); i++){
            switch(state){
                case "Найти первый аргумент": {
                    switch (user_task.charAt(i)) {
                        case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9': {
                            arg.append(user_task.charAt(i));
                        }
                        case ',', '.': {
                            arg.append('.');
                        }
                        case ' ':{
                            arg1 = Double.parseDouble(arg.toString());
                            state = "Определить операнд";
                            arg.delete(0, arg.length()-1);
                        }
                        case '-', '+', '*', ':': {
                            if (user_task.charAt(i) == '-' && arg.length() == 0) {
                                arg.append(user_task.charAt(i));
                            }
                            else {
                                arg1 = Double.parseDouble(arg.toString());
                                operand = Character.toString(user_task.charAt(i));
                                state = "Найти второй аргумент";
                                arg.delete(0, arg.length()-1);
                            }
                        }
                    }
                }
                case "Определить операнд":{
                    switch (user_task.charAt(i)) {
                        case '-', '+', '*', ':': {
                            operand = Character.toString(user_task.charAt(i));
                            state = "Найти второй аргумент";
                        }
                    }
                }
                case "Найти второй аргумент":{
                    switch (user_task.charAt(i)) {
                        case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9': {
                            arg.append(user_task.charAt(i));
                        }
                        case ',', '.': {
                            arg.append('.');
                        }
                        case ' ':{
                            arg2 = Double.parseDouble(arg.toString());
                            state = "Произвести вычисление";
                        }
                        case '-', '=': {
                            if (user_task.charAt(i) == '-' && arg.length() == 0) {
                                arg.append(user_task.charAt(i));
                            } else {
                                arg2 = Double.parseDouble(arg.toString());

                            }
                        }
                    }
                }
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
                }
            }
        }
        return -1;
    }/**/
}
