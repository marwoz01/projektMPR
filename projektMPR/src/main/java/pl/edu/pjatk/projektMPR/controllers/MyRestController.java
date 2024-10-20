package pl.edu.pjatk.projektMPR.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.projektMPR.model.Car;
import pl.edu.pjatk.projektMPR.services.MyRestService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private final MyRestService myRestService;

    @Autowired
    public MyRestController(MyRestService myRestService) {
        this.myRestService = myRestService;
    }

    // GET, który zwraca obiekt po ID
    @GetMapping("/cars/{id}")
    public Optional<Car> getCarById(@PathVariable Long id) {
        return myRestService.getCarById(id);
    }

    // GET, który zwraca obiekt po brand
    @GetMapping("/cars/brand/{brand}")
    public List<Car> getCarsByBrand(@PathVariable String brand) {
        return myRestService.getCarsByBrand(brand);
    }

    // GET, który zwraca obiekt po model
    @GetMapping("/cars/model/{model}")
    public List<Car> getCarsByModel(@PathVariable String model) {
        return myRestService.getCarsByModel(model);
    }

    // POST, który dodaje obiekt do bazy
    @PostMapping("/cars")
    public void addCar(@RequestBody Car newCar) {
        myRestService.addCar(newCar);
    }

    // GET, który zwraca wszystkie obiekty z bazy
    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return myRestService.getAllCars();
    }


    // PATCH, który aktualizuje obiekt w bazie
    @PatchMapping("/cars/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
        myRestService.updateCar(id, updatedCar);
    }

    // DELETE, który kasuje obiekt z bazy
    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable Long id) {
        myRestService.deleteCar(id);
    }
}
