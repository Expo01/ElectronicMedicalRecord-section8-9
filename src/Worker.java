import java.util.ArrayList;

public class Worker {

    private String name;
    private String region; //this would be better as an array of zipcodes since that's really how territory is divided
    private ArrayList<Patient> clinicianPatientList;

    public Worker(String name, String region) {
        this.name = name;
        this.region = region;
        clinicianPatientList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", clinicianPatientList=" + clinicianPatientList +
                '}';
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void addPatient(Patient patient){
        if(clinicianPatientList.contains(patient)){
            System.out.println("pt " + patient.getName() + " already in "  + this.name + "'s patient list");
        } else {
            clinicianPatientList.add(patient);
            System.out.println("patient " + patient.getName() + " added to " + this.name + "'s patient list");
        }

    }

    public void removePatient(Patient patient){
        if(!clinicianPatientList.contains(patient)){
            System.out.println("pt " + patient.getName() + " not in "  + this.name + "'s patient list");
        } else {
            clinicianPatientList.remove(patient);
            System.out.println("patient " + patient.getName() + " removed from " + this.name + "'s patient list");
        }

    }


    public void getWorkerType(){
        String workerType = this.getClass().getSimpleName();
        System.out.println(name + " is a " + workerType);
    }

    public static Worker createWorker(String title, String passName, String passRegion){
        return switch(title.toUpperCase().substring(0,3)){
            case "PHY" -> new PhysicalTherapist(passName,passRegion);
            case "NUR" -> new Nurse(passName,passRegion);
            case "PTA" -> new PhysicalTherapyAssistant(passName,passRegion);
            case "OCC" -> new OccupationalTherapist(passName,passRegion);
            default -> new Worker(passName,passRegion);
        };
    }

    public void doWork(){
        System.out.println("doing work stuff");
    }

}

class PhysicalTherapist extends Worker{
    public PhysicalTherapist(String name, String region) {
        super(name, region);
    }

    @Override
    public void doWork() {
        System.out.println("doing PT stuff");
    }

    @Override
    public String getRegion() {
        return super.getRegion();
    }

    @Override
    public void setRegion(String region) {
        super.setRegion(region);
    }
}

class PhysicalTherapyAssistant extends PhysicalTherapist{
    public PhysicalTherapyAssistant(String name, String region) {
        super(name, region);
    }
}

class Nurse extends Worker{
    public Nurse(String name, String region) {
        super(name, region);
    }
}

class OccupationalTherapist extends Worker{
    public OccupationalTherapist(String name, String region) {
        super(name, region);
    }
}

