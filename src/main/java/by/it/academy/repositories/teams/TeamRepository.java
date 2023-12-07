package by.it.academy.repositories.teams;

import by.it.academy.entities.Team;

import java.util.List;

public interface TeamRepository {
    List<Team> readTeams();

    Team createTeam(Team team);

    Team setTeam(long id, Team team);

    void deleteTeam(Team team);

    void updateMembers(Team team, List<String> membersId);

    void updateTasks(Team team, List<String> tasksId);

    void getDefaultTeams();

    Team getTeam(long teamId);

    int getTeamIndex(long teamId);
}
