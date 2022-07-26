import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class MainAmazon3 {

    public static final String LOCAL_PATH = ".\\teste-amazon-gifting-groups";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(LOCAL_PATH + "\\entrada")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(LOCAL_PATH + "\\saida"));

        int relatedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> related = IntStream.range(0, relatedCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int result = countGroups(related);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int countGroups(List<String> related) {


        String[][] matrix = new String[related.size()][related.size()];

        for (int i = 0; i < related.size(); i++) {
            matrix[i] = related.get(i).split("");
        }
        int countDirectGroup=0;
        int countIndirectGroup=0;

        for (int i = 0; i < matrix.length; i++) {
            System.out.println("");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" "+matrix[i][j]);
                int correspondente =  Integer.parseInt(matrix[i][j]);
                int assinate =  Integer.parseInt(matrix[j][i]);
                if (correspondente==1 ){

                    if (correspondente==assinate && i==j  ){
                        countDirectGroup++;
                        break;

                    }else if (correspondente==assinate && i!=j ){
                        countIndirectGroup++;
                    }

                }
            }
        }
        System.out.println(countDirectGroup-countIndirectGroup);
        return countIndirectGroup>0? Math.abs(countDirectGroup-countIndirectGroup):countDirectGroup;
    }
}
