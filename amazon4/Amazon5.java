import java.util.Arrays;
import java.util.List;

public class Amazon5 {

    public static void main(String[] args) {

        List<Integer> lista = Arrays.asList(2, 1, 3);


        System.out.println( findTotalPower(lista));
    }


    public static int findTotalPower(List<Integer> power) {

        Integer[][] matrix = new Integer[power.size()][power.size()];

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(" ");
            for (int j = i; j < matrix.length; j++) {
                matrix[i][j] = power.get(j);
                System.out.print(" " + matrix[i][j]);
            }
        }
            System.out.println(" ");
        int resultado = 0;
        for (int i = 0; i < matrix.length; i++) {

            for (int j = i; j < matrix.length; j++) {
                System.out.print("min -> "+min(matrix,i,j) + " * ");
                System.out.println("sum -> "+sum(matrix,i,j));
                resultado += min(matrix,i,j) * sum(matrix,i,j);
            }
        }
        return resultado;
    }

    static int min(Integer[][] matrix, int i, int j) {
        int retorno = Integer.MAX_VALUE;

        for (int j2 = i; j2 <= i; j2--) {
            if (matrix[i][j2] < retorno) {
                retorno = matrix[i][j2].intValue();
            }
        }
        return retorno;
    }

    static int sum(Integer[][] matrix, int i, int j) {
        int retorno = 0;

        for (int j2 = i; j2 < i; j2--) {
            retorno += matrix[i][j2].intValue();
        }
        return retorno;
    }


}
