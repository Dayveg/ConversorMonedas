public class ConfiguracionAPI {
        private static final String APPKEY =  System.getenv("APPKEY");
        public static String getAPPKEY() {
            return APPKEY;
        }
}
