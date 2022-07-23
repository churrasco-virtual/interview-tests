package com.alticci.sequence.utils;

import java.util.Map;

public class SequenceUtils {

    public static long getSequence(int n, Map<Integer, Long> sequence) {

        if(n == 0) {
            sequence.put(n, 0L);
            return 0;
        }

        if(n == 1) {
            sequence.put(n, 1L);
            return 1;
        }

        if(n == 2) {
            sequence.put(n, 1L);
            return 1;
        }

        long result = (getSequence(n-3, sequence)) + (getSequence(n-2, sequence));
        sequence.put(n, result);
        return result;

    }
}