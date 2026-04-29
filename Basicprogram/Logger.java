class Logger {
    void log(Object message) {
        System.out.println("System Log: " + message);
    }
}
class FileLogger extends Logger {
    void log(String message) {
        System.out.println("File Log: " + message);
    }
}
Logger myLogger = new FileLogger();
myLogger.log("Hello");