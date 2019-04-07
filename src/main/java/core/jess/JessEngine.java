package core.jess;

import java.util.Iterator;

import app.Root;
import jess.Filter;
import jess.JessException;
import jess.Rete;
import jess.WorkingMemoryMarker;
import model.JessCoupleResult;
import model.JessSingleResult;
import model.Person;
import model.Result;
import repository.PersonRepository;

public class JessEngine {

    private final String RULES_PATH = "rules/rules.clp";

    private static Rete engine = new Rete();

    private static JessEngine instance;
    private WorkingMemoryMarker stateMarker;

    private JessEngine() {
        try {
            engine.reset();
            engine.batch(Root.convertPath(RULES_PATH));
            stateMarker = engine.mark();
        } catch (JessException e) {
            e.printStackTrace();
        }
    }

    public static JessEngine getInstance() {
        if (instance == null) {
            instance = new JessEngine();
        }
        return instance;
    }

    public Result checkPersons() throws JessException {
        var jessResults = new Result();
        engine.resetToMark(stateMarker);

        try {
            for (Person p: PersonRepository.getInstance().getPersons()) {
                engine.add(p);
            }
            engine.run();
            Iterator singles = engine.getObjects(new Filter.ByClass(JessSingleResult.class));
            while (singles.hasNext()) {
                jessResults.getPersonResults().add((JessSingleResult) singles.next());
            }
            Iterator couples = engine.getObjects(new Filter.ByClass(JessCoupleResult.class));
            while (couples.hasNext()) {
                jessResults.getPersonCoupleResults().add((JessCoupleResult) couples.next());
            }
        } catch (JessException e) {
            e.printStackTrace();
        }

        return jessResults;
    }
}
