package homework13.question06;

/**
 * Created by Bhanu on 26/04/2016.
 */
public class EuclidGcd {

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

    public static void main(String[] args){
        System.out.println(gcd(4, 16) );
        System.out.println(gcd(5, 25) );
    }
}
