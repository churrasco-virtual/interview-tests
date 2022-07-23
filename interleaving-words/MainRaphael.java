package test3;

public class MainRaphael {


    public static void main(String[] args) {
        System.out.println(solution("abc", "def", "abdcef"));
    }

    public static boolean solution(String S, String T, String U) {
        String firstWord = S.trim();
        String secondWord = T.trim();
        String resultWord = U.trim();

        if(resultWord.length() != (firstWord.length() + secondWord.length())) {
            return false;
        }

        for(char c: resultWord.toCharArray()) {

            if(firstWord.length() > 0 && (c == firstWord.charAt(0))) {
                firstWord = firstWord.replace(c+"", "");

            } else if(secondWord.length() > 0 && (c == secondWord.charAt(0))) {
                secondWord = secondWord.replace(c+"", "");

            } else {
                return false;
            }
        }
        return true;
    }

}
