package by.it.academy.services.teams;

import by.it.academy.entities.Team;

import java.util.List;

public interface TeamService {
    List<Team> readTeams();

    Team createTeam(Team team);

    Team setTeam(long id, Team team);

    void updateMembers(Team team, List<String> membersId);

    void updateTasks(Team team, List<String> tasksId);

    void deleteTeam(Team team);

    void getDefaultTeams();

    Team getTeam(long teamId);

}


