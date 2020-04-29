package com.epam.entity;

public class User extends Entity {
    String email;
    String password;
    String name;
    String surname;

    public enum userSqlQuery {
        GET_BY_ID(SqlQuery.GET_BY_ID, "SELECT * FROM users WHERE UserID = ?;"),
        GET_ALL(SqlQuery.GET_ALL, "SELECT * FROM users;"),
        INSERT(SqlQuery.INSERT, "INSERT INTO users (Email, Password, Name, Surname) VALUES (?, ?, ?, ?);"),
        UPDATE_BY_ID(SqlQuery.UPDATE_BY_ID, "UPDATE users SET Email = ?, Password = ?, Name = ?, Surname = ? WHERE UserID = ?"),
        DELETE_BY_ID(SqlQuery.DELETE_BY_ID, "DELETE FROM users WHERE UserID = ?;");

        private SqlQuery sqlQuery;
        private String query;

        userSqlQuery(SqlQuery sqlQuery, String query) {
            this.sqlQuery = sqlQuery;
            this.query = query;
        }

        public SqlQuery getSqlQuery() {
            return sqlQuery;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    public User() {
    }

    public User(String email, String password, String name, String surname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public User(Long id, String email, String password, String name, String surname) {
        super(id);
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return surname != null ? surname.equals(user.surname) : user.surname == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}