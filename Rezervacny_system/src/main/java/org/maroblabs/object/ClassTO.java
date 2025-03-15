package org.maroblabs.object;

import java.util.List;
import java.util.ArrayList;

public class ClassTO {

    private Long id;
    private String name;
    private List<ReservationTO> reservationTOS = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ReservationTO> getReservations() {
        return reservationTOS;
    }

    public void setReservations(List<ReservationTO> reservationTOS) {
        this.reservationTOS = reservationTOS;
    }
}
