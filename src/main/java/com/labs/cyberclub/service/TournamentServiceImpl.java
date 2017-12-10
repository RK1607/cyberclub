package com.labs.cyberclub.service;

import com.labs.cyberclub.dao.interfaces.TournamentDao;
import com.labs.cyberclub.entity.Tournament;
import com.labs.cyberclub.service.interfaces.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentDao tournamentDao;

    @Override
    public List<Tournament> getAll() {
        return tournamentDao.getAll();
    }
}
