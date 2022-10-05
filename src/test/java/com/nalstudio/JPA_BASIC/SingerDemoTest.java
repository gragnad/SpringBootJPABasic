package com.nalstudio.JPA_BASIC;

import com.nalstudio.JPA_BASIC.domain.Singer;
import com.nalstudio.JPA_BASIC.service.SingerService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class SingerDemoTest {

    private static Logger logger = LoggerFactory.getLogger(SingerDemoTest.class);
    @Resource(name = "singerService")
    private SingerService singerService;

    @Test
    public void getSingerFindAll() {
        List<Singer> singerList = singerService.findAll();
        singerList.forEach(s -> {
            logger.info(s.toString());
        });
    }

    @Test

    public void getFindAllWithAlbum() {
        List<Singer> singers = singerService.findByAllWithAlbum();
        singers.forEach(s -> {
            logger.info(s.toString() + "Singer------------");
            if(s.getAlbums() != null) {
                s.getAlbums().forEach(a -> {logger.info(a.toString());});
            }
            if(s.getInstruments() != null) {
                s.getInstruments().forEach(i -> {logger.info(i.toString());});
            }
        });
    }
}
