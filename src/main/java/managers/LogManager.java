package managers;

public class LogManager {

	public LogManager() {
		// Nothing here
	}

	public static void logMessage(String message) {
		System.out.println("==========  " + message + "  ==========");
	}

	public static void logErrorMessage(Exception e) {
		e.printStackTrace();
		e.fillInStackTrace();
	}

}
