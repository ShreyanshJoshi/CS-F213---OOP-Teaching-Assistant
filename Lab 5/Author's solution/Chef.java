public class Chef extends Cook {
    /**
     * Total points acquired by the Chef. Assume that each competition won gives 1
     * point.
     */
    private int points;
    /**
     * Total number of competition the Chef has participated in.
     */
    private int numCompetitions;
    /**
     * Maximum number of competitions the Chef can participate in.<br>
     * Set to 20.
     */
    public static final int MAX_COMPETITIONS = 20;
    /**
     * Minimum age required to be eligible for the competition.<br>
     * Set to 40.
     */
    public static final int MIN_AGE = 40;
    /**
     * Minimum points required to participate.<br>
     * Set to 5.
     */
    public static final int MIN_POINTS = 5;

    /**
     * Initialize the variables.<br>
     * Skill should be calculated and assigned in the constructor (see
     * {@link Chef#calculateSkill()}).
     * 
     * @param name            Name of Chef
     * @param age             Age of Chef
     * @param ID              Chef ID
     * @param points          Current points
     * @param numCompetitions Total no. of competitions participated in
     */
    public Chef(String name, int age, int ID, int points, int numCompetitions) {
            super(name, age, ID);
            this.points = points;
            this.numCompetitions = numCompetitions;
            calculateSkill();
    }

    /**
     * Increment number of competitions participated in by 1 and update skill;
     */
    public void participateInNewComp() {
            this.numCompetitions += 1;
            calculateSkill();
    }
    /**
     * Decrement number of competitions participated in by 1 and update skill
     */
    public void removeFromComp() {
        this.numCompetitions-=1;
        calculateSkill();
    }

    /**
     * Verify the validity of the Chef.<br>
     * A Chef is valid if his age and points are greater than or equal to MIN_AGE
     * and MIN_POINTS respectively<br>
     * and he has participated in less than MAX_COMPETITIONS.
     * 
     * @return Return true if Chef is valid, else return false
     */
    @Override
    public boolean verifyValidity() {
            if (age >= MIN_AGE && points >= MIN_POINTS && numCompetitions < MAX_COMPETITIONS) {
                    return true;
            }
            return false;
    }

    /**
     * Calculate skill as skill =
     * ({@link Chef#points}*100)/{@link Chef#numCompetitions}
     */
    @Override
    public void calculateSkill() {
            this.skill = (points * 100 / numCompetitions);
    }

    /**
     * Returns the points of the chef
     * @return Returns points
     */
    public int getPoints() {
        return this.points;
    }
    
    /**
     * Returns the number of competitions the chef has participated in
     * @return Returns numCompetitions
     */
    public int getNumCompetitions() {
        return this.numCompetitions;
    }

}
