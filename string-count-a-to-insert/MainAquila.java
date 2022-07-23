public class MainAquila {
    private static final int LAST_SIZE_AA = 2;

    public static void main(String[] args) {

        System.out.println(solition("aabab"));
        System.out.println(solition("dog"));
        System.out.println(solition("cont"));
        System.out.println(solition("aa"));
        System.out.println(solition("baaa"));

    }

    public static int solition(String base) {
        if (base.contains("aaa")) {
            return -1;
        }
        if (base.equals("aa")) {
            return 0;
        }

        final String replace = base.replace("a", "");
        int contA = base.split("a").length - 1;
        int contReplate = (replace.length() * 2) + LAST_SIZE_AA;


        return contReplate - contA;
    }
}
