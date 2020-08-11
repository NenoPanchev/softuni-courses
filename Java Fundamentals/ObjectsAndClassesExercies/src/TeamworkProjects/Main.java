package TeamworkProjects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<Team> teamList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] tokens = scan.nextLine().split("-");

            if (i != 0 && isCreator(tokens[0], teamList)) {
                System.out.printf("%s cannot create another team!%n", tokens[0]);
            } else if (i != 0 && teamExists(tokens[1], teamList)) {
                System.out.printf("Team %s was already created!%n", tokens[1]);
            } else {
                Team currentTeam = new Team();
                currentTeam.setCreator(tokens[0]);
                currentTeam.setName(tokens[1]);
                List<String> users = new ArrayList<>();
                currentTeam.setUsers(users);
                teamList.add(currentTeam);
                System.out.printf("Team %s has been created by %s!%n", currentTeam.getName(), currentTeam.getCreator());
            }
        }
        String input = scan.nextLine();
        while (!input.equals("end of assignment")) {
            String[] tok = input.split("->");
            String user = tok[0];
            String teamName = tok[1];

            if (!teamExists(teamName, teamList)) {
                System.out.printf("Team %s does not exist!%n", teamName);
            }

            if (!isCreator(user, teamList) && teamExists(teamName, teamList)) {
                for (int i = 0; i < teamList.size(); i++) {
                    if (teamList.get(i).getName().equals(teamName))
                        teamList.get(i).getUsers().add(user);
                }
            }

            if (isCreator(user, teamList) && teamExists(teamName, teamList)) {
                System.out.printf("Member %s cannot join team %s!%n", user, teamName);
            }
            input = scan.nextLine();
        }

        List<Team> teamsToDisband = new ArrayList<>();
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).getUsers().size() < 1) {
                teamsToDisband.add(teamList.get(i));
                teamList.remove(i);
                i--;
            }
        }

        teamList = teamList.stream().sorted(Comparator.comparingInt(Team::getMembersCount).reversed()
                .thenComparing(Team::getName))
                .collect(Collectors.toList());


        for (Team team : teamList) {
            System.out.println(team.getName());
            System.out.println("- " + team.getCreator());
            team.users = team.getUsers().stream().sorted().collect(Collectors.toList());
            for (String user : team.getUsers()) {
                System.out.println("-- " + user);
            }
        }

            System.out.println("Teams to disband: ");
        if (teamsToDisband.size() > 0) {
            teamsToDisband = teamsToDisband.stream().sorted().collect(Collectors.toList());
            for (int i = 0; i < teamsToDisband.size(); i++) {
                System.out.println(teamsToDisband.get(i).getName());
            }
        }
    }
    private static boolean isCreator(String user, List<Team> team) {
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getCreator().equals(user)) {
                return true;
            }
        } return false;
    }

    private static boolean teamExists(String name, List<Team> team) {
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getName().equals(name)) {
                return true;
            }
        } return false;
    }
}
class Team {
    public int getMembersCount() {
        return membersCount;
    }

    public Team(String creator, String name, List<String> users, int membersCount) {
        this.creator = creator;
        this.name = name;
        this.users = users;
        this.membersCount = users.size();

        users = users.stream().sorted().collect(Collectors.toList());
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    String creator;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    List<String> users;
    int membersCount;

    Team() {

    }

    @Override
    public String toString() {
        return String.format("%s%n" +
                "- %s%n" +
                "-- %s%n", this.getName(), this.getCreator(), this.getUsers().toString().join("%n-- ", getUsers()));
    }

}
