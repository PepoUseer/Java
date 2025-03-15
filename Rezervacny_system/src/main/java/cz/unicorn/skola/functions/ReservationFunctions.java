package cz.unicorn.skola.functions;

import cz.unicorn.skola.consts.ClassEnum;
import cz.unicorn.skola.data.MainDataStructure;
import cz.unicorn.skola.object.ClassTO;
import cz.unicorn.skola.object.ReservationTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ReservationFunctions {

    public void createReservation(LocalDate dateFrom, LocalDate dateTo, String name, ClassEnum classEnum) {

        ClassTO classto = MainDataStructure.mainData.get(classEnum);
        if(classto.getReservations().isEmpty()) {
            ReservationTO reservationTO = new ReservationTO();
            reservationTO.setDateFrom(dateFrom);
            reservationTO.setDateTo(dateTo);
            reservationTO.setName(name);
            classto.setReservations(List.of(reservationTO));
        } else {
            ReservationTO reservationTO = new ReservationTO();
            reservationTO.setDateFrom(dateFrom);
            reservationTO.setDateTo(dateTo);
            reservationTO.setName(name);
            List<ReservationTO> newReservations = new ArrayList<>(classto.getReservations());
            newReservations.add(reservationTO);
            classto.setReservations(newReservations);

    }



    }

}
