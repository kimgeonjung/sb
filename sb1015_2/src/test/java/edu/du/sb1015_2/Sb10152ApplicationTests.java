package edu.du.sb1015_2;

import edu.du.sb1015_2.entity.MyData;
import edu.du.sb1015_2.repository.MyDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Sb10152ApplicationTests {

    @Autowired
    MyDataRepository repository;

    @Test
    void 데이터_전체_출력() {
        List<MyData> list = repository.findAll();
        for (MyData myData : list) {
            System.out.println(myData);
        }
    }

    @Test
    void 데이터_단일_출력(){
        Optional<MyData> myData = repository.findById(1L);
        myData.ifPresent(System.out::println);
    }

    @Test
    void 데이터_추가(){
        MyData myData = new MyData();
        myData.setAge(21);
        myData.setName("원태인");
        myData.setMail("won@samsung.co.kr");
        myData.setMemo("삼성 원태인");
        repository.save(myData);
    }

    @Test
    void 데이터_삭제(){
        repository.deleteById(11L);
    }
}
