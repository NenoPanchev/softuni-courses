package footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Team> teamList = new ArrayList<>();
        while (!"END".equals(input)) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String teamName = tokens[1];
            try {

                switch (command) {
                    case "Team":
                        Team team = new Team(teamName);
                        teamList.add(team);
                        break;

                    case "Add":
                        Team team1 = Validator.validateTeam(teamList, teamName);
                        Player player = new Player(tokens[2],
                                Integer.parseInt(tokens[3]),
                                Integer.parseInt(tokens[4]),
                                Integer.parseInt(tokens[5]),
                                Integer.parseInt(tokens[6]),
                                Integer.parseInt(tokens[7]));
                        team1.addPlayer(player);
                        break;

                    case "Remove":
                        Validator.validateTeam(teamList, teamName).removePlayer(tokens[2]);
                        break;

                    case "Rating":
                        System.out.printf("%s - %.0f%n",
                                teamName,
                                Validator.validateTeam(teamList, teamName).getRating());
                        break;

                }
            } catch (IllegalArgumentException ignored) {
                System.out.println(ignored.getMessage());
            }
            input = scan.nextLine();
        }
    }
}
