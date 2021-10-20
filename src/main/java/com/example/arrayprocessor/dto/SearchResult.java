package com.example.arrayprocessor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "of")
public class SearchResult {
   boolean found;
   private int[] array;
}
