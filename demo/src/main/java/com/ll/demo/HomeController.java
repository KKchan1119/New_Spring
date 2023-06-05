package com.ll.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Map;
@Controller // 개발자가 스프링부트에게 전달
//하단의 HomeController는 컨트롤러다
public class HomeController {
    private int count;

    public HomeController(){
        count = -1;
    }
    @GetMapping("/home/main")//GetPost, 해당요청시 아래의 메서드 호출
    @ResponseBody // 아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    public String showMain(){
        return "HelloWorld";
    }

    @GetMapping("/home/main2")
    @ResponseBody
    public String showMain2(){
        return "김유범 바보";
    }

    @GetMapping("/home/main3")
    @ResponseBody
    public String showMain3(){
        return "정민이 바보";
    }

    @GetMapping("/home/increase")
    @ResponseBody
    public int showIncrease(){
        count++;
        return count;
    }
    @GetMapping("/home/plus_test")
    @ResponseBody
    public int showPlus_Test(){
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
    public int showPlus(@RequestParam(defaultValue = "0")int a, @RequestParam(defaultValue = "0") int b){
        //(defaultValue = "0") - 옵션등을 추가 가능함,
        return a + b;//http://172.16.10.93:8080/home/plus?a=100&b=200 ?뒷부분은 쿼리스트링

    }

    @GetMapping("/home/returnBoolean")
    @ResponseBody
    public boolean showReturnBoolean(){
        return true;
    }

    @GetMapping("/home/returnDouble")
    @ResponseBody
    public Double showReturnDouble(){
        return Math.PI;
    }
    @GetMapping("/home/returnIntArray")
    @ResponseBody
    public int[] showReturnIntArray(){
        int[] arr = new int[] {10, 20, 30};
        return arr;
    }
}
