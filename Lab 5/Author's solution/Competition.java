public class Competition {
    /**
     * An array of Teams
     */
    private Team teams[];
    /**
     * Specifies the type of competition. Can be either "Starter" or "MainCourse"
     */
    private String competitionType;
    /**
     * Number of teams participating in the competition
     */
    private int numTeams;
    /**
     * Maximum number of teams that can take part in a competition.<br>
     * Set to 10.
     */
    public static final int MAX_TEAMS = 10;
    /**
     * Initialize the variables.
     * Initialize numTeams to 0.
     * @param competitionType Type of competition: "Starter" or "MainCourse"
     */
    public Competition(String competitionType){
            this.competitionType = competitionType;
            this.numTeams = 0;
            this.teams = new Team[MAX_TEAMS];
    }
    /**
     * Add a new Team if possible (also check validity of the team).
     * Increment number of competitions participated by chef by 1.
     * Increment number of teams by 1.
     * @param team Team to be added.
     * @return Return true if valid team can be added, else return false.
     */
    public boolean addTeam(Team team) {
            if(numTeams < MAX_TEAMS) {
                    if (!team.verifyValidity(competitionType))
                        return false;
                    team.getChef().participateInNewComp();
                    teams[numTeams] = team;
                    numTeams++;
                    return true;
            }
            return false;
    }
    /**
     * Remove the team passed in the argument if it exists.
     * Decrement the number of competitions participated by chef by 1.
     * Decrement the number of teams by 1.
     * Rearrange the array of teams after removal.
     * @param team Team to be removed
     * @return Returns true if team can be removed, else return false
     */
    public boolean removeTeam(Team team) {
        if(this.numTeams==0) return false;
        int idx=-1;
        for(int i=0;i<numTeams;++i) {
            if(teams[i]==team) {
                idx=i;
                numTeams--;
                teams[i].getChef().removeFromComp();
                break;
            }
        }
        if(idx==-1) return false;
        
        for(int j=idx;j<numTeams;++j) {
            teams[j]=teams[j+1];
        }
        return true;
    }
    
    
    /**
     * Winner is calculated as the Team with most amount of skill.
     * If there is a tie, team with more skilled chef wins.
     * Assume no two chefs have same skill
     * @return Return the winning team
     */
    public Team findWinner() {
            Team winner = null;
            int maxSkill = 0;
            for (int i = 0; i < numTeams; i++) {
                    if(teams[i].getTeamSkill() > maxSkill) {
                            maxSkill = teams[i].getTeamSkill();
                            winner = teams[i];
                    }
                    else if(teams[i].getTeamSkill()==maxSkill) {
                        if(teams[i].getChef().getSkill()>winner.getChef().getSkill()) {
                            maxSkill = teams[i].getTeamSkill();
                            winner = teams[i];
                        }
                    }
            }
            return winner;
    }
    /**
     * Returns the number of teams participating in the competition
     * @return Return number of teams
     */
    public int getNumTeams() {
        return numTeams;
    }
}
