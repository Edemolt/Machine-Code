// Remove.java

public class Remove {

    public void removeData() {
        Data data = Data.getInstance();
        data.clearData();
        System.out.println("Data removed (cleared) successfully.");
    }
}
