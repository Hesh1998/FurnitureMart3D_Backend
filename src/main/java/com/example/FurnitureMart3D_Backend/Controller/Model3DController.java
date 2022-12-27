package com.example.FurnitureMart3D_Backend.Controller;

import com.example.FurnitureMart3D_Backend.Dto.Product.Model3DDto;
import com.example.FurnitureMart3D_Backend.Dto.Product.Model3DIdsDto;
import com.example.FurnitureMart3D_Backend.Dto.User.UsernameDto;
import com.example.FurnitureMart3D_Backend.Model.Model3D;
import com.example.FurnitureMart3D_Backend.Model.Product;
import com.example.FurnitureMart3D_Backend.Model.User;
import com.example.FurnitureMart3D_Backend.Repository.Model3DRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping(value = "/getUser3DModels/{userId}", produces = APPLICATION_JSON_VALUE)
    public List<Model3D> view3DModel(@PathVariable Integer userId) {
        List<Model3D> userModels = new ArrayList<>();
        try {
            List<Model3D> allUserModelList = repository.findAll();
            for ( Model3D model : allUserModelList) {
                if (model.getUserId() == userId){
                    userModels.add(model);
                }
            }
        }catch (Exception e){
            System.out.println("Exception in view 3D Model");
        }

        return userModels;
    }

    @DeleteMapping(value = "/delete3DModel")
    public boolean delete3DModel(@RequestBody Model3DDto model3DDto) {
        boolean response = false;
        try {
            List<Model3D> allUserModelList = repository.findAll();
            for ( Model3D model : allUserModelList) {
                if (model.getUserId() == model3DDto.getUserId() & model.getProductId() == model3DDto.getProductId() && model.getClrId() == model3DDto.getClrId()){
                    repository.deleteById(model.getId());
                    response=true;
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("Exception in delete 3D Model");
        }

        return response;
    }

    @GetMapping( value = "/getAll3DModelIds" , produces = APPLICATION_JSON_VALUE)
    public List<Model3DIdsDto> find3DModelIds(){
        List<Model3DIdsDto> idList = new ArrayList<>();
        try {
            List<Model3D> modelList = repository.findAll();
            for (Model3D model: modelList) {
                idList.add(new Model3DIdsDto(model.getId()));
            }
        }catch (Exception e){
            System.out.println("Exception in find 3D Model Ids");
        }
        return idList;
    }
}
