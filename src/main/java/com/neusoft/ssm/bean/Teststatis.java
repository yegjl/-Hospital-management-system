package com.neusoft.ssm.bean;

public class Teststatis {
    private String medicalRecordNo;
    private String patientName;

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @Override
    public String toString() {
        return "Teststatis{" +
                "medicalRecordNo='" + medicalRecordNo + '\'' +
                ", patientName='" + patientName + '\'' +
                '}';
    }
}
