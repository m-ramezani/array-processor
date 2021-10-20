package com.example.arrayprocessor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "of")
public class SearchArrayDto {
   @NotNull
   @Size(min = 1)
   private int[] array;

   @NotNull
   private int searchValue;
}
