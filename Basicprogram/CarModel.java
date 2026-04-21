class CarModel implements Cloneable {
    String modelName;
    String engineType;

    public CarModel(String modelName, String engineType) {
        this.modelName = modelName;
        this.engineType = engineType;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    void displaySpecs() {
        System.out.println("Model: " + modelName + " | Engine: " + engineType);
    }
}
public class PrototypeRegistry {
    public static void main(String[] args) {
        try {
            CarModel baseModel = new CarModel("Sedan-V1", "Petrol");
            System.out.print("Original Prototype: ");
            baseModel.displaySpecs();
            CarModel customerCar = (CarModel) baseModel.clone();
            System.out.print("Cloned Object:     ");
            customerCar.displaySpecs();

            System.out.println("\nIs it the same instance? " + (baseModel == customerCar));
            
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning failed: Class must implement Cloneable."); [cite: 58]
        }
    }
}