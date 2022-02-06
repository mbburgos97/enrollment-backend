package com.mbburgos.enrollmentbackendservice.service;

import com.mbburgos.enrollmentbackendservice.exception.EntityNotFoundException;
import com.mbburgos.enrollmentbackendservice.mapper.StudentMapper;
import com.mbburgos.enrollmentbackendservice.model.Student;
import com.mbburgos.enrollmentbackendservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student retrieveStudent(String studentId) {
        return StudentMapper.INSTANCE.toModel(studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + studentId + " not found.")));
    }

    public List<Student> retrieveAllStudents() {
        return StreamSupport.stream(studentRepository.findAll().spliterator(), false)
                .map(StudentMapper.INSTANCE::toModel)
                .toList();
    }

    public Student createStudent(Student student) {
        System.out.println(student);
        return StudentMapper.INSTANCE.toModel(
                studentRepository.save(StudentMapper.INSTANCE.toEntity(student)));
    }
}
