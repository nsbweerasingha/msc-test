package com.example.gscomp285.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
	@NotNull(message = "Student ID cannot be null")
	@Schema(description = "required field")
	@JsonProperty("studentID")
	private int studentID;

	@NotNull(message = "Student First Name")
	@Schema(description = "required field")
	@JsonProperty("firstName")
	private String firstName;

	@NotNull(message = "Student Last Name")
	@Schema(description = "required field")
	@JsonProperty("lastName")
	private String lastName;
}
