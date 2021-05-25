public class Apprentice extends Cook {
    /**
     * Experience of the Apprentice.
     */
    private int experience;
    /**
     * Minimum age required to be eligible for the competition.<br>
     * Set to 20.
     */
    public static int MIN_AGE = 20;
    /**
     * Minimum experience required to participate.<br>
     * Set to 2.
     */
    public static int MIN_EXPERIENCE = 2;

    /**
     * Initialize the variables.<br>
     * Skill should be calculated and assigned in the constructor (see
     * {@link Apprentice#calculateSkill()}).
     * 
     * @param name       Name of the Apprentice
     * @param age        Age of the Apprentice
     * @param ID         Apprentice ID
     * @param experience Experience of Apprentice
     */
    public Apprentice(String name, int age, int ID, int experience) {
            super(name, age, ID);
            this.experience = experience;
            calculateSkill();
    }

    /**
     * Verify the validity of the Apprentice.<br>
     * A Apprentice is valid if his age and experience are greater than or equal to
     * MIN_AGE and MIN_EXPERIENCE respectively.<br>
     * 
     * @return Return true if Apprentice is valid, else return false.
     */
    @Override
    public boolean verifyValidity() {
            if (experience >= MIN_EXPERIENCE && age >= MIN_AGE) {
                    return true;
            }
            return false;
    }

    /**
     * Calculate skill as skill = ({@link Apprentice#experience}*100/age)
     */
    @Override
    public void calculateSkill() {
            this.skill = (experience * 100 / age);
    }

    /**
     * Returns experience of apprentice.
     * @return Returns experience 
     */
    public int getExperience() {
        return this.experience;
    }
    

}
