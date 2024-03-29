package com.example.learningSpring.model.dto.request;

import com.example.learningSpring.model.dto.response.IdCardResponse;

import java.util.Objects;

public class IdCardRequest {


    private String name;
    private String surname;
    private Integer age;
    private String finCode;
    private String series;
    private String serialNumber;

    public IdCardRequest(String name,
                          String surname,
                          Integer age,
                          String finCode,
                          String series,
                          String serialNumber) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.finCode = finCode;
        this.series = series;
        this.serialNumber = serialNumber;
    }

    public static IdCardRequest.IdCardBuilder builder() {
        return new IdCardRequest.IdCardBuilder();
    }

    public static class IdCardBuilder {
        private String name;
        private String surname;
        private Integer age;
        private String finCode;
        private String series;
        private String serialNumber;

        public IdCardBuilder name(String name) {
            this.name = name;
            return this;
        }

        public IdCardBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public IdCardBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public IdCardBuilder finCode(String finCode) {
            this.finCode = finCode;
            return this;
        }

        public IdCardBuilder series(String series) {
            this.series = series;
            return this;
        }

        public IdCardBuilder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public IdCardRequest build() {
            IdCardRequest idCard =
                    new IdCardRequest(
                            this.name,
                            this.surname,
                            this.age,
                            this.finCode,
                            this.series,
                            this.serialNumber
                    );
            return idCard;
        }
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFinCode() {
        return finCode;
    }

    public void setFinCode(String finCode) {
        this.finCode = finCode;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdCardRequest idCard = (IdCardRequest) o;
        return age == idCard.age && Objects.equals(name, idCard.name) && Objects.equals(surname, idCard.surname) && Objects.equals(finCode, idCard.finCode) && Objects.equals(series, idCard.series) && Objects.equals(serialNumber, idCard.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, finCode, series, serialNumber);
    }

    @Override
    public String toString() {
        return "IdCardRequest{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", finCode='" + finCode + '\'' +
                ", series='" + series + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }

}
