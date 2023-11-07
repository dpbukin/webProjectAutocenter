package com.example.projectwebautocenterbukin.init;

import com.example.projectwebautocenterbukin.models.enums.Category;
import com.example.projectwebautocenterbukin.models.enums.Engine;
import com.example.projectwebautocenterbukin.models.enums.Role;
import com.example.projectwebautocenterbukin.models.enums.Transmission;
import com.example.projectwebautocenterbukin.services.*;
import com.example.projectwebautocenterbukin.services.dtos.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private BrandService brandService;
    private ModelService modelService;
    private OfferService offerService;
    private UserRoleService userRoleService;
    private UserService userService;
    private ModelMapper modelMapper;

    public DataInitializer(BrandService brandService, ModelService modelService, OfferService offerService, UserRoleService userRoleService, UserService userService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
        this.userRoleService = userRoleService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();

    }

    private void seedData() throws IOException {
        BrandDto brandDto1 = new BrandDto("BMW", LocalDateTime.now(), LocalDateTime.now());
        System.out.println(brandDto1.getId());
        BrandDto brandDto2 = new BrandDto("Audi", LocalDateTime.now(),LocalDateTime.now());
        BrandDto brandDto3 = new BrandDto("Mercedes-Benz", LocalDateTime.now(), LocalDateTime.now());
        BrandDto brandDto4 = new BrandDto("Toyota", LocalDateTime.now(),LocalDateTime.now());
        BrandDto brandDto5 = new BrandDto("Honda", LocalDateTime.now(),LocalDateTime.now());

        brandService.addNewBrand(brandDto1);
        System.out.println(brandDto1.getId());
        brandService.addNewBrand(brandDto2);
        brandService.addNewBrand(brandDto3);
        brandService.addNewBrand(brandDto4);
        brandService.addNewBrand(brandDto5);

        ModelDto modelDto1 = new ModelDto("X5", Category.CAR, "x5.jpg", 2000, 2022,LocalDateTime.now(), LocalDateTime.now(), brandDto1);
        System.out.println(brandDto1.getId());
        ModelDto modelDto2 = new ModelDto("A6", Category.CAR, "a6.jpg", 1999, 2021, LocalDateTime.now(), LocalDateTime.now(), brandDto2);
        ModelDto modelDto3 = new ModelDto("C-Class", Category.CAR, "c-class.jpg", 1998, 2022, LocalDateTime.now(),LocalDateTime.now(), brandDto3);
        ModelDto modelDto4 = new ModelDto("Camry", Category.CAR, "camry.jpg", 1997, 2021, LocalDateTime.now(), LocalDateTime.now(), brandDto4);
        ModelDto modelDto5 = new ModelDto("Civic", Category.CAR, "civic.jpg", 1995, 2022, LocalDateTime.now(), LocalDateTime.now(), brandDto5);

        modelService.addNewModel(modelDto1);
        modelService.addNewModel(modelDto2);
        modelService.addNewModel(modelDto3);
        modelService.addNewModel(modelDto4);
        modelService.addNewModel(modelDto5);

        UserRoleDto userRoleDto1 = new UserRoleDto(Role.USER);
        UserRoleDto userRoleDto2 = new UserRoleDto(Role.ADMIN);

        userRoleService.addUserRole(userRoleDto1);
        userRoleService.addUserRole(userRoleDto2);

        UserDto userDto1 = new UserDto("user1", "password1", "Иван", "Петров", true, "user1.jpg", LocalDateTime.now(), LocalDateTime.now(), userRoleDto1);
        UserDto userDto2 = new UserDto("user2", "password2", "Екатерина", "Сидорова", true, "user2.jpg", LocalDateTime.now(), LocalDateTime.now(), userRoleDto1);
        UserDto userDto3 = new UserDto("user3", "password3", "Михаил", "Иванов", true, "user3.jpg", LocalDateTime.now(), LocalDateTime.now(), userRoleDto1);
        UserDto userDto4 = new UserDto("user4", "password4", "Анна", "Смирнова", true, "user4.jpg", LocalDateTime.now(), LocalDateTime.now(), userRoleDto1);
        UserDto userDto5 = new UserDto("user5", "password5", "Павел", "Козлов", true, "user5.jpg", LocalDateTime.now(), LocalDateTime.now(), userRoleDto1);

        userService.addUser(userDto1);
        userService.addUser(userDto2);
        userService.addUser(userDto3);
        userService.addUser(userDto4);
        userService.addUser(userDto5);

        OfferDto offerDto1 = new OfferDto("BMW X5 на продажу", Engine.GASOLINE, "x5.jpg", 50000, new BigDecimal(80000.55), Transmission.AUTOMATIC, 2020,LocalDateTime.now(), LocalDateTime.now(), modelDto1 , userDto1);
        OfferDto offerDto2 = new OfferDto("Audi A6 отличное предложение", Engine.GASOLINE, "a6.jpg", 40000, new BigDecimal(28000.0), Transmission.AUTOMATIC, 2019,LocalDateTime.now(), LocalDateTime.now(), modelDto2, userDto2);
        OfferDto offerDto3 = new OfferDto("Mercedes-Benz C-Class как новый", Engine.DIESEL, "c-class.jpg", 30000, new BigDecimal(25000.0), Transmission.AUTOMATIC, 2018,LocalDateTime.now(), LocalDateTime.now(), modelDto3, userDto3);
        OfferDto offerDto4 = new OfferDto("Toyota Camry с малым пробегом", Engine.HYBRID, "camry.jpg", 20000, new BigDecimal(20000.0), Transmission.AUTOMATIC, 2017, LocalDateTime.now(), LocalDateTime.now(), modelDto4, userDto4);
        OfferDto offerDto5 = new OfferDto("Honda Civic в отличном состоянии", Engine.GASOLINE, "civic.jpg", 15000, new BigDecimal(15000.0), Transmission.MANUAL, 2016,LocalDateTime.now(), LocalDateTime.now(), modelDto5, userDto5);

        offerService.addNewOffer(offerDto1);
        offerService.addNewOffer(offerDto2);
        offerService.addNewOffer(offerDto3);
        offerService.addNewOffer(offerDto4);
        offerService.addNewOffer(offerDto5);

        System.out.println();
        System.out.println("Проверка работы CRUD");
        System.out.println("Вывод всех брендов:");
        List<BrandDto> brandsDtos = brandService.getAllBrands();

        for (BrandDto brandDto : brandsDtos) {
            System.out.println(brandDto);
        }
        System.out.println();
        System.out.println("Вывод всех моделей:");
        List<ModelDto> modelDtos = modelService.getAllModels();
        for (ModelDto modelDto:modelDtos){
            System.out.println(modelDto);
        }
        System.out.println();
        System.out.println();
        System.out.println("Вывод всех предложений:");

        List<OfferDto> offerDtos = offerService.getAllOffers();
        for (OfferDto offerDto : offerDtos) {
            System.out.println(offerDto);
        }

        System.out.println();

        System.out.println("Вывод всех пользователей:");

        List<UserDto> userDtos = userService.getAllUsers();
        for (UserDto userDto : userDtos) {
            System.out.println(userDto);
        }

        System.out.println();

        System.out.println("Вывод всех ролей пользователей:");

        List<UserRoleDto> userRoleDtos = userRoleService.getAllUserRoles();
        for (UserRoleDto userRoleDto : userRoleDtos) {
            System.out.println(userRoleDto);
        }

        System.out.println();

        System.out.println("Нахождение по ID");
        System.out.println("Модель:");
        System.out.println(modelService.getModelById(modelDto1.getId()).toString());
        System.out.println();
        System.out.println("Предложение:");
        System.out.println(offerService.getOfferById(offerDto1.getId()).toString());
        System.out.println();
        System.out.println("Бренд:");
        System.out.println(brandService.getBrandById(brandDto1.getId()).toString());
        System.out.println();
        System.out.println("Пользователя:");
        System.out.println(userService.getUserById(userDto1.getId()).toString());
        System.out.println();
        System.out.println("Роль пользователя");
        System.out.println(userRoleService.getUserRoleById(userRoleDto1.getId()).toString());
        System.out.println();


        System.out.println("Пример обновления названия модели");
        ModelDto updatedModelDto = new ModelDto();
        updatedModelDto.setName("X6");

//        ModelDto updatedModel = modelService.updateModelName(modelDto1.getId(), );
//        System.out.println(updatedModel.toString());
//        System.out.println();




        System.out.println("метод deactivateUser:");
        userService.deactivateUser(userDto1.getId());


        System.out.println("Вывод объявлений по User isActive которого true");
        List<OfferDto> offerDtos1 = offerService.findOffersWithActiveClients();
        for (OfferDto x: offerDtos1){
            System.out.println(x.toString());
        }




    }
}
