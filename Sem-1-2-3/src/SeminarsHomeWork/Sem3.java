package SeminarsHomeWork;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import javax.xml.bind.*;
//import java.io.StringWriter;

import java.io.*;

class Student implements Serializable {
    private String name;
    private int age;
    private transient double GPA;

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }
}

public class Sem3 {
    public static void main(String[] args) {
        Student student = new Student("John Doe", 20, 3.8);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(student);
            System.out.println("Serialization completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println("Deserialization completed.");

            System.out.println("Name: " + deserializedStudent.getName());
            System.out.println("Age: " + deserializedStudent.getAge());
            System.out.println("GPA: " + deserializedStudent.getGPA());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
//        Задача 2: Сериализация в XML и JSON
              
//                Student student1 = new Student("John Doe", 20, 3.8);
//
//                try {
//                    ObjectMapper objectMapper = new ObjectMapper();
//                    String jsonString = objectMapper.writeValueAsString(student1);
//
//                    // Выводим JSON-строку
//                    System.out.println("JSON Representation:");
//                    System.out.println(jsonString);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }


//      Задача 2: Используя JAXB (XML):

//        Student student2 = new Student("John Doe", 20, 3.8);
//        try {
//            JAXBContext context = JAXBContext.newInstance(Student.class);
//            Marshaller marshaller = context.createMarshaller();
//
//            // Преобразование объекта в XML и выводим результат
//            StringWriter writer = new StringWriter();
//            marshaller.marshal(student2, writer);
//
//            System.out.println("XML Representation:");
//            System.out.println(writer.toString());
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }



