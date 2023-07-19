package com.example.Drones.persistance.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.util.Date;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class AuditEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @CreationTimestamp
    private Date updateDate;

    private String droneSerialnumber;
    private String droneState;
    private Double batteryCapacity;


    public AuditEvent(Drone drone){
        this.droneSerialnumber = drone.getSerialNumber();
        this.batteryCapacity = drone.getBatteryCapacity();
        this.droneState = String.valueOf(drone.getState());
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AuditEvent events = (AuditEvent) o;
        return getId() != null && Objects.equals(getId(), events.getId());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }
}
