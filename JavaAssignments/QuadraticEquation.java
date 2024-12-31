import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("Enter coefficients for quadratic equation ax² + bx + c = 0");
        
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();
        
       
        if (a == 0) {
            System.out.println("This is not a quadratic equation as a = 0");
            
            return;
        }
        
        
        double discriminant = b * b - 4 * a * c;
        
     
        if (discriminant > 0) {
            
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.printf("Root 1 = %.2f\n", root1);
            System.out.printf("Root 2 = %.2f\n", root2);
            
        } else if (discriminant == 0) {
           
            double root = -b / (2 * a);
            System.out.printf("Root = %.2f (repeated)\n", root);
            
        } else {
           
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.printf("Root 1 = %.2f + %.2fi\n", realPart, imaginaryPart);
            System.out.printf("Root 2 = %.2f - %.2fi\n", realPart, imaginaryPart);
        }
        
        
    }
}