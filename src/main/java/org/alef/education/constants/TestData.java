package org.alef.education.constants;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestData {

    public static Map<String,String> getVeterinariansData() {
        Map<String,String> dataMap = new HashMap<>();
        dataMap.put("Linda Douglas","dentistry surgery");
        dataMap.put("Rafael Ortega","surgery");
        dataMap.put("Henry Stevens","radiology");
        dataMap.put("Sharon Jenkins","none");
        dataMap.put("James Carter","none");
        dataMap.put("Helen Leary","radiology");

        return dataMap;
    }

    public static Map<String,String[]> getOwnersData() {
        Map<String,String[]> dataMap = new HashMap<>();
        dataMap.put("Eduardo Rodriquez", new String[]{"2693 Commerce St.", "McFarland", "6085558763", "Jewel Rosy"});
        dataMap.put("David Schroeder",new String[]{"2749 Blackhawk Trail", "Madison", "6085559435", "Freddy"});
        dataMap.put("Harold Davis",new String[]{"563 Friendly St.", "Windsor", "6085553198", "Iggy"});
        dataMap.put("Jeff Black",new String[]{"1450 Oak Blvd.", "Monona", "6085555387", "Lucky"});
        dataMap.put("Betty Davis",new String[]{"638 Cardinal Ave.", "Sun Prairie", "6085551749", "Basil"});
        dataMap.put("Carlos Estaban",new String[]{"2335 Independence La.", "Waunakee", "6085555487", "Lucky Sly"});
        dataMap.put("George Franklin",new String[]{"110 W. Liberty St.", "Madison", "6085551023", "Leo"});
        dataMap.put("Peter McTavish",new String[]{"2387 S. Fair Way", "Madison", "6085552765", "George"});
        dataMap.put("Maria Escobito",new String[]{"345 Maple St.", "Madison", "6085557683", "Mulligan"});
        dataMap.put("Jean Coleman",new String[]{"105 N. Lake St.", "Monona", "6085552654", "Max Samantha"});

        return dataMap;
    }

    public static Map<String,String> generateOwnerTestData() {
        Map<String,String> dataMap = new LinkedHashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyHH");

        String firstName = "Auto_FN_"+formatter.format(new Date());
        String lastName = "Auto_LN_"+formatter.format(new Date());
        String address = "Auto_Address_"+formatter.format(new Date());
        String city = "Auto_City_"+formatter.format(new Date());
        String telephone = formatter.format(new Date());

        dataMap.put("firstName",firstName);
        dataMap.put("lastName",lastName);
        dataMap.put("address",address);
        dataMap.put("city",city);
        dataMap.put("telephone",telephone);

        return dataMap;
    }

    public static Map<String,String> generatePetTestData() {
        Map<String,String> dataMap = new LinkedHashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyHH");
        Random random = new Random();

        List<String> petTypes = Arrays.asList("cat", "dog", "bird", "hamster", "lizard", "snake");
        List<String> months = Arrays.asList(
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        );

        int randomMonthIndex = random.nextInt(months.size());
        int randomTypeIndex = random.nextInt(petTypes.size());

        int randomYear = random.nextInt(2024 - 2000 + 1) + 2000;
        int randomDay = random.nextInt(31) + 1;

        String name = "Auto_Name_"+formatter.format(new Date());
        String year = String.valueOf(randomYear);
        String month = months.get(randomMonthIndex);
        String day = String.valueOf(randomDay);
        String petType = petTypes.get(randomTypeIndex);

        dataMap.put("name",name);
        dataMap.put("year",year);
        dataMap.put("month",month);
        dataMap.put("day",day);
        dataMap.put("petType",petType);

        dataMap.put("monthIndex", String.format("%02d",months.indexOf(month)+1));

        return dataMap;
    }


}
