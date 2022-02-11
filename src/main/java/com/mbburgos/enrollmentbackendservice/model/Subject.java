package com.mbburgos.enrollmentbackendservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Subject (Long id, @JsonProperty("teacher_id") String teacherId, String title) {
}
