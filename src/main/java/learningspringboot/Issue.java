package learningspringboot;

import org.springframework.social.github.api.GitHubIssue;

/**
 * Created by nadal on 15. 2. 28..
 */
public class Issue {
    private String repo;
    private GitHubIssue githubIssue;

    public Issue(String repo, GitHubIssue gitHubIssue) {
        this.repo = repo;
        this.githubIssue = gitHubIssue;
    }

    public String getRepo() {
        return repo;
    }

    public GitHubIssue getGithubIssue() {
        return githubIssue;
    }
}
