package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Created by EZDI\manjunath.y on 5/2/16.
 */
@SpringBootApplication
public class MyApplication {

    public static void main(String args[]){
        ApplicationContext applicationContext = SpringApplication.run(MyApplication.class, args);

        System.out.println("The beans configured (automatically by spring-boot!!) are: ");
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        if(beanNames != null){
            Arrays.sort(beanNames);
            for(String each: beanNames){
                System.out.println(each);
            }
        }
        else{
            System.out.println("beanNames is NULL");
        }
    }

}
