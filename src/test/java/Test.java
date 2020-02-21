/**
 * User: Chen Liu
 * Date: 2020/1/20
 * Time: 1:32 pm
 */
public class Test {

    public static void cake(int people) {
        double c = 4;
        double a = 1;
        for (int i = 0; i < people; i++) {
            c += Math.pow(8, i) * a / 3 * 4;
            a /= 3;
        }
        System.out.println(c);
    }

    public static void light() {
        double product = 1;
        for (int i = 1; i <= 64; i++) {
            product *= i;
        }
        System.out.println(product);
    }

    public static void main(String[] args) {
//        cake(10);
        light();
    }
}
