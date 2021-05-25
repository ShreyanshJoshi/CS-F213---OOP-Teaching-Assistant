public class Market {

    // TODO: Add relevant fields

    public Market() {
        // TODO: Complete the constructor
    }

    // DO NOT MODIFY. Method has been provided to you to use as it is.
    // Method to add a User Record to the User Database
    // Adds the user with the given name and balance to the User Database.
    // Returns True if the User record was added to the User Database
    public Boolean addUserRecord(String name, Double balance) {
        User user = new User(userDatabase.getNumRecords(), name, balance);
        return userDatabase.putRecord(user);
    }

    // DO NOT MODIFY. Method has been provided to you to use as it is.
    // Method to add a Product Record to the Product Database.
    // Adds the product with the name, cost and owner to the Product Database.
    // Returns True if Product Record was added to the Product Database
    public Boolean addProductRecord(String name, Double cost, Integer ownerId) {
        User owner = (User) userDatabase.getRecord(ownerId);
        Product product = new Product(productDatabase.getNumRecords(), name, owner, cost);
        return productDatabase.putRecord(product);
    }

    // TODO: Start from here and complete the class with the rest of the methods

}
