package teste1;

import java.util.Arrays;
import java.util.List;

public class MainRaphael {


    public static void main(String[] args) {
        System.out.println(solution("PPPPRRSSSSS"));
    }

    public static int solution(String G) {
        int result = 0;

        if(G == null || G.isEmpty() || G.length() > 100) {
            return -1;
        }

        G = G.toUpperCase();

        char[] gArray = G.toCharArray();

        int rockPoints = getFrancoPoints(gArray, 'R');
        int paperPoints = getFrancoPoints(gArray, 'P');
        int scissorsPoints = getFrancoPoints(gArray, 'S');


        List<Integer> resultArray = Arrays.asList(rockPoints, paperPoints, scissorsPoints);

        return resultArray.stream().max(Integer::compare).get();
    }


    private static int getFrancoPoints(char[] gArray, char f) {
        int totalPoints = 0;
        for(int i = 0; i < gArray.length; i++) {
            char g = gArray[i];
            totalPoints = totalPoints + calculateFrancoPoints(f, g);
        }

        return totalPoints;
    }

    private static int calculateFrancoPoints(char f, char g) {
        System.out.println("f="+f + " , g="+g);
        if(g == f) {
            return 1;
        }

        String str = ""+f+g;
        System.out.println("str= " + str);
        switch (str) {
            case "RS": return 2;
            case "SP": return 2;
            case "PR": return 2;
            default: return 0;
        }
    }
}
