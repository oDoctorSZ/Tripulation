package dc.jadir.altversetripulation.references;

import java.util.List;
import java.util.UUID;

public class Tripulation {

    private String name;
    private String leader;
    private int xp;
    private double cash;
    private List<String> members;

    public Tripulation(String name, String leader, int xp, double cash, List<String> members) {
        this.name = name;
        this.leader = leader;
        this.xp = xp;
        this.cash = cash;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
