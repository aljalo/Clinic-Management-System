package com.example.clinic.mapper;

import com.example.clinic.dto.PatientRequest;
import com.example.clinic.dto.PatientResponse;
import com.example.clinic.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toEntity(PatientRequest patientRequest);

    PatientResponse toResponse(Patient patient);

    void updateEntityFromRequest(PatientRequest patientRequest, @MappingTarget Patient patient);
}
