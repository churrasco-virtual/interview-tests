package raphael;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


class VisitCounterTest {

    VisitCounter v = new VisitCounter();

    @Test
    void shouldCountCorrectly() {


        Map<String, UserStats> map1 = new HashMap<>();
        map1.put("1", new UserStats(1L));
        map1.put("2", new UserStats(1L));
        map1.put("3", new UserStats(1L));
        map1.put("4", new UserStats(2L));

        Map<String, UserStats> map2 = new HashMap<>();
        map2.put("2", new UserStats(1L));
        map2.put("3", new UserStats(5L));


        Map<Long, Long> result = v.count(map1, map2);

        assertEquals(1L, result.get(1L));
        assertEquals(2L, result.get(2L));
        assertEquals(6L, result.get(3L));
    }

    @Test
    void testEmptyMap() {
        Map<String, UserStats> map1 = new HashMap<>();
        Map<Long, Long> result = v.count(map1);

        assertEquals(true, result.isEmpty());
    }
}