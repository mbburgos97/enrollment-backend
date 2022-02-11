package com.mbburgos.enrollmentbackendservice.model;

public record Announcement(Long id, String teacherName, String title, String content,
                           String subject) {
}
