package Entity;

public class SumService {
    public static String doSum(String valueOf) {

        int i = valueOf.indexOf(".");
        return valueOf.substring(0,i+3);
    }
}
