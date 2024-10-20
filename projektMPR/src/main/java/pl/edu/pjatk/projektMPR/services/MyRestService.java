package pl.edu.pjatk.projektMPR.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.pjatk.projektMPR.model.Car;
import pl.edu.pjatk.projektMPR.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MyRestService {

    private final CarRepository carRepository;

    @Autowired
    public MyRestService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // GET po ID
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    // Metoda zwracająca wszystkie samochody
    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }


    // GET po polu1 (brand)
    public List<Car> getCarsByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    // GET po polu2 (model)
    public List<Car> getCarsByModel(String model) {
        return carRepository.findByModel(model);
    }

    // POST - dodanie nowego samochodu
    public void addCar(Car car) {
        carRepository.save(car);
    }

    // PATCH - aktualizacja samochodu
    public void updateCar(Long id, Car updatedCar) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car existingCar = optionalCar.get();
            existingCar.setBrand(updatedCar.getBrand());
            existingCar.setModel(updatedCar.getModel());
            carRepository.save(existingCar);
        }
    }

    // DELETE - usunięcie samochodu
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
