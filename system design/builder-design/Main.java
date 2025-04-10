
public class Main {

    public static void main(String[] args) {
        Desktop desktop = new Desktop.Builder()
                .setMonitor("Dell 24 inch")
                .setKeyboard("Logitech K120")
                .setMouse("Logitech M100")
                .setSpeaker("JBL Flip 5")
                .setRam("16GB DDR4")
                .setProcessor("Intel i7")
                .setMotherboard("ASUS ROG Strix")
                .build();

        desktop.displaySpecs();
    }
}
