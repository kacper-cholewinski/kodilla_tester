package com.kodilla.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.sql.SQLException;

class DbManagerTestSuite {
    private static DbManager dbManager;

    @BeforeAll
    public static void setup() throws SQLException {
        dbManager = DbManager.getInstance();
    }

    @Test
    void testConnect() {
        //Given
        //When
        //Then
        Assertions.assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        String countQuery = "SELECT COUNT(*) FROM USERS";
        Statement statement = createStatement();
        ResultSet rs = statement.executeQuery(countQuery);
        int count = getRowsCount(rs);
        insertUsers(statement);

        //When
        String sqlQuery = "SELECT * FROM USERS";
        statement = createStatement();
        rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = getResultsCount(rs);
        int expected = count + 5;
        Assertions.assertEquals(expected, counter);

        rs.close();
        statement.close();
    }

    private Statement createStatement() throws SQLException {
        return dbManager.getConnection().createStatement();
    }

    private static final List<AbstractMap.SimpleEntry<String, String>> USERS = List.of(
            new AbstractMap.SimpleEntry<>("Zara", "Ali"),
            new AbstractMap.SimpleEntry<>("Otman", "Use"),
            new AbstractMap.SimpleEntry<>("Mark", "Boq"),
            new AbstractMap.SimpleEntry<>("Uli", "Wimer"),
            new AbstractMap.SimpleEntry<>("Oli", "Kosiw")
    );

    private void insertUsers(Statement statement) throws SQLException {
        for (AbstractMap.SimpleEntry<String, String> user : USERS) {
            statement.executeUpdate(
                    String.format("INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('%s', '%s')",
                            user.getKey(),
                            user.getValue()
                    )
            );
        }
    }

    private static int getResultsCount(ResultSet rs) throws SQLException {
        int counter = 0;
        while(rs.next()) {
            System.out.printf("%d, %s, %s",
                    rs.getInt("ID"),
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME")/*,
                    rs.getInt("COUNT(*)")*/);
            counter++;
            System.out.println();
        }
        return counter;
    }

    private static int getRowsCount(ResultSet rs) throws SQLException {
        int count = 0;
        while (rs.next()) {
            count = rs.getInt("COUNT(*)");
        }
        return count;
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {
        //Given
        String sqlQuery = "select users.id, users.firstname, users.lastname, count(*) from users join posts on users.id = posts.user_id group by users.id having count(*) > 1";
        Statement statement = createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
        int count = getResultsCount(rs);
        System.out.println("initial count: " + count);
        insertUsersAndPosts(statement);

        //When
        statement = createStatement();
        rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = getResultsCount(rs);
        int expected = count + 3;
        Assertions.assertEquals(expected, counter);

        rs.close();
        statement.close();
    }

    private int getUserId(Statement statement, String userFirstname, String userLastname) throws SQLException {
        ResultSet rs = statement.executeQuery(
            String.format("select id from users where firstname = '%s' and lastname = '%s'", userFirstname, userLastname)
        );

        int id = 0;
        while(rs.next()) {
            id = rs.getInt("id");
        }


        return id;
    }


    private void insertUsersAndPosts(Statement statement) throws SQLException {
        insertUsers(statement);

        int usersCount = USERS.size();
        int postsToInsert = usersCount - 1;
        for (AbstractMap.SimpleEntry<String, String> user : USERS) {
            int userId = getUserId(statement, user.getKey(), user.getValue());
            for (int i = 0; i < postsToInsert; i++) {
                statement.executeUpdate(
                    String.format("INSERT INTO POSTS(USER_ID, BODY) VALUES ('%d', '%s')", userId, "test")
                );
            }

            postsToInsert -= 1;
        }
    }
}