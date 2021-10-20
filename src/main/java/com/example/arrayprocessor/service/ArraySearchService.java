package com.example.arrayprocessor.service;

import com.example.arrayprocessor.dto.SearchArrayDto;
import com.example.arrayprocessor.dto.SearchResult;

public interface ArraySearchService {
    SearchResult searchSumTowNumbers(SearchArrayDto searchArrayDto);
}
