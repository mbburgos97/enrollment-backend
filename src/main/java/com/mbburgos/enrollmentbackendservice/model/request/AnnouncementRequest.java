package com.mbburgos.enrollmentbackendservice.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AnnouncementRequest(@JsonProperty("teacher_id") String teacherId, @JsonProperty("subject_id") Long subjectId,
                                  String title, String content) {
}
