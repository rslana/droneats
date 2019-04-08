# droneats
Trabalho de LP V - Implementação de padrões de projeto em um sistema de entrega de comida.

You have to create ```config.Config.java```


    package config;
    public class Config {
        public static final String DB_NAME = "";
        public static final String DB_PASS = "";
        public static final String ACCESS_KEY = "";
        public static final String SECRET_KEY = "";
        public static final boolean UPLOAD_WITH_AWS = false;
        public static final String EMAIL_SMTP = "";
        public static final String EMAIL_PORT = "";
        public static final String EMAIL_USER = "";
        public static final String EMAIL_PASS = "";
        public static final String EMAIL_FROM = "";
    }

If you don't want to use AWS S3 just leave the ```UPLOAD_WITH_AWS = false``` and the ```ACCESS_KEY``` and ```SECRET_KEY``` blank.