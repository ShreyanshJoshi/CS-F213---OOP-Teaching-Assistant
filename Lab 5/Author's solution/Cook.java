/**
        @author Subham
        @author Arapan
        @author Manas
 */
public abstract class Cook {
    /**
     * Name of the cook
     */
    protected String name;
    /**
     * Age of the cook
     */
    protected int age;
    /**
     * Cook's ID
     */
    protected int ID;
    /**
     * Skill of the cook - Every cook has a particular skill value.
     */
    protected int skill;
    /**
            Initializes name,age,ID from arguments.<br>
            @param name Name of the cook
            @param age Age of the cook
            @param ID ID of the cook
     */
    public Cook(String name, int age, int ID) {
            this.name = name;
            this.age = age;
            this.ID = ID;
    }
    /**
     * Returns skill of the cook
     * @return Return skill of the cook
     */
    public int getSkill() {
            return this.skill;
    }
    /**
     * Abstract function verifyValidity() implemented according to requirements of derived class
     * @return Return true if cook is valid else return false
     */
    public abstract boolean verifyValidity();
    /**
     * Calculate skill of cook according to requirements specified in derived class
     */
    public abstract void calculateSkill();

}
