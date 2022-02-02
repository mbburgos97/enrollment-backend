package com.mbburgos.enrollmentbackendservice.service;

import com.mbburgos.enrollmentbackendservice.exception.EntityNotFoundException;
import com.mbburgos.enrollmentbackendservice.mapper.SubjectMapper;
import com.mbburgos.enrollmentbackendservice.model.Subject;
import com.mbburgos.enrollmentbackendservice.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public Subject retrieveSubject(Long subjectId) {
        return SubjectMapper.INSTANCE.toModel(subjectRepository.findById(subjectId)
                    .orElseThrow(() -> new EntityNotFoundException("Subject with " + subjectId + " is not found.")));
    }

    public List<Subject> retrieveAllSubjects() {
        return StreamSupport.stream(subjectRepository.findAll().spliterator(), false)
                .map(SubjectMapper.INSTANCE::toModel)
                .toList();
    }
}
