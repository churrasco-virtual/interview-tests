import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MainAmazon2 {

    public static final String LOCAL_PATH = ".\\teste-amazon-items-containers";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(LOCAL_PATH + "\\entrada2")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(LOCAL_PATH + "\\saida"));

        String s = bufferedReader.readLine();

        int startIndicesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> startIndices = IntStream.range(0, startIndicesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int endIndicesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> endIndices = IntStream.range(0, endIndicesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = numberOfItems(s, startIndices, endIndices);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        List<Integer> retorno = new ArrayList<>();

        for (int i = 0; i < startIndices.size(); i++) {

            int start = startIndices.get(i) - 1;
            int end = endIndices.get(i);
            String substring = s.substring(start, end);
            Matcher matcher = Pattern.compile("\\|([^\\]]*)\\|").matcher(substring);
            int count = 0;
            while (matcher.find()) {
                final int frequency = Collections.frequency(Arrays.asList(matcher.group().split("|")), "*");
                count += frequency;
            }
            retorno.add(count);
        }

        return retorno;
    }
}
