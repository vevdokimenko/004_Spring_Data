package com.itvdn.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "cars_info", schema = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "mark")
    private String mark;

    @Basic
    @Column(name = "model")
    private String model;

    @Basic
    @Column(name = "engine")
    private double engine;

    @Basic
    @Column(name = "price")
    private int price;

    @Basic
    @Column(name = "speed")
    private int speed;

    public Car() {
    }

    public Car(String mark, String model, double engine, int price, int speed) {
        this.mark = mark;
        this.model = model;
        this.engine = engine;
        this.price = price;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", price=" + price +
                ", speed=" + speed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (Double.compare(car.engine, engine) != 0) return false;
        if (price != car.price) return false;
        if (speed != car.speed) return false;
        if (!Objects.equals(mark, car.mark)) return false;
        return Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, model, engine, price, speed);
    }
}
