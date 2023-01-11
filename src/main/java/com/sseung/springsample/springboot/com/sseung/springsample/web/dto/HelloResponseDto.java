package com.sseung.springsample.springboot.com.sseung.springsample.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    final private String name;
    private final int amount;
}
