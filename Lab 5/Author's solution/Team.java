public class Team {
    /**
     * An object of class Chef
     */
    private Chef chef;
    /**
     * An object of class Apprentice
     */
    private Apprentice apprentice;
    /**
     * An object of class Dish. This can be assigned either a Starter or MainCourse object <br>
     * (An example of runtime polymorphism)
     */
    private Dish dish;
    /**
     * The aggregate skill of the entire team
     */
    private int teamSkill;
    /**
     * Initialize objects as per the given arguments<br>
     * Skill should be calculated and assigned in the constructor (see {@link Team#calculateTeamSkill()}).
     * @param chef Object of Chef class
     * @param apprentice Object of Apprentice class
     * @param starter Object of Starter class
     */
    public Team(Chef chef, Apprentice apprentice, Starter starter) {
            this.chef = chef;
            this.apprentice = apprentice;
            this.dish = starter;
            calculateTeamSkill();
    }
    /**
     * Initialize objects as per the given arguments
     * @param chef Object of Chef class
     * @param apprentice Object of Apprentice class
     * @param mainCourse Object of MainCourse class
     */
    
    public Team(Chef chef, Apprentice apprentice, MainCourse mainCourse) {
            this.chef = chef;
            this.apprentice = apprentice;
            this.dish = mainCourse;
            calculateTeamSkill();
    }
    /**
     * @return Chef of the team
     */
    public Chef getChef() {
            return this.chef;
    }
    /**
     * @return Return skill value of the entire team.
     */
    public int getTeamSkill()
    {
            return this.teamSkill;
    }
    /**
     * To check validity of team
     * @param competitionType Type of competition : "Starter" or "MainCourse" 
     * @return Return true if Team is valid, else return false
     */
    public boolean verifyValidity(String competitionType) {
            if(chef.verifyValidity() && apprentice.verifyValidity() && dish.verifyValidity()) {
                    if(competitionType.equals("Starter") && dish.numIngredients == 6) {
                            return true;
                    }
                    if(competitionType.equals("MainCourse") && dish.numIngredients == 10 ) {
                            return true;
                    }
            }

            return false;
    }
    /**
     * Calculate teamSkill as teamSkill = (2*Chef's Skill + Apprentice's Skill)
     */
    public void calculateTeamSkill()
    {
            this.teamSkill = (2*chef.getSkill() + apprentice.getSkill());
    }
}
