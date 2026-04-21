abstract class DataProcessor {
    
    protected String sourceName;

    public DataProcessor(String sourceName) {
        this.sourceName = sourceName;
    }
    public void process() {
        System.out.println("[LOG] Starting process for source: " + sourceName);
    }
    protected boolean isValid() {
        return true;
    }
    public abstract void executeTask();
}
class CsvProcessor extends DataProcessor {

    public CsvProcessor(String fileName) {
        super(fileName); 
    }

    @Override
    public void process() {
        super.process(); 
        if (isValid()) {
            executeTask();
        }
    }

    @Override
    protected boolean isValid() {
        return sourceName.endsWith(".csv");
    }

    @Override
    public void executeTask() {
        System.out.println("Reading rows from CSV: " + sourceName);
    }
}
public class Main {
    public static void main(String[] args) {
        DataProcessor myProcessor = new CsvProcessor("student_data.csv");
        
        System.out.println("--- Executing Documented Workflow ---");
        myProcessor.process();
    }
}