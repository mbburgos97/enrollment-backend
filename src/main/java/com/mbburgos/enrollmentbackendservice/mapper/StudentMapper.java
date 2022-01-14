package com.mbburgos.enrollmentbackendservice.mapper;

import com.mbburgos.enrollmentbackendservice.entity.StudentEntity;
import com.mbburgos.enrollmentbackendservice.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student toModel(StudentEntity studentEntity);

}
