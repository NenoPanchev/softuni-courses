package PetClinics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<Pet> pets = new ArrayList<>();
        List<Clinic> clinics = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "Create":
                    String objectToCreate = tokens[1];
                    if (objectToCreate.equals("Pet")) {
                        Pet pet = new Pet(tokens[2], Integer.parseInt(tokens[3]), tokens[4]);
                        pets.add(pet);
                    } else if (objectToCreate.equals("Clinic")) {
                        try {
                            Clinic clinic = new Clinic(tokens[2], Integer.parseInt(tokens[3]));
                            clinics.add(clinic);
                        } catch (UnsupportedOperationException ue) {
                            System.out.println(ue.getMessage());
                        }
                    }
                    break;

                case "Add":
                    String petName = tokens[1];
                    String clinicName = tokens[2];
                    try {
                        System.out.println(clinics.stream().filter(clinic -> clinic.getName().equals(clinicName))
                                .findFirst().get().add(petName, pets));
                    } catch (UnsupportedOperationException oue) {
                        System.out.println(oue.getMessage());
                    }
                    break;

                case "Release":
                    clinicName = tokens[1];
                    for (Clinic clinic : clinics) {
                        if (clinic.getName().equals(clinicName)) {
                            System.out.println(clinic.release());
                        }
                    }
                    break;

                case "HasEmptyRooms":
                    clinicName = tokens[1];
                    for (Clinic clinic : clinics) {
                        if (clinic.getName().equals(clinicName)) {
                            System.out.println(clinic.hasSpace());
                        }
                    }
                    break;

                case "Print":
                    clinicName = tokens[1];
                    if (tokens.length == 3) {
                        int room = Integer.parseInt(tokens[2]) - 1;
                        if (clinics.stream().filter(clinic -> clinic.getName().equals(clinicName))
                                .findFirst().get().getList()[room] == null) {
                            System.out.println("Room empty");
                        } else {
                            System.out.println(clinics.stream().filter(clinic -> clinic.getName().equals(clinicName))
                                    .findFirst().get().getList()[room]);
                        }
                    } else {
                        for (Pet pet : clinics.stream().filter(clinic -> clinic.getName().equals(clinicName))
                                .findFirst().get().getList()) {
                            if (pet == null) {
                                System.out.println("Room empty");
                            } else
                            System.out.println(pet);
                        }
                    }
                    break;
            }
        }
    }
}
