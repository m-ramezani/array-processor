package com.example.arrayprocessor.unit.service;

import com.example.arrayprocessor.dto.SearchArrayDto;
import com.example.arrayprocessor.dto.SearchResult;
import com.example.arrayprocessor.exception.ArrayIsEmptyException;
import com.example.arrayprocessor.service.ArraySearchServiceImpl;
import com.example.arrayprocessor.validator.SearchArrayValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SearchArrayServiceTest {
    @InjectMocks
    private ArraySearchServiceImpl arraySearchService;

    @Mock
    private SearchArrayValidator searchArrayValidator;

    @Test
    public void search_sum_tow_numbers() {
        SearchArrayDto searchArrayDto = createSearchArrayDto();
        doNothing().when(searchArrayValidator).validateSearchArray(searchArrayDto);
        SearchResult searchResult = arraySearchService.searchSumTowNumbers(searchArrayDto);
        assertTrue(searchResult.isFound());
        assertEquals(searchResult.getArray().length, 2);
        assertEquals(searchResult.getArray()[1] + searchResult.getArray()[0], searchArrayDto.getSearchValue());
    }

    @Test
    public void search_sum_tow_numbers_when_search_value_not_found() {
        SearchArrayDto searchArrayDto = createSearchArrayDto();
        searchArrayDto.setSearchValue(100);
        doNothing().when(searchArrayValidator).validateSearchArray(searchArrayDto);
        SearchResult searchResult = arraySearchService.searchSumTowNumbers(searchArrayDto);
        assertFalse(searchResult.isFound());
        assertNull(searchResult.getArray());
    }

    @Test(expected = ArrayIsEmptyException.class)
    public void search_sum_tow_numbers_when_array_is_empty() {
        SearchArrayDto searchArrayDto = createSearchArrayDto();
        doThrow(ArrayIsEmptyException.class).when(searchArrayValidator).validateSearchArray(any());
        arraySearchService.searchSumTowNumbers(searchArrayDto);
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
