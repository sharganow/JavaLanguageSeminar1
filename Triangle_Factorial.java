import java.util.Scanner;
public class Triangle_Factorial {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число N: ");
        int n = iScanner.nextInt();
        System.out.printf(
                "Для числа N=%d триугольное число будет равняться: %d",
                n,
                get_triangle_number(n)
        );
        System.out.println("");
        System.out.printf(
                "Для числа N=%d факториал будет равняться: %d",
                n,
                get_factorial_number(n)
        );
    }
    public static int get_triangle_number(int n) {
        int triangle = -1;
        if(n > 0){
            triangle = ((n + 1) * n)/2;
        }
        return triangle;
    }
    public static long get_factorial_number(int n) {
        if (n < 0){
            return -1;
        }
        switch(n){
            case 0:
            case 1:{
                return 1;
            }
            default:{
                long get_n_1 = get_factorial_number(n-1);
                long ret_n_n_1 = n * get_n_1;
                if(get_n_1 > ret_n_n_1){
                    System.out.println("Произошло переполнение при вычислении факториала");
                    ret_n_n_1 = 0;
                }
                return ret_n_n_1;
            }
        }
    }
}
