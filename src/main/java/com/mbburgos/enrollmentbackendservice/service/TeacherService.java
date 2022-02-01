package com.mbburgos.enrollmentbackendservice.service;

import com.mbburgos.enrollmentbackendservice.exception.EntityNotFoundException;
import com.mbburgos.enrollmentbackendservice.mapper.TeacherMapper;
import com.mbburgos.enrollmentbackendservice.model.Teacher;
import com.mbburgos.enrollmentbackendservice.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public Teacher retrieveTeacher(String teacherId) {
        return TeacherMapper.INSTANCE.toModel(teacherRepository.findById(teacherId)
                .orElseThrow(() -> new EntityNotFoundException("Teacher with id " + teacherId + " not found.")));
    }

    public List<Teacher> retrieveAllTeachers() {
        return StreamSupport.stream(teacherRepository.findAll().spliterator(), false)
                .map(TeacherMapper.INSTANCE::toModel)
                .toList();
    }

    public Teacher createTeacher(Teacher teacher) {
        return TeacherMapper.INSTANCE.toModel(
                teacherRepository.save(TeacherMapper.INSTANCE.toEntity(teacher)));
    }
}
