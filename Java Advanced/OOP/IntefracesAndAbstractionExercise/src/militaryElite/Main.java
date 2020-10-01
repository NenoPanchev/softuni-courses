package militaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Private> privatesList = new ArrayList<>();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String typeOfSoldier = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (typeOfSoldier) {
                case "Private":
                    double salary = Double.parseDouble(tokens[4]);
                    PrivateImpl priv = new PrivateImpl(id, firstName, lastName, salary);
                    privatesList.add(priv);
                    System.out.println(priv);
                    break;

                case "LieutenantGeneral":
                    salary = Double.parseDouble(tokens[4]);
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    for (int i = 5; i < tokens.length; i++) {
                        for (Private aPrivate : privatesList) {
                            if (aPrivate.getId() == Integer.parseInt(tokens[i])) {
                                lieutenantGeneral.addPrivate(aPrivate);
                            }
                        }
                    }
                    System.out.println(lieutenantGeneral);
                    break;

                case "Engineer":
                    salary = Double.parseDouble(tokens[4]);
                    String corps = tokens[5];
                    try {
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < tokens.length; i += 2) {
                            Repair repair = new Repair(tokens[i], Integer.parseInt(tokens[i + 1]));
                            engineer.addRepair(repair);
                        }
                        System.out.println(engineer);
                    } catch (IllegalArgumentException e) {
                        continue;
                    }
                    break;

                case "Commando":
                    salary = Double.parseDouble(tokens[4]);
                    corps = tokens[5];
                    try {
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < tokens.length; i += 2) {
                            try {
                                Mission mission = new Mission(tokens[i], tokens[i + 1]);
                                commando.addMission(mission);
                            } catch (IllegalArgumentException e) {
                                continue;
                            }
                        }
                        System.out.println(commando);
                    } catch (IllegalArgumentException e) {
                        continue;
                    }
                    break;

                case "Spy":
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, Integer.parseInt(tokens[4]));
                    System.out.println(spy);
                    break;
            }
            input = scan.nextLine();
        }
    }
}
