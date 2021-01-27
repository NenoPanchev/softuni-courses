import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Homework {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String MINIONS_TABLE_NAME = "minions_db";
    private Connection connection;
    private final Scanner scan = new Scanner(System.in);

    public Homework(String user, String password) throws SQLException {
        this.setConnection(user, password);
    }

    public void setConnection(String user, String password) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        connection = DriverManager
                .getConnection(CONNECTION_STRING + MINIONS_TABLE_NAME, properties);
    }

    public void getVillainsNamesEx2() throws SQLException {
        System.out.println("Enter the minimum amount of minions to get all the villains that have that many:  (15 in the example)");
        int minimumMinions = Integer.parseInt(scan.nextLine());
        String query = "SELECT name, COUNT(mv.minion_id) AS count\n" +
                "FROM villains AS v\n" +
                "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                "GROUP BY v.id\n" +
                "HAVING count > ?\n" +
                "ORDER BY count DESC;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, minimumMinions);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("count"));
        }
    }

    public void getMinionNamesEx3() throws SQLException {
        System.out.println("Enter villain id to get info of all of their minions:");
        int villainId = Integer.parseInt(scan.nextLine());
        String query = "SELECT m.name, m.age\n" +
                "FROM villains AS v\n" +
                "LEFT JOIN minions_villains mv on v.id = mv.villain_id\n" +
                "LEFT JOIN minions m on mv.minion_id = m.id\n" +
                "WHERE v.id = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, villainId);

        ResultSet resultSet = statement.executeQuery();
        String villainName = getEntityNameById(villainId, "villains");
        if (villainName == null) {
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
        } else {
            System.out.printf("Villain: %s%n", villainName);
            int counter = 1;
            while (resultSet.next()) {
                System.out.printf("%d. %s %d%n", counter++,
                        resultSet.getString("m.name"),
                        resultSet.getInt("age"));
            }
        }
    }

    public void addMinionEx4() throws SQLException {
        System.out.println("Enter minion and villain input together:");
        String[] minionInfo = scan.nextLine().split("\\s+");
        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionTown = minionInfo[3];
        String[] villainInfo = scan.nextLine().split("\\s+");
        String villainName = villainInfo[1];

        int townId = getEntityIdByName(minionTown, "towns");

        if (townId < 0) {
            insertTown(minionTown);
            townId = getEntityIdByName(minionTown, "towns");
        }


        int minionId = getEntityIdByName(minionName, "minions");

        if (minionId < 0) {
            insertMinion(minionName, minionAge, townId);
            minionId = getEntityIdByName(minionName, "minions");
        }


        int villainId = getEntityIdByName(villainName, "villains");

        if (villainId < 0) {
            insertVillain(villainName);
            villainId = getEntityIdByName(villainName, "villains");
        }

        String query = "INSERT INTO minions_villains value (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, minionId);
        statement.setInt(2, villainId);
        statement.execute();
        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);
    }

    public void changeTownNamesCasingEx5() throws SQLException {
        System.out.println("Enter a country to change its town names casing:");
        String country = scan.nextLine();

        if (countryExists(country)) {
        String query = "UPDATE towns\n" +
                "SET name = UPPER(name)\n" +
                "WHERE country = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, country);
        int affectedTowns = statement.executeUpdate();
            System.out.printf("%d town names were affected.%n", affectedTowns);
            List<String> towns = new ArrayList<>();

            String query2 = "SELECT name FROM towns WHERE country = ?";
            PreparedStatement statement2 = connection.prepareStatement(query2);
            statement2.setString(1, country);
            ResultSet resultSet = statement2.executeQuery();

            while (resultSet.next()) {
                towns.add(resultSet.getString("name"));
            }
            System.out.println(towns);
        } else {
            System.out.println("No town names were affected.");
        }
    }

    public void removeVillainEx6() throws SQLException {
        System.out.println("Enter villain ID to delete them and release their minions:");
        int villainId = Integer.parseInt(scan.nextLine());
        String villainName = getEntityNameById(villainId, "villains");
        if (villainName == null) {
            System.out.println("No such villain was found");
        } else {
            System.out.printf("%s was deleted", villainName);
            String selectMinionsQuery = "SELECT COUNT(*) FROM minions_villains WHERE villain_id = ?";
            PreparedStatement statement = connection.prepareStatement(selectMinionsQuery);
            statement.setInt(1, villainId);
        }
    }

    private String getEntityNameById(int entityId, String tableName) throws SQLException {
        String query = String.format("SELECT name FROM %s WHERE id = ?", tableName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, entityId);

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next() ? resultSet.getString("name") : null;
    }

    private int getEntityIdByName(String entityName, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = ?", tableName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, entityName);

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next() ? resultSet.getInt(1) : -1;
    }

    private void insertTown(String townName) throws SQLException {
        String query = String.format("INSERT INTO towns (`name`) value ('%s')", townName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.execute();
        System.out.printf("Town %s was added to the database.%n", townName);
    }

    private void insertMinion(String minionName, int minionAge, int townId) throws SQLException {
        String query = String.format("INSERT INTO minions (`name`, age, town_id) value ('%s', %d, %d)",
                minionName, minionAge, townId);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.execute();

    }

    private void insertVillain(String villainName) throws SQLException {
        String query = String.format("INSERT INTO villains (`name`, evilness_factor) value ('%s', 'evil')", villainName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.execute();
        System.out.printf("Villain %s was added to the database.%n", villainName);
    }

    private boolean countryExists(String country) throws SQLException {
        String query = String.format("SELECT id FROM towns WHERE country = '%s'", country);
        PreparedStatement statement = connection.prepareStatement(query);
        int countryId = 0;
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            countryId = resultSet.getInt(1);
        }

        return countryId > 0;
    }
}