package com.mbburgos.enrollmentbackendservice.service;

import com.mbburgos.enrollmentbackendservice.exception.EntityNotFoundException;
import com.mbburgos.enrollmentbackendservice.mapper.SubjectMapper;
import com.mbburgos.enrollmentbackendservice.model.Subject;
import com.mbburgos.enrollmentbackendservice.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public Subject retrieveSubject(Long subjectId) {
        return SubjectMapper.INSTANCE.toModel(subjectRepository.findById(subjectId)
                    .orElseThrow(() -> new EntityNotFoundException("Subject with " + subjectId + " is not found.")));
    }
}
