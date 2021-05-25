public class Starter extends Dish {
    /**
     * Maximum cost of any Starter which will be allowed in the competition.<br>
     * Set to 500.
     */
    public static final int STARTER_MAX_COST = 500;
    /**
     * Maximum time allowed for the preparation of any Starter in the
     * competition.<br>
     * Set to 60.
     */
    public static final int STARTER_MAX_TIME = 60;

    /**
     * Initialize the number of ingredients to 6 and all the others from given
     * arguments<br>
     * 
     * @param name              Name of dish
     * @param costOfIngredients Total cost of the ingredients
     * @param timeForPrep       Time taken for preparation of dish
     */
    public Starter(String name, int costOfIngredients, int timeForPrep) {
            super(name, costOfIngredients, timeForPrep);
            this.numIngredients = 6;
    }

    /**
     * Verify the validity of the Starter <br>
     * A Starter is valid if the cost of its ingredients and time for preparation
     * are less than or equal to STARTER_MAX_COST and STARTER_MAX_TIME respectively
     * <br>
     */

    @Override
    public boolean verifyValidity() {
            if (costOfIngredients <= STARTER_MAX_COST && timeForPrep <= STARTER_MAX_TIME) {
                    return true;
            }
            return false;
    }



}
