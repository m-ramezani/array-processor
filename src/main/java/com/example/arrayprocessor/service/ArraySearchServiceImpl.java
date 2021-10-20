package com.example.arrayprocessor.service;

import com.example.arrayprocessor.dto.SearchArrayDto;
import com.example.arrayprocessor.dto.SearchResult;
import com.example.arrayprocessor.validator.SearchArrayValidator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArraySearchServiceImpl implements ArraySearchService {

    private final SearchArrayValidator arrayValidator;

    public ArraySearchServiceImpl(SearchArrayValidator arrayValidator) {
        this.arrayValidator = arrayValidator;
    }

    @Override
    public SearchResult searchSumTowNumbers(SearchArrayDto searchArrayDto) {

        arrayValidator.validateSearchArray(searchArrayDto);

        Map<Integer, Integer> elementToDiff = new HashMap<>();
        int searchValue = searchArrayDto.getSearchValue();
        int elementDiff;
        boolean found = false;

        int[] resultArray = new int[2];

        for (int element : searchArrayDto.getArray()) {
            if (element < searchValue && !found) {
                elementDiff = searchValue - element;
                if (elementToDiff.get(elementDiff) == null) {
                    elementToDiff.put(element, elementDiff);
                } else {
                    resultArray[0] = element;
                    resultArray[1] = elementDiff;
                    found = true;
                }
            }
        }

        SearchResult searchResult = SearchResult.of()
                .array(found ? resultArray : null)
                .found(found)
                .build();

        return searchResult;
    }
}
