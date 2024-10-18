package com.example.sb1007.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleBbsDto {
    private int id;
    private String writer;
    private String title;
    private String content;
}