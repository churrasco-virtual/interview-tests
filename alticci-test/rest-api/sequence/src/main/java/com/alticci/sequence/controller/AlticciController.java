package com.alticci.sequence.controller;

import com.alticci.sequence.model.AlticciResponse;
import com.alticci.sequence.service.AlticciService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/alticci")
@Validated
public class AlticciController {

    private AlticciService service;

    @Autowired
    public AlticciController(AlticciService service) {
        this.service = service;
    }


    @ApiOperation("Get Alticci Sequence")
    @ApiResponse(responseCode = "200",
            description = "Get Alticci Sequence",
            content = { @Content(mediaType = "application/json",
                schema = @Schema(implementation = AlticciResponse.class))})
    @GetMapping("/{n}")
    @Cacheable(value = "sequence")
    public ResponseEntity<?> getSequence(
            @PathVariable("n")
            @Valid
            @Max(Integer.MAX_VALUE)
            @Min(0) int n) {

        AlticciResponse response = service.getSequence(n);

        return ResponseEntity.ok(response);

    }
}