package edu.du.sb1014;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class Sb1014ApplicationTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    void insert_Memo() {
        IntStream.range(0, 10).forEach(i -> {
            Memo memo = Memo.builder().memoText("샘플"+i).build();
            memoRepository.save(memo);
        });
    }

    @Test
    void select_Memo() {
        Long mno = 10L;
        Optional<Memo> result = memoRepository.findById(mno);
        if (result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        } else {
            System.out.println("없");
        }
    }

    @Test
    void selectAll_Memo() {
        List<Memo> memos = memoRepository.findAll();
        for (Memo memo : memos) {
            System.out.println(memo);
        }
    }

    @Test
    void update_Memo() {
        Memo memo = Memo.builder().id(1L).memoText("샘플100").build();
        memoRepository.save(memo);
    }

    @Test
    void delete_Memo() {
        Long mno = 10L;
        memoRepository.deleteById(mno);
    }

}
