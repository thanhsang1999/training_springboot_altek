package com.example.managerstudent.mapper;

public interface IStudentMapper<D,E> {
    D convertToDTO(E entity);
    E convertToEntity(D dto);
}
