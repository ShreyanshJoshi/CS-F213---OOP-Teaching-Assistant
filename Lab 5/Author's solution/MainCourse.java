
public class MainCourse extends Dish {
    /**
     * Maximum cost of any Main Course Dish which will be allowed in the
     * competition.<br>
     * Set to 1000.
     */
    public static final int MAIN_COURSE_MAX_COST = 1000;
    /**
     * Maximum time allowed for the preparation of any Main Course Dish in the
     * competition.<br>
     * Set to 90.
     */
    public static final int MAIN_COURSE_MAX_TIME = 90;

    /**
     * Initialize the number of ingredients to 10 and all the others from given
     * arguments<br>
     * 
     * @param name              Name of dish
     * @param costOfIngredients Total cost of the ingredients
     * @param timeForPrep       Time taken for preparation of dish
     */
    public MainCourse(String name, int costOfIngredients, int timeForPrep) {
            super(name, costOfIngredients, timeForPrep);
            this.numIngredients = 10;
    }

    /**
     * Verify the validity of the Main Course Dish <br>
     * A Main Course Dish is valid if the cost of its ingredients and time for
     * preparation are less than or equal to MAIN_COURSE_MAX_COST and
     * MAIN_COURSE_MAX_TIME respectively <br>
     */

    @Override
    public boolean verifyValidity() {
            if (costOfIngredients <= MAIN_COURSE_MAX_COST && timeForPrep <= MAIN_COURSE_MAX_TIME) {
                    return true;
            }
            return false;
    }



}
