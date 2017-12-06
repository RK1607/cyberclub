package service.impl;

import dao.TournamentDao;
import entity.Tournament;
import org.springframework.stereotype.Service;
import service.TournamentService;

import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    private TournamentDao tournamentDao;

    @Override
    public List<Tournament> getAll() {
        return tournamentDao.getAll();
    }
}
