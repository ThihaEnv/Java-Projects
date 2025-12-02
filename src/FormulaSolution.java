import java.util.Scanner;

public class FormulaSolution {
    public static void main(String[] args) {

        // var declaration
        double radius;
        double circumference;
        double area;
        double volume;

        Scanner input = new Scanner(System.in);

        //request input value
        System.out.print("Enter radius value : ");
        radius = input.nextDouble();

        //circumference calculation
        circumference = 2 * Math.PI * radius;

        //circle area calculation
        area = Math.PI * Math.pow(radius,2);

        // circle volume calculation
//        volume = (4.0/3.0) * Math.PI * Math.pow(radius,3);
        volume = ((double)4/3) * Math.PI * Math.pow(radius,3);

        //showing answers
        System.out.println("The circumference of the circle is " + circumference);
        System.out.println("The area of the circle is " + area);
        System.out.println("The volume of sphere is " + volume);

        //input close
        input.close();
    }
}
