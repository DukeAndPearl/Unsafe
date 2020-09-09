package concurrent.entity;

public class Guard {

    private int ACCESS_ALLOWED = 1;

    public boolean hasAccess() {
        return 777 == ACCESS_ALLOWED;
    }

}
