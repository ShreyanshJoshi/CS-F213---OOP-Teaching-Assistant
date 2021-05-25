public abstract class Dish {
    /**
     * Number of ingredients
     */
    protected int numIngredients;
    /**
     * Dish name
     */
    protected String name;
    /**
     * Cost of the dish
     */
    protected int costOfIngredients;
    /**
     * Time for preparation of the dish
     */
    protected int timeForPrep;


    /**
     * Initializes name,costOfIngredients,timeforPrep from arguments.<br>
     * @param name Name of dish
     * @param costOfIngredients Cost of dish
     * @param timeForPrep Time for preparation of the dish
     */
    public Dish(String name,int costOfIngredients, int timeForPrep) {
            this.name = name;
            this.costOfIngredients = costOfIngredients;
            this.timeForPrep = timeForPrep;
    }
    /**
     * Abstract function verifyValidity() implemented according to requirements of derived class
     * @return Return true if Dish is valid else return false
     */
    public abstract boolean verifyValidity();


}
