package com.mbburgos.enrollmentbackendservice.service;

import com.mbburgos.enrollmentbackendservice.exception.EntityNotFoundException;
import com.mbburgos.enrollmentbackendservice.mapper.AnnouncementMapper;
import com.mbburgos.enrollmentbackendservice.model.Announcement;
import com.mbburgos.enrollmentbackendservice.model.request.AnnouncementRequest;
import com.mbburgos.enrollmentbackendservice.repository.AnnouncementRepository;
import com.mbburgos.enrollmentbackendservice.repository.SubjectRepository;
import com.mbburgos.enrollmentbackendservice.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    private final TeacherRepository teacherRepository;

    private final SubjectRepository subjectRepository;

    public Announcement createAnnouncement(AnnouncementRequest request) {
        var entity = announcementRepository.save(
                AnnouncementMapper.INSTANCE.requestToEntity(request));
        return AnnouncementMapper.INSTANCE.toModel(entity,
                teacherRepository.findById(request.teacherId())
                        .orElseThrow(() -> new EntityNotFoundException("Teacher ID " + request.teacherId() + " not found."))
                        .getLastName(),
                subjectRepository.findById(request.subjectId())
                        .orElseThrow(() -> new EntityNotFoundException("Subject ID " + request.subjectId() + " not found."))
                        .getTitle());
    }
}
