package dc.jadir.altversetripulation.references;

import dc.jadir.altversetripulation.enums.Role;

public class Tripulator {

    private String player;
    private String nick;
    private String tripName;
    private Role role;

    public Tripulator(String uuid, String nick, String tripName, Role role) {
        this.player = uuid;
        this.nick = nick;
        this.tripName = tripName;
        this.role = role;
    }

    public String getNick() { return nick; }

    public void setNick(String nick) { this.nick = nick; }

    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }
}
