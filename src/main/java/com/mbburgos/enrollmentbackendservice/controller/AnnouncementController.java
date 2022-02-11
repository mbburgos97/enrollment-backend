package com.mbburgos.enrollmentbackendservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbburgos.enrollmentbackendservice.model.Announcement;
import com.mbburgos.enrollmentbackendservice.model.request.AnnouncementRequest;
import com.mbburgos.enrollmentbackendservice.service.AnnouncementService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public record AnnouncementController(AnnouncementService announcementService, ObjectMapper objectMapper) {

    @PostMapping(value = "/announcement", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Announcement createAnnouncement(@RequestBody Map<String, Object> parameters) {
        return announcementService.createAnnouncement(objectMapper.convertValue(parameters, AnnouncementRequest.class));
    }
}
