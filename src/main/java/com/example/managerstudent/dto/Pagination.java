package com.example.managerstudent.dto;

import lombok.Data;

@Data
public class Pagination {
    private int page;
    private int totalPage;
    private int size;
    private String search;
    private String column;
    private String order;
}
