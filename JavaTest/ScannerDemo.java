import java.util.Scanner;
 
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("input: ");
        //line1
        int line1_data1 = 0;
        float line1_data2 = 0.0f;
        double line1_data3 = 0;
        //line2
        String line2 = "";
        //line3
        String line3_data1 = "";
        String line3_data2 = "";

        if(scan.hasNext()) {

            line1_data1 = scan.nextInt();
            line1_data2 = scan.nextFloat();
            line1_data3 = scan.nextDouble();
            scan.nextLine();    //finish line1

            line2 = scan.nextLine(); //finish line2

            line3_data1 = scan.next();
            line3_data2 = scan.next();
            scan.nextLine(); //finish line3

        }
        scan.close();

        System.out.println("line1_data1: " + line1_data1);
        System.out.println("line1_data2: " + line1_data2);
        System.out.println("line1_data3: " + line1_data3);
        System.out.println("line2: " + line2);
        System.out.println("line3_data1: " + line3_data1);
        System.out.println("line3_data2: " + line3_data2);

    }
}
