public class Patient {

    private String name;
    private String dateOfBirth;
    private String region;
    private static int patientCount;
    private int medicalRecordNumber;


    public Patient(String name, String dateOfBirth, String region) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.region = region;
        this.medicalRecordNumber = patientCount+1;
        patientCount++;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", region='" + region + '\'' +
                ", medicalRecordNumber=" + medicalRecordNumber +
                '}';
    }

    public String getName() {
        return name;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getRegion() {
        return region;
    }
    public int getMedicalRecordNumber() {
        return medicalRecordNumber;
    }
    public void setRegion(String region) {
        this.region = region;
    }

    public static Patient createPatient(String passName, String passDateOfBirth, String passRegion){
        return new Patient(passName, passDateOfBirth, passRegion);
    }


}
