package by.it.academy.services.teams;

import by.it.academy.entities.Team;
import by.it.academy.repositories.teams.TeamRepository;
import by.it.academy.repositories.teams.TeamRepositoryImpl;

import java.util.List;

public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository = TeamRepositoryImpl.getInstance();
    private static TeamService teamService;

    private TeamServiceImpl() {
    }

    public static TeamService getInstance() {
        if (teamService == null) {
            teamService = new TeamServiceImpl();
        }
        return teamService;
    }

    @Override
    public List<Team> readTeams() {
        return teamRepository.readTeams();
    }

    @Override
    public void getDefaultTeams() {
        teamRepository.getDefaultTeams();
    }

    @Override
    public Team getTeam(long teamId) {
        return teamRepository.getTeam(teamId);
    }

    @Override
    public Team createTeam(Team team) {
        return teamRepository.createTeam(team);


    }

    @Override
    public Team setTeam(long id, Team team) {
        return teamRepository.setTeam(id, team);
    }

    @Override
    public void updateMembers(Team team, List<String> membersId) {
        teamRepository.updateMembers(team, membersId);
    }

    @Override
    public void updateTasks(Team team, List<String> tasksId) {
        teamRepository.updateTasks(team, tasksId);
    }


    @Override
    public void deleteTeam(Team team) {
        teamRepository.deleteTeam(team);
    }
}
