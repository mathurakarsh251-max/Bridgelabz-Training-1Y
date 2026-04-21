abstract class DataMiner {
    public final void mineData() {
        openFile();
        extractData(); 
        closeFile();
    }

    protected abstract void extractData();

    private void openFile() { System.out.println("Opening..."); }
    private void closeFile() { System.out.println("Closing..."); }
}