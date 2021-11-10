package com.example.managerstudent.dto;

import lombok.Data;

import java.util.List;
@Data
public class ListStudentWithPagi {
    private List<StudentDTO> data;
    private Pagination pagination;
}
