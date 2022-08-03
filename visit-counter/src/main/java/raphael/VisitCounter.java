package raphael;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Task 1
 * Raphael Andrade
 * Test for company Amyris
 * http://www.amyris.com/
 */
public class VisitCounter {

    Map<Long, Long> count(Map<String, UserStats>... visits) {
        System.out.println("INIT");
        if(visits == null) {
            return null;
        }

        Map<Long, Long> mapResult = new HashMap<>();
        Arrays.stream(visits).map(m -> processMap(m, mapResult)).collect(Collectors.toList());


        System.out.println("END");
        return mapResult;
    }

    private Map<Long, Long> processMap(Map<String, UserStats> map, Map<Long, Long> mapResult) {

        System.out.println("MapResult Antes: " + mapResult);

        if(map == null) {
            return mapResult;
        }

        for (Map.Entry<String, UserStats> entry : map.entrySet()) {

            if(isMapKeyValid(entry.getKey()) && isMapValueValid(entry.getValue())) {
                Long longKey = generateLongKey(entry.getKey());
                Long count = map.get(entry.getKey()).getVisitCount().get();
                mapResult.compute(longKey, (key, val) -> (val == null) ? 1 : val + count);

                System.out.println("longKey=" + longKey + " , count=" + count + " , mapResult="+ mapResult);
            }
        }

        System.out.println("MapResult Depois: " + mapResult);
        return mapResult;
    }

    private Long generateLongKey(String key) {
        return Long.parseLong(key);
    }

    private boolean isMapValueValid(UserStats value) {
        return value != null && value.getVisitCount().isPresent();
    }

    private boolean isMapKeyValid(String key) {
        if(key == null) {
            return false;
        }

        try {
            Long.parseLong(key);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
