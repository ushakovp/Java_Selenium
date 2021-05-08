public class Shapes {

    public static void main(String[] args) {
        Square square = new Square(10);
        System.out.println(square.area());

        Rectangle rectangle = new Rectangle(4, 6);
        System.out.println(rectangle.area());
    }
}
