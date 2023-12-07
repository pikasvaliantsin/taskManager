package by.it.academy.repositories.teams;

import by.it.academy.entities.Task;
import by.it.academy.entities.Team;
import by.it.academy.entities.User;
import by.it.academy.repositories.tasks.TaskRepository;
import by.it.academy.repositories.tasks.TaskRepositoryImpl;
import by.it.academy.repositories.users.UserRepository;
import by.it.academy.repositories.users.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class TeamRepositoryImpl implements TeamRepository {

    private static TeamRepository teamRepository;
    private static final UserRepository userRepository = UserRepositoryImpl.getInstance();
    private static final TaskRepository taskRepository = TaskRepositoryImpl.getInstance();

    private final List<Team> teams = new ArrayList<>();
    private final List<User> members = new ArrayList<>();

    private final List<Task> tasks = new ArrayList<>();

    private TeamRepositoryImpl() {
    }

    public static TeamRepository getInstance() {
        if (teamRepository == null) {
            teamRepository = new TeamRepositoryImpl();
        }
        return teamRepository;
    }

    public void getDefaultTeams() {
        teams.add(new Team(1L, "Team1", members, tasks));
        teams.add(new Team(2L, "Team2", members, tasks));
        members.add(userRepository.getUser(1));
        members.add(userRepository.getUser(2));
        tasks.add(taskRepository.getTask(1));
        tasks.add(taskRepository.getTask(2));

    }

    @Override
    public Team getTeam(long teamId) {
        return teams.stream()
                .filter(team -> team.getTeamId() == teamId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int getTeamIndex(long teamId) {
        return IntStream.range(0, teams.size())
                .filter(i -> teams.get(i).getTeamId() == teamId)
                .findFirst()
                .orElse(-1);
    }

    @Override
    public List<Team> readTeams() {
        return teams;
    }

    @Override
    public Team createTeam(Team team) {
        team.setTeamId(teams.size() + 1);
        teams.add(team);
        return team;
    }

    @Override
    public Team setTeam(long id, Team team) {
        int index = getTeamIndex(id);
        team.setTeamId(id);
        teams.set(index, team);
        return team;
    }

    @Override
    public void deleteTeam(Team team) {
        teams.remove(team);
    }

    @Override
    public void updateMembers(Team team, List<String> membersId) {
        List<User> updatedMembers = membersId.stream()
                .map(Long::parseLong)
                .map(userRepository::getUser)
                .collect(Collectors.toList());
        team.setMembers(updatedMembers);
    }

    @Override
    public void updateTasks(Team team, List<String> tasksId) {
        List<Task> updatedTasks = tasksId.stream()
                .map(Long::parseLong)
                .map(taskRepository::getTask)
                .collect(Collectors.toList());
        team.setTasks(updatedTasks);
    }
}
