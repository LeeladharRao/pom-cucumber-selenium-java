package constants;

public class Constants {

	public class ConfigConstants {
		private ConfigConstants() {
			throw new IllegalStateException("ConfigConstants class");
		}

		public static final String BROWSER = "browser";
		public static final String BROWSER_EDGE = "edge";
		public static final String BROWSER_CHROME = "chrome";
		public static final String BROWSER_FIREFOX = "firefox";
		public static final String SESSION = "session";
		public static final String LOCAL = "local";
        public static final String REMOTE = "remote";
		public static final String BASEURL = "baseURL";
		public static final String PROPERTIES_FILE_PATH = "configs//configuration.properties";
		public static final String WELCOME_USERNAME = "Welcome UserName!";
	}

}
