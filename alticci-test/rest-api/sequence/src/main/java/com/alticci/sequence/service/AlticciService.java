package com.alticci.sequence.service;

import com.alticci.sequence.model.AlticciResponse;
import com.alticci.sequence.utils.SequenceUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AlticciService {


    public AlticciResponse getSequence(Integer n) {

        Map<Integer, Long> sequence = new HashMap();
        long value = SequenceUtils.getSequence(n, sequence);

        AlticciResponse response = new AlticciResponse(n, value, sequence);

        return response;
    }
}
