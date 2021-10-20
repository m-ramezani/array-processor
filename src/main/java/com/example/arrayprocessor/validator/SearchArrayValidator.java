package com.example.arrayprocessor.validator;

import com.example.arrayprocessor.dto.SearchArrayDto;
import com.example.arrayprocessor.exception.ArrayIsEmptyException;
import org.springframework.stereotype.Component;

@Component
public class SearchArrayValidator {
    public void validateSearchArray(SearchArrayDto searchArrayDto) {
        if (searchArrayDto.getArray().length < 1) {
            throw new ArrayIsEmptyException("Array must not be empty");
        }
    }
}
