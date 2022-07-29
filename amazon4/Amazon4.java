import java.util.*;

public class Amazon4 {

    public static void main(String[] args) {

        List<String> lista = Arrays.asList("corn",
                "horn",
                "dpso",
                "eqtp",
                "corn");


        countFamilyLogins(lista);
    }



    public static int countFamilyLogins(List<String> logins) {
        int countMember=0;
        Set family = new HashSet<>();
        for (int i = 0; i < logins.size(); i++) {

            for (int j = i; j < logins.size(); j++) {
                if( isFamily(logins.get(i),logins.get(j))){
                    countMember++;
                }
            }

        }

        return countMember;

    }
    private static boolean isFamily(String a, String b){
        char[] palavraA= a.toCharArray();
        char[] palavraB= b.toCharArray();
        Arrays.sort(palavraA);
        Arrays.sort(palavraB);
        int count=0;

        int ascA = (int)palavraA[0];
        int ascB = (int)palavraB[0];
        if(ascA-ascB==1 ||ascA-ascB==-1 ){
            count++;
        }



        return ascA-ascB==1 ||ascA-ascB==-1;
    }



}
