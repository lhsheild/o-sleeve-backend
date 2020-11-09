package io.github.talelin.latticy;

import io.github.talelin.latticy.module.file.FileProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicReference;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LatticyApplicationTests {

    @Autowired
    private FileProperties fileProperties;

    @Test
    public void contextLoads() {
        System.out.println();
    }

    @Test
    public void tempTest() {
        AtomicReference<Integer> index = new AtomicReference<>(0);
        for (int i = 0; i < 5; i++) {

            System.out.println(index.get());
            index.getAndUpdate(v -> v + 1);
        }
    }

}
