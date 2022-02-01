package com.mbburgos.enrollmentbackendservice.mapper;

import com.mbburgos.enrollmentbackendservice.entity.TeacherEntity;
import com.mbburgos.enrollmentbackendservice.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @Mapping(source = "teacherId", target = "id")
    @Mapping(source = "encryptedPassword", target = "password")
    Teacher toModel(TeacherEntity teacherEntity);

    @Mapping(source = "id", target = "teacherId")
    @Mapping(source = "password", target = "encryptedPassword")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    TeacherEntity toEntity(Teacher teacher);
}
