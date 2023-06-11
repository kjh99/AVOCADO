package newproject;

public class CurrentUser {
    private static CurrentUser instance;
    private String userId;

    private CurrentUser() {} // private constructor to prevent direct instantiation
    
    private CurrentUser(String userId) {
        this.userId = userId;
    }
    

    public static void login(String userId) {
        instance = new CurrentUser(userId);
    }

    public static CurrentUser getInstance() {
        if (instance == null) {
            instance = new CurrentUser(); // Initialize the instance if it's null
        }
        return instance;
    }

    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    
}