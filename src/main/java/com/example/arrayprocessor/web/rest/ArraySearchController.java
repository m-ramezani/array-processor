package com.example.arrayprocessor.web.rest;


import com.example.arrayprocessor.dto.SearchArrayDto;
import com.example.arrayprocessor.dto.SearchResult;
import com.example.arrayprocessor.service.ArraySearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/array-search")
public class ArraySearchController {
    private final ArraySearchService arraySearchService;

    public ArraySearchController(ArraySearchService arraySearchService) {
        this.arraySearchService = arraySearchService;
    }


    @GetMapping("/search-sum-tow-number")
    public ResponseEntity<SearchResult> searchSumTowNumbers(@RequestBody @Valid SearchArrayDto searchArrayDto) {
        return ResponseEntity.ok(arraySearchService.searchSumTowNumbers(searchArrayDto));
    }

}
