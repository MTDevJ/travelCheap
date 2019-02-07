package com.travelCheap.travelCheap.Domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Message {
    @NotNull
    @Email
    private String clientEmail;
    @NotNull
    private String clientName;
    @NotNull
    private String clientTelephoneNumber;
    private String question1;
    private String question2;
    private String question3;
    private String comment;

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientTelephoneNumber() {
        return clientTelephoneNumber;
    }

    public void setClientTelephoneNumber(String clientTelephoneNumber) {
        this.clientTelephoneNumber = clientTelephoneNumber;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return clientEmail.equals(message.clientEmail) &&
                clientName.equals(message.clientName) &&
                clientTelephoneNumber.equals(message.clientTelephoneNumber) &&
                Objects.equals(question1, message.question1) &&
                Objects.equals(question2, message.question2) &&
                Objects.equals(question3, message.question3) &&
                Objects.equals(comment, message.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientEmail, clientName, clientTelephoneNumber, question1, question2, question3, comment);
    }
}
