package com.ll.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller // 개발자가 스프링부트에게 전달
//하단의 HomeController는 컨트롤러다
public class HomeController {
    private int count;

    public HomeController() {
        count = -1;
    }

    @GetMapping("/home/main")//GetPost, 해당요청시 아래의 메서드 호출
    @ResponseBody // 아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    public String showMain() {
        return "HelloWorld";
    }

    @GetMapping("/home/main2")
    @ResponseBody
    public String showMain2() {
        return "김유범 바보";
    }

    @GetMapping("/home/main3")
    @ResponseBody
    public String showMain3() {
        return "정민이 바보";
    }

    @GetMapping("/home/increase")
    @ResponseBody
    public int showIncrease() {
        count++;
        return count;
    }

    @GetMapping("/home/plus_test")
    @ResponseBody
    public int showPlus_Test() {
        int a = 1;
        int b = 2;

        return a + b;
    }

    @GetMapping("/home/plus")
    @ResponseBody
    //@RequestParam
    //개발자가 스프링부트에게
    //int a 는 쿼리스트링에서 a 파라미터의 값을 얻은 후 정수화 한 값이어야 한다.
    //@RequestParam 생략가능, 순서 상관 없음
    public int showPlus(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        //(defaultValue = "0") - 옵션등을 추가 가능함,
        return a + b;//http://172.16.10.93:8080/home/plus?a=100&b=200 ?뒷부분은 쿼리스트링

    }

    @GetMapping("/home/returnBoolean")
    @ResponseBody
    public boolean showReturnBoolean() {
        return true;
    }

    @GetMapping("/home/returnDouble")
    @ResponseBody
    public Double showReturnDouble() {
        return Math.PI;
    }

    @GetMapping("/home/returnIntArray")
    @ResponseBody
    public int[] showReturnIntArray() {
        int[] arr = new int[]{10, 20, 30};
        return arr;
    }

    @GetMapping("/home/returnIntList")
    @ResponseBody
    public List<Integer> showReturnIntList() {
        List<Integer> list = new ArrayList<>() {{
            add(10);
            add(20);
            add(30);
        }};

        return list;
    }

    @GetMapping("/home/returnMap")
    @ResponseBody
    public Map<String, Object> showReturnMap() {
        Map<String, Object> map = new LinkedHashMap<>() {{
            put("id", 1);
            put("speed", 100);
            put("name", "카니발");
            put("relatedIds", new ArrayList<>() {{
                add(2);
                add(3);
                add(4);
            }});
        }};

        return map;
    }

    @GetMapping("/home/returnCar")
    @ResponseBody
    public Car showReturnCar() {
        Car car = new Car(1, 100, "소나타", new ArrayList<>() {{
            add(2);
            add(3);
            add(4);
        }});
        return car;
    }

    @GetMapping("/home/returnCarV2")
    @ResponseBody
    public CarV2 showReturnCarV2() {
        CarV2 car = new CarV2(1, 100, "페라리", new ArrayList<>() {{
            add(2);
            add(3);
            add(4);
        }});

        car.setName(car.getName() + "V2");
        return car;
    }

    @GetMapping("/home/returnMapList")
    @ResponseBody
    public List<Map<String, Object>> showReturnMapList() {
        Map<String, Object> carMap1 = new LinkedHashMap<>() {{
            put("id", 1);
            put("speed", 100);
            put("name", "카니발");
            put("relatedIds", new ArrayList<>() {{
                add(2);
                add(3);
                add(4);
            }});
        }};

        Map<String, Object> carMap2 = new LinkedHashMap<>() {{
            put("id", 1);
            put("speed", 120);
            put("name", "포르쉐");
            put("relatedIds", new ArrayList<>() {{
                add(5);
                add(6);
                add(7);
            }});
        }};

        List<Map<String, Object>> list = new ArrayList<>();

        list.add(carMap1);
        list.add(carMap2);

        return list;
    }

    @GetMapping("/home/returnCarList")
    @ResponseBody
    public List<CarV2> showReturnCarList() {

        CarV2 car1 = new CarV2(1, 210, "페라리", new ArrayList<>() {{
            add(2);
            add(3);
            add(4);
        }});

        CarV2 car2 = new CarV2(2, 200, "포르쉐", new ArrayList<>() {{
            add(5);
            add(6);
            add(7);
        }});

        List<CarV2> list = new ArrayList<>();

        list.add(car1);
        list.add(car2);

        return list;
    }

    @GetMapping("/home/returnAddPerson")
    @ResponseBody
    public String showAddPerson(String name, int age) {
        Person p = new Person(name, age);

        return "%d번 사람이 추가되었습니다." .formatted(p.getId());
    }
}

class Car {

    private final int id;
    private final int speed;
    private final String name;
    private final List<Integer> relatedIds;

    public Car(int id, int speed, String name, List<Integer> relatedIds) {
        this.id = id;
        this.speed = speed;
        this.name = name;
        this.relatedIds = relatedIds;
    }

    public int getId() {
        return id;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getRelatedIds() {
        return relatedIds;
    }
}

@AllArgsConstructor//모든 변수들의 생성자 자동 생성
@Getter//lombok
class CarV2 {

    private final int id;

    private final int speed;

    @Setter
    private String name; //final 은 Setter 생성 불가

    private final List<Integer> relatedIds;
}

@AllArgsConstructor
@Getter
class Person {
    private static int lastId;
    private final int id;
    private final String name;
    private final int age;
    static {
        lastId = 0;
    }
    Person(String name, int age){
        this(++lastId, name, age);
    }

}