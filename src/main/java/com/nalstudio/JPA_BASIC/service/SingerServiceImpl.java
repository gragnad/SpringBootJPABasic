package com.nalstudio.JPA_BASIC.service;

import com.nalstudio.JPA_BASIC.domain.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service("singerService")
@Repository
@Transactional
public class SingerServiceImpl implements SingerService{

    private static Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Singer> findAll() {
        return em.createNamedQuery(Singer.FIND_ALL, Singer.class).getResultList();
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Singer> findByFirstNameAndLastName(String firstName, String lastName) {
        return null;
    }

    @Transactional
    @Override
    public List<Singer> findByAllWithAlbum() {
        List<Singer> singers =  em.createNamedQuery(Singer.FIND_SINGER_ALL_WITH_ALBUM, Singer.class).getResultList();
        return singers;
    }

    @Override
    public List<Singer> findNySingerID(Long singerId) {
        return null;
    }
}
