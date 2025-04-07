@startuml

class Doctor {
    id: UUID,
    name: String,
    description: String,
    isAvaiable: boolean,
    patients: List<Patient>
}

class Patient {
    id: UUID,
    name: String,
    doctorAssigned: boolean,
    currentDoctor: Doctor
}

Doctor --- Patient

@enduml