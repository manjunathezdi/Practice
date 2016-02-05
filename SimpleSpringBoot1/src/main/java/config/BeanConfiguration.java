package config;

import hibernate.dao.StudentSaver;
import hibernate.dao.impl.StudentSaverImpl;
import hibernate.model.Student;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import javax.sql.DataSource;


/**
 * Created by EZDI\manjunath.y on 5/2/16.
 */

@Configuration
public class BeanConfiguration {

    @Bean
    public Student getStudentNullApplicationContext(){
        Student student = new Student();
        student.setName("ApplicationContext is null");
        return student;
    }

    @Bean
    public Student getStudentNullSessionFactory(){
        Student student = getStudentNullApplicationContext();
        student.setName("SessionFactory is null");
        return  student;
    }

    @Bean
    public DataSource getDataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/hibtest");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("P@ssw0rd@123");
        return basicDataSource;
    }

    @Bean
    public SessionFactory getSessionFactory(){
        LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
        localSessionFactoryBuilder.addAnnotatedClasses(Student.class);
        return  localSessionFactoryBuilder.buildSessionFactory();
    }

    @Bean
    public StudentSaver getStudentSaver(SessionFactory sessionFactory){
        StudentSaverImpl studentSaver = new StudentSaverImpl();
        studentSaver.setSessionFactory(sessionFactory);
        return studentSaver;
    }
}
