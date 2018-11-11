package core.jess;

import java.util.Iterator;

import app.Root;
import jess.Filter;
import jess.JessException;
import jess.Rete;
import model.JessResult;
import model.Person;
import repository.PersonRepository;

public class JessEngine {

    private Rete engine = new Rete();

    public JessEngine() throws JessException {
        engine.reset();
        engine.batch(Root.convertPath("rules/rules.clp"));
    }

    public JessResult checkPersons() throws JessException {
        engine.reset();
        try {
            for (Person p: PersonRepository.getInstance().getPersons()) {
                engine.add(p);
            }
            engine.run();
            Iterator iter = engine.getObjects(new Filter.ByClass(JessResult.class));
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }
        } catch (JessException e) {
            e.printStackTrace();
        }
        return  new JessResult(new Person().getId(),"");
    }
}
