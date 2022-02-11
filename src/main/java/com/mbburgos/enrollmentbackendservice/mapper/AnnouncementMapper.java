package com.mbburgos.enrollmentbackendservice.mapper;

import com.mbburgos.enrollmentbackendservice.entity.AnnouncementEntity;
import com.mbburgos.enrollmentbackendservice.model.Announcement;
import com.mbburgos.enrollmentbackendservice.model.request.AnnouncementRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnnouncementMapper {

    AnnouncementMapper INSTANCE = Mappers.getMapper(AnnouncementMapper.class);

    Announcement toModel(AnnouncementEntity announcementEntity, String teacherName, String subject);

//    AnnouncementEntity modelToEntity(Announcement announcement);

    @Mapping(target = "id", ignore = true)
    AnnouncementEntity requestToEntity(AnnouncementRequest announcementRequest);
}
