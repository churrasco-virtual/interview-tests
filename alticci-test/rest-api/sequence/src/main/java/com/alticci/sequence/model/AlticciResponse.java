package com.alticci.sequence.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Map;

public class AlticciResponse {

    @NotBlank
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private int n;

    @NotBlank
    @Min(0)
    private long value;

    @NotBlank
    private Map<Integer, Long> map;

    public AlticciResponse(int n, long value, Map<Integer, Long> map) {
        this.n = n;
        this.value = value;
        this.map = map;
    }

    public int getN() {
        return n;
    }

    public long getValue() {
        return value;
    }

    public Map<Integer, Long> getMap() {
        return map;
    }
}
