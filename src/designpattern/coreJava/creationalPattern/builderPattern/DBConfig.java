package designpattern.coreJava.creationalPattern.builderPattern;

public class DBConfig {

    private final String userName;
    private final String password;
    private final boolean ssl;
    private final int port;
    private final long timeout;

    public DBConfig(String userName, String password, boolean ssl, int port, long timeout) {
        this.userName = userName;
        this.password = password;
        this.ssl = ssl;
        this.port = port;
        this.timeout = timeout;
    }

    public DBConfig(DBConfigBuilder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
        this.ssl = builder.ssl;
        this.port = builder.port;
        this.timeout = builder.timeout;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSsl() {
        return ssl;
    }

    public int getPort() {
        return port;
    }

    public long getTimeout() {
        return timeout;
    }

    @Override
    public String toString() {
        return "DBConfig{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", ssl=" + ssl +
                ", port=" + port +
                ", timeout=" + timeout +
                '}';
    }

    static class DBConfigBuilder {
        private String userName;
        private String password;
        private boolean ssl;
        private int port;
        private long timeout;

        public DBConfigBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public DBConfigBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public DBConfigBuilder setSsl(boolean ssl) {
            this.ssl = ssl;
            return this;
        }

        public DBConfigBuilder setPort(int port) {
            this.port = port;
            return this;
        }

        public DBConfigBuilder setTimeout(long timeout) {
            this.timeout = timeout;
            return this;
        }

        public DBConfig build() {
            return new DBConfig(this);
        }
    }
}
