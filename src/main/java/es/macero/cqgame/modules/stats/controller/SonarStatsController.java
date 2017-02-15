package es.macero.cqgame.modules.stats.controller;

import es.macero.cqgame.modules.stats.domain.SonarStatsRow;
import es.macero.cqgame.modules.stats.service.SonarStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping(value = {"/legacykillers", "/"})
public class SonarStatsController {
    private SonarStatsService sonarStatsService;

    @Autowired
    public SonarStatsController(final SonarStatsService sonarStatsService) {
        this.sonarStatsService = sonarStatsService;
    }

    @RequestMapping(value = {"/users", ""}, method = RequestMethod.GET)
    public String statsHome(final Map<String, Object> model) {
        Collection<SonarStatsRow> stats = sonarStatsService.getSortedStatsPerUser();
        model.put("stats", stats);
        return "sonarstats";
    }

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public String statsTeams(final Map<String, Object> model) {
        Collection<SonarStatsRow> stats = sonarStatsService.getSortedStatsPerTeam();
        model.put("statsTeams", stats);
        return "sonarstats";
    }
}
