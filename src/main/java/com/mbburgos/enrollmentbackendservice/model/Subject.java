package com.mbburgos.enrollmentbackendservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Subject (@JsonProperty("subject_id") Long subjectId, @JsonProperty("teacher_id") String teacherId, String title) {
}
