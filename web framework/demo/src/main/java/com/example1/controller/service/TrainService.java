package main.java.com.example.demo.service;

import main.java.com.example.demo.model.Train;
import main.java.com.example.demo.repository.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainService {

    private final TrainRepo trainRepo;

    @Autowired
    public TrainService(TrainRepo trainRepo) {
        this.trainRepo = trainRepo;
    }

    public List<Train> getAllTrains() {
        return trainRepo.findAll();
    }

    public Train getTrainById(Integer id) {
        Optional<Train> optionalTrain = trainRepo.findById(id);
        return optionalTrain.orElse(null);
    }

    public Train addTrain(Train train) {
        return trainRepo.save(train);
    }

    public Train updateTrain(Integer id, Train train) {
        if (trainRepo.existsById(id)) {
            train.setId(id);
            return trainRepo.save(train);
        } else {
            return null;
        }
    }

    public void deleteTrain(Integer id) {
        trainRepo.deleteById(id);
    }
}