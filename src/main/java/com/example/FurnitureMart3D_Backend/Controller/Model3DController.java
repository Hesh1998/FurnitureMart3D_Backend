package com.example.FurnitureMart3D_Backend.Controller;

import com.example.FurnitureMart3D_Backend.Dto.Product.Model3DDto;
import com.example.FurnitureMart3D_Backend.Model.Model3D;
import com.example.FurnitureMart3D_Backend.Repository.Model3DRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class Model3DController {
    @Autowired
    private Model3DRepository repository;

    @PostMapping("/add3DModel")
    public String Save(@RequestBody Model3D model){
        repository.save(model);
        return "Success";
    }

    @GetMapping(value = "/view3DModel", produces = APPLICATION_JSON_VALUE)
    public Model3D view3DModel(@RequestBody Model3DDto model3DDto) {
        Model3D modelSearched = null;
        try {
            List<Model3D> allUserModelList = repository.findAll();
            for ( Model3D model : allUserModelList) {
                if (model.getUserId() == model3DDto.getUserId() & model.getProductId() == model3DDto.getProductId() && model.getClrId() == model3DDto.getClrId()){
                    modelSearched = model;
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("Exception in view 3D Model");
        }

        return modelSearched;
    }

    @DeleteMapping(value = "/delete3DModel")
    public boolean delete3DModel(@RequestBody Model3DDto model3DDto) {
        boolean response = false;
        try {
            List<Model3D> allUserModelList = repository.findAll();
            for ( Model3D model : allUserModelList) {
                if (model.getUserId() == model3DDto.getUserId() & model.getProductId() == model3DDto.getProductId() && model.getClrId() == model3DDto.getClrId()){
                    repository.delete(model);
                    response=true;
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("Exception in delete 3D Model");
        }

        return response;
    }
}
