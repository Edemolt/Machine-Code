
public class Desktop {

    private String monitor;
    private String keyboard;
    private String mouse;
    private String speaker;
    private String ram;
    private String processor;
    private String motherboard;

    private Desktop(Builder builder) {
        this.monitor = builder.monitor;
        this.keyboard = builder.keyboard;
        this.mouse = builder.mouse;
        this.speaker = builder.speaker;
        this.ram = builder.ram;
        this.processor = builder.processor;
        this.motherboard = builder.motherboard;
    }

    public static class Builder {

        private String monitor;
        private String keyboard;
        private String mouse;
        private String speaker;
        private String ram;
        private String processor;
        private String motherboard;

        public Builder setMonitor(String monitor) {
            this.monitor = monitor;
            return this;
        }

        public Builder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Builder setMouse(String mouse) {
            this.mouse = mouse;
            return this;
        }

        public Builder setSpeaker(String speaker) {
            this.speaker = speaker;
            return this;
        }

        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Desktop build() {
            return new Desktop(this);
        }

    }

    public void displaySpecs() {
        System.out.println("Monitor: " + monitor);
        System.out.println("Keyboard: " + keyboard);
        System.out.println("Mouse: " + mouse);
        System.out.println("Speaker: " + speaker);
        System.out.println("RAM: " + ram);
        System.out.println("Processor: " + processor);
        System.out.println("Motherboard: " + motherboard);
    }
}
