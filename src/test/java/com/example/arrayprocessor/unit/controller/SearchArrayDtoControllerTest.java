package com.example.arrayprocessor.unit.controller;

import com.example.arrayprocessor.dto.SearchArrayDto;
import com.example.arrayprocessor.dto.SearchResult;
import com.example.arrayprocessor.service.ArraySearchServiceImpl;
import com.example.arrayprocessor.web.rest.ArraySearchController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SearchArrayDtoControllerTest {
    @InjectMocks
    ArraySearchController arraySearchController;

    @Mock
    ArraySearchServiceImpl arraySearchService;


    @Test
    public void search_sum_tow_numbers() {
        SearchArrayDto searchArrayDto = createSearchArrayDto();
        SearchResult mockResult = new SearchResult();

        when(arraySearchService.searchSumTowNumbers(searchArrayDto)).thenReturn(mockResult);
        arraySearchController.searchSumTowNumbers(searchArrayDto).getBody();
        verify(arraySearchService, atMostOnce()).searchSumTowNumbers(any());
    }

    private SearchArrayDto createSearchArrayDto() {
        int[] array = {2, 20, 4, 3, 5, 10, 8};
        SearchArrayDto searchArrayDto = SearchArrayDto.of()
                .array(array)
                .searchValue(13)
                .build();

        return searchArrayDto;
    }

}
