package com.mbburgos.enrollmentbackendservice.mapper;

import com.mbburgos.enrollmentbackendservice.entity.StudentEntity;
import com.mbburgos.enrollmentbackendservice.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "studentId", target = "id")
    @Mapping(source = "encryptedPassword", target = "password")
    Student toModel(StudentEntity studentEntity);

    @Mapping(source = "id", target = "studentId")
    @Mapping(source = "password", target = "encryptedPassword")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    StudentEntity toEntity(Student student);
}
