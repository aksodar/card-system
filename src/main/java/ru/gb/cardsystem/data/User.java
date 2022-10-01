package ru.gb.cardsystem.data;

public class User {
    private String firstName;
    private String secondName;
    private String patronymic;

    public User() {
    }

    public User(final String firstName, final String secondName, final String patronymic) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(final String secondName) {
        this.secondName = secondName;
    }

    public void setPatronymic(final String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
