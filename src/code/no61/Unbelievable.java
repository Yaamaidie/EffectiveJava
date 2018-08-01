package code.no61;

public class Unbelievable {
    public static Integer i;

    public static void main(String[] args) {
        if (i == 42) { //NullPointerException
            System.out.println("Unbelievable");
        }
    }
}
