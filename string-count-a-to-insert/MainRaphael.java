package test2;

public class MainRaphael {


    public static void main(String[] args) {
        // "aabab"
        // dog
        // aa
        //
        System.out.println(solution("aa"));
    }

    public static int solution(String S) {

        S = S.toLowerCase();

        if(S.equals("aa")) {
            return 0;
        }

        if(S.contains("aaa")) {
            return -1;
        }

        int totalLetter = S.length();
        int countA = getCountA(S);
        int spaces = ((totalLetter - countA) * 2) - countA + 2;

        return spaces;
    }

    private static int getCountA(String s) {
        int countA = 0;
        for (int i = 0; i < s.length() ; i++) {
            char letter = s.charAt(i);
            if(letter == 'a') {
                countA += 1;
            }
        }
        return countA;
    }
}
