package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.entities.Car;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());


    @PersistenceContext
    EntityManager entitymanager;

    public List<CarDto> findAllCars(){
        LOG.info("Find all cars");
        try{
            TypedQuery<Car> typedQuery = entitymanager.createQuery("SELECT c FROM Car c", Car.class);
            List<Car> cars = typedQuery.getResultList();
            return copyCarsToDto(cars);

        }
        catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars) {
    List<CarDto> carDtos = new ArrayList<CarDto>();
    for (Car car : cars) {
        carDtos.add(new CarDto(
                car.getOwner().getId(),
                car.getParkingSpot(),
                car.getLicensePlate(),
                car.getOwner().getUsername()
        ));
    }
        return carDtos;
    }
}
