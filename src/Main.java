import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        double a = 0.0;
        double b = 0.0;
        char znak = ' ';
        int m=0;
        boolean is = true;
        for(String num:line.split(" ")) {
            m++;
            if(m==1) {
                try {
                    a = Double.valueOf(num);
                }catch(NumberFormatException e) {
                    System.out.print("Error! Not number\n");
                    is = false;
                    break;
                }
            }
            if(m==3) {
                try {
                    b = Double.valueOf(num);
                }catch(NumberFormatException e) {
                    System.out.print("Error! Not number\n");
                    is = false;
                    break;
                }
            }
        }
        if(is) {
            m=0;
            for(String num:line.split(" ")) {
                m++;
                if(m==2) {
                    try {
                        znak = result(num,znak);
                    }catch(Exception s){
                        System.out.print("Operation Error!");
                        is=false;
                        break;
                    }
                }
            }
        }
        if(is) {
            switch(znak){
                case('+'): System.out.print(a + b);
                    break;
                case('-'): System.out.print(a - b);
                    break;
                case('/'):
                    if(b==0.0) System.out.print("Error! Division by zero");
                    else	 System.out.print(a / b);
                    break;
                case('*'): System.out.print(a * b);
                    break;
            }
        }

    }
    public static char result(String nms, char znak) throws Exception {
        if(nms.equals("/") || nms.equals("*") || nms.equals("+") || nms.equals("-")) {
            znak = nms.charAt(0);
            return znak;
        }
        else throw new Exception("OperationError");
    }
}