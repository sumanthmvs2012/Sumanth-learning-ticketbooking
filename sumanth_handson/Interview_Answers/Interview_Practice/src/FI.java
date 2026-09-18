public class FI
{
    public static void main(String[] args)
    {
        Calculator addition = (a, b) -> a + b;

        Calculator multiplication = (a, b) -> a * b;

        System.out.println("Addition: " + addition.operation(10, 20));

        System.out.println("Multiplication: "+ multiplication.operation(10, 20));
    }

}
