import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("input.txt");
        FileWriter writer = new FileWriter("output.txt");
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
                    writer.write("Error! Not number\n");
                    is = false;
                    break;
                }
            }
            if(m==3) {
                try {
                    b = Double.valueOf(num);
                }catch(NumberFormatException e) {
                    writer.write("Error! Not number\n");
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
                        writer.write("Operation Error!\n");
                        is=false;
                        break;
                    }
                }
            }
        }
        if(is) {
            switch(znak){
                case('+'): writer.write(String.valueOf(a + b));
                    break;
                case('-'): writer.write(String.valueOf(a - b));
                    break;
                case('/'):
                    if(b==0.0) writer.write("Operation Error!\n");
                    else	 writer.write(String.valueOf(a / b));
                    break;
                case('*'): writer.write(String.valueOf(a * b));
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