import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.Scanner;
//what it can do: factory generation of Worker subclass objects (PT, OT, Nurse, PTA) and Patient objects. Querrying and adding patient to
                //master list of patients. Querrying, adding and removing patients from a list of patients assigned to clinician.
//what else it should do: Scanner input to fully hide object creation and list functions and quit program. Change pt location to
                // full address and extract zip code. Only allow assignment of patients and clinician in same zipcode. Change therapist
                // location to array of territories clinician assigned to. Change date of birth format perhaps via multiple substrings.
                // limit DOB input format. Each subclass of Worker should have local methods too, such as wound care, balance, etc.
                // each pt should have an arrayList of Medication Ojbects. Perhaps also an ArrayList of HEP exericses such that nothing
                // needs to be copy-pasted from PTA to PTA and instead the HEP arrayList field is updated by both disciplines. Each pt
                // should also have an ArrayList of appointment dates. Each employee should have a time punch and PTO accrual fields to be
                // updated based on hours worked.

public class Main {
    public static void main(String[] args) {
        ArrayList<Patient> masterList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("enter type of worker, name of worker and region of worker");
//        String name = scanner.nextLine();

        //generate Worker
        Worker ryan = Worker.createWorker("physical therapist", "Ryan", "Bellevue");
        Worker becky = Worker.createWorker("occupational therapist", "Becky", "Bellevue");

        //generate Patient
        Patient bob = Patient.createPatient("bob", "01012000", "Bobtown");

        //add Patient to master ArrayList
        addToMasterList(bob, masterList);
        System.out.println(masterList.get(0).getName());

        //add Patient to Worker specific ArrayList
        ryan.addPatient(bob); //has to be an instance calling an instance method. Can't call a static method from Worker
        //class since static method can't access int ArrayList field. Plan for adding patient is to first search the masterlist
        //then search worker-specific list
        becky.addPatient(bob); // bob was added to both ryan and becky without having to re-generate the bob object since masterlist created
        ryan.addPatient(bob);
        ryan.removePatient(bob);
        becky.addPatient(bob);
        System.out.println(bob);
        System.out.println(ryan);
        Patient chuck = Patient.createPatient("Chuck", "12121980","Chuckville");
        System.out.println(chuck);
    }

    public static ArrayList<Patient> addToMasterList(Patient addToMaster, ArrayList<Patient> passMasterList) {
        if (passMasterList.contains(addToMaster)) {
            System.out.println("pt already in master list");
        } else {
            passMasterList.add(addToMaster);
        }
        return passMasterList;

    }



}


// Superclass Employee: Fields: name. Methods: documentation, input orders
//Subclasses of PT,OT,nursing.
//Fields: Patient object alphabetized ArrayList. String PractitionerName. String region
//patient has field of name, age, diagnosis, address, MD
//Methods: Override documentation method to also include call to local methods like 'wound care' or 'balance training'


//what it needs to do: generate objects using scanner, switch and factory method. Inheritance and composition. Then use
// scanner input to hide and call an instance method of a subclass to produce some output/function

//videos 100-102: ComputerFactory: Super class with subclasses nested in the super class. Separate subclass that also
//inherits from the super class with takes the nested subclass objects as some of its fields
//video 103: CompositionChallenge: primary class with fields of separate classes. Fields of primary class constructor
//            set to value of generating a new object. Component classes have no constructors but 1 boolean field for
//            use as a flag such that blank objects are created but getters and setters used. Hiding of subclass methods
//              via primary class method that calls component class and sets field. Another primary class method that
//              produces output from component instance method dependent on set boolean state of instance field.
//exercise 38: Bedroom: no new concepts. Less complex with no hiding of component methods.
//videos 104-105: PlayerEncapsulation: modifying field int values via methods
// exercise 39: EncapsulationChallenge ternary assignment of fields, add/subtract of integer field value with methods.
// ***videos 107-108: moviePolymorphism: compile time vs run time differences. Factory method of new object generation using
// scanner for passing in parameeters, .toUpperCase and .charAt to get char for switch statement and
//generation of new objects for each case. Java.lang.object methods: .getClass(), .getSimpleName().
// to demonstrate assignment of a subclass type object to a super class type variable. overeriding.
//***video 109 and 110: run time vs compile time variables and objects. Use of Object class and var type variable.
// Determining run-time type of an object using 'instanceof' Operator