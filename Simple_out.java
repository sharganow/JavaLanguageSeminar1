public class Simple_out {
    public static void main(String[] args) {
        int heap_number = 1000;
        int string_length = 13;
        for(int i = 1; i <= heap_number; ){
            for(int j = 0; j < string_length; j++ ){
                if(i <= heap_number){
                    System.out.printf("%d ", i++);
                }
                else{
                    j = string_length;
                }
            }
            System.out.println("");
        }
    }
}
