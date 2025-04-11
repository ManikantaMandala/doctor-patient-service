@startuml

class Doctor {
    id: Long,
    name: String,
    specialization: String,
    Appointment: List<Appointment>
}

class Patient {
    id: Long,
    firstName: String,
    lastName: String,
    age: int,
    gender: Gender,
    phoneNumber: String,
    currentAppointment: Appointment
}

class Appointment {
    id: Long,
    time: LocalDateTime,
    doctor: Doctor,
    patient: Patient
}

enum Gender {
    MALE, FEMALE
}

Doctor - Appointment
Patient - Appointment

@enduml