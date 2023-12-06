//package com.example.projectwebautocenterbukin.controllers.postmanControllers;
//
//import com.example.projectwebautocenterbukin.services.ModelService;
//import com.example.projectwebautocenterbukin.services.dtos.ModelDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/model")
//public class ModelController {
//    private ModelService modelService;
//    @Autowired
//    public void setModelService(ModelService modelService) {
//        this.modelService = modelService;
//    }
//    @GetMapping("/all")
//    List<ModelViewModelInput> getAllModels(){
//        return modelService.getAllModels();
//    }
//    @GetMapping("/{id}")
//    ModelViewModelInput getModelById(@PathVariable UUID id){
//        return modelService.getModelById(id);
//    }
//    @PostMapping("/add")
//    void addNewModel(@RequestBody ModelDto modelDto){
//        modelService.addNewModel(modelDto);
//    }
//    @DeleteMapping("/delete/{id}")
//    String deleteModel(@PathVariable UUID id){
//        modelService.deleteModel(id);
//        return "Model with id = " + id + " was deleted";}
//
//    @PutMapping("/{id}/{name}")
//    void updateBrandName(@PathVariable UUID id, @PathVariable String name){
//        modelService.updateModelName(id, name);}
//
//}
