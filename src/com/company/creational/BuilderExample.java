package com.company.creational;

class Account {
    private String login;
    private String token;
    private Account() {
        //private empty constructor
    }
    //getters and setters, toString
    public static Builder builder() {
        return new Account().new Builder();
    }
    public class Builder {
        private Builder() {
            //private empty constructor
        }
        public Builder login(String login) {
            Account.this.login = login;
            return this;
        }

        public Builder token(String token) {
            Account.this.token = token;
            return this;
        }

        public Account build() {
            return Account.this;
        }
    }
}
public class BuilderExample {
    public static void main(String[] args) {
        Account account = Account.builder()
                .login("john")
                .token("token")
                .build();
        System.out.println(account);
    }
}
