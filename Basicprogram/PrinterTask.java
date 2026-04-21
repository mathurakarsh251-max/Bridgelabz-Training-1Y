interface PrinterTask {
    void perform();
}

class ColorPrintTask implements PrinterTask {
    @Override
    public void perform() { System.out.println("Printing in high-quality color..."); }
}

class BasicPrinter {
    private PrinterTask printTask;

    public BasicPrinter(PrinterTask task) {
        this.printTask = task;
    }

    public void setPrintTask(PrinterTask task) {
        this.printTask = task;
    }

    public void pressPrintButton() {
        printTask.perform(); 
    }
}