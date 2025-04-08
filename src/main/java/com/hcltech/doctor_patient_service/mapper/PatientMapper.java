package com.hcltech.doctor_patient_service.mapper;

import com.hcltech.doctor_patient_service.dto.PatientDto;
import com.hcltech.doctor_patient_service.model.Patient;
import com.hcltech.doctor_patient_service.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {
    PatientService patientService;
    public PatientMapper(PatientService patientService){
        this.patientService=patientService;
    }
public PatientDto insert1(PatientDto p)
{
    Patient p1=toEntity(p);
   Patient p2= patientService.insert2(p1);
    return toDto(p2);
}

public PatientDto update1(PatientDto p)
{
    Patient p1=toEntity(p);
  Patient p2= patientService.update2(p1);
    return toDto(p2);
}



//-----------------------------------------------------------------------------------------
    public Patient toEntity(PatientDto p)
    {
        Patient p1=new Patient();
        p1.setId(p.getId());
        p1.setAge(p.getAge());
        p1.setFirstName(p.getFirstname());
        p1.setLastname(p.getLastname());
        return p1;
    }

    public PatientDto toDto(Patient p2){
        PatientDto p3=new PatientDto();
        p3.setId(p2.getId());
        p3.setFirstname(p2.getFirstName());
        p3.setLastname(p2.getLastname());
        p3.setFullname(p2.getFirstName()+p2.getLastname());
        p3.setAge(p2.getAge());
        return p3;
    }

}
