package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SesionStatus {

    private static SesionStatus instance;
    private String username;
    private int user_id;
    private boolean loggedIn;
    private String id_roll;
    private int register;

    private SesionStatus() {
        username = null;
        loggedIn = false;
    }

    public static synchronized SesionStatus getInstance() {
        if (instance == null) {
            instance = new SesionStatus();
        }
        return instance;
    }

    public void login(int user_id, String username, String id_roll, int register) {
        this.username = username;
        this.user_id = user_id;
        this.id_roll = id_roll;
        this.register = register;
        loggedIn = true;
    }

    public void logout() {
        username = null;
        loggedIn = false;
    }


    public String setDate() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        return formattedDateTime;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getUsername() {
        return username;
    }

    public int getUser_id() { return user_id; }
    public String getId_roll() {
        return id_roll;
    }

    public int getRegister() {
        return register;
    }
}

