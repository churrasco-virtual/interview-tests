import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MainAmazon {

    public static final String LOCAL_PATH = ".\\teste-amazon-transaction-log";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(LOCAL_PATH + "\\entrada")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(LOCAL_PATH +"\\saida"));

        int logsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> logs = IntStream.range(0, logsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int threshold = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = processLogs(logs, threshold);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static List<String> processLogs(List<String> logs, int threshold) {
        List<String> retorno = new ArrayList<>();
        List<Integer> account = new ArrayList<>();

        final Map<Integer, Integer> idQuantidade = new HashMap<>();

        logs.stream().forEach(p -> {
            final String[] s = p.split(" ");
            if (Integer.parseInt(s[0]) == Integer.parseInt(s[1])) {

                account.add(Integer.parseInt(s[0]));
            } else {
                account.add(Integer.parseInt(s[0]));
                account.add(Integer.parseInt(s[1]));

            }
        });
        final Set<Integer> keys = account.stream().collect(Collectors.toSet());
        keys.forEach(value -> {
                    idQuantidade.put(value, Collections.frequency(account, value));
                }
        );
        for (Integer key : keys) {
            if (idQuantidade.get(key) >= threshold) {

                retorno.add(key.toString());
            }
        }
//        idQuantidade.values().stream().filter(rep-> rep>=threshold);
        return retorno;
    }
}
