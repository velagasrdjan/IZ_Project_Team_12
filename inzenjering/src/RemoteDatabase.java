import org.apache.jena.base.Sys;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import java.util.ArrayList;
import java.util.List;

public class RemoteDatabase {

    private static final String QUERY_URL = "http://localhost:3030/novaDB/sparql";
    private static final String UPDATE_URL = "http://localhost:3030/novaDB/update";


   /* public static String parseImpact(String impact){
        String result = "";
        if(impact.length()==0){
            return result;
        }
        else{
            String[] impacts = impact.split(":");
            for(String s : impacts){
                result = result + " attacks:impact attacks:"+s.replaceAll(" ", "") + ";";
            }
        }
        return result;
    }

    public static String parseScope(String scope){
        String result = "";
        if(scope.length()==0){
            return result;
        }else{
            String[] scopes = scope.split(":");
            for(String s : scopes){
                result = result + " attacks:scope attacks:"+s.replaceAll(" ", "") + ";";
            }
        }
        return result;
    }

    public static String insertScope(String scope){
        String result = "";
        String[] scopes = scope.split(":");
        for(String s : scopes){
            result = result
                    + " attacks:"+s.replaceAll(" ", "") +" a attacks:Scope;"
                    + "attacks:name '"+s +"' ^^<http://w3.org/2001/XMLSchema#string> .";
        }
        return result;
    }

    public static String insertImpact(String impact){
        String result = "";
        String[] impacts = impact.split(":");
        for(String s : impacts){
            result = result
                    + " attacks:"+s.replaceAll(" ", "") +" a attacks:Impact;"
                    + "attacks:name '"+s +"' ^^<http://w3.org/2001/XMLSchema#string> .";
        }
        return result;
    }

    public static String insertLevel(String level){
        String result =  "attacks:"+ level+"  a        attacks:Level ;"
        +"attacks:name  '"+level+"' ^^<http://w3.org/2001/XMLSchema#string> .";
        return result;
    }

    public static void insertQuery(Attack attack) {
        // INSERT
        String insertString = ""
                + "PREFIX attacks: <https://github.com/velagasrdjan/IZ_Project_Team_12.git/attacks#> "
                + "INSERT DATA {"
                + " attacks:" + attack.name.replaceAll(" ", "") + " a attacks:Attack ; "
                + parseImpact(attack.impact)
                + " attacks:mitigations  '" + attack.mitigations + "' ^^<http://w3.org/2001/XMLSchema#string>;"
                + " attacks:name  '" + attack.name + "' ^^<http://w3.org/2001/XMLSchema#string>;"
                + " attacks:prerequisites attacks:" + attack.prerequisites + ";"
                + " attacks:risk   attacks:" + attack.risk + ";"
                + parseScope(attack.scope)
                + " attacks:severity attacks:" + attack.severity + ";"
                + " attacks:skills_required attacks:" + attack.skills_required + "."
                + insertImpact(attack.impact)
                + insertScope(attack.scope)
                + insertLevel(attack.prerequisites)
                + insertLevel(attack.risk)
                + insertLevel(attack.severity)
                + insertLevel(attack.skills_required)
                + "}";
        System.out.println(insertString);

        UpdateRequest updateRequest = UpdateFactory.create(insertString);
        UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
        updateProcessor.execute();
    }*/
   public static void insertQuery(Attack attack) {
       // INSERT
       String insertString = ""
               + "PREFIX attacks: <https://github.com/velagasrdjan/IZ_Project_Team_12.git/attacks#> "
               + "INSERT DATA {"
               + " attacks:" + attack.name.replaceAll(" ", "") + " a attacks:Attack ; "
               + " attacks:impact  '" + attack.impact + "' ^^<http://w3.org/2001/XMLSchema#string>;"
               + " attacks:mitigations  '" + attack.mitigations + "' ^^<http://w3.org/2001/XMLSchema#string>;"
               + " attacks:name  '" + attack.name + "' ^^<http://w3.org/2001/XMLSchema#string>;"
               + " attacks:prerequisites  '" + attack.prerequisites + "' ^^<http://w3.org/2001/XMLSchema#string>;"
               + " attacks:risk  '" + attack.risk + "' ^^<http://w3.org/2001/XMLSchema#string>;"
               + " attacks:scope  '" + attack.scope + "' ^^<http://w3.org/2001/XMLSchema#string>;"
               + " attacks:skills_required  '" + attack.skills_required + "' ^^<http://w3.org/2001/XMLSchema#string>."
               + "}";
       System.out.println(insertString);

       UpdateRequest updateRequest = UpdateFactory.create(insertString);
       UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
       updateProcessor.execute();
   }

    public static void selectAllQuery() {
        String queryString = ""
            +"PREFIX attacks: <https://github.com/velagasrdjan/IZ_Project_Team_12.git/attacks#>"
            +"SELECT ?x ?name ?scope ?impact ?mitigations ?skills_required ?risk ?prerequisites ?severity" +
                " WHERE { ?x a attacks:Attack; attacks:name  ?name ; attacks:impact  ?impact;" +
                " attacks:mitigations  ?mitigations; attacks:skills_required  ?skills_required;" +
                " attacks:prerequisites  ?prerequisites; attacks:severity  ?severity; attacks:risk  ?risk; attacks:scope  ?scope.}";

        List<Attack> attackList =  new ArrayList<>();

        Query query = QueryFactory.create(queryString);
        try {
            QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);

            ResultSet results = qexec.execSelect() ;
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution() ;
                Resource resource = solution.getResource("x");

                //attackList.add(new Attack(solution.getLiteral("name").getString(), ));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void load(Attack attack) {
        // DELETE
        String deleteString = ""
                + "PREFIX iz: <http://www.ftn.uns.ac.rs/iz#> "
                + "DELETE "
                + "WHERE {"
                + "    iz:XYZ ?x ?y ."
                + "}";
        UpdateRequest updateRequest2 = UpdateFactory.create(deleteString);
        UpdateProcessor updateProcessor2 = UpdateExecutionFactory.createRemote(updateRequest2, UPDATE_URL);
        updateProcessor2.execute();

        // SELECT
        String queryString = ""
                + "PREFIX iz: <http://www.ftn.uns.ac.rs/iz#> "
                + "SELECT ?profesor ?imeProfesora "
                + "WHERE {"
                + "    ?predmet a iz:Predmet ;"
                + "        iz:profesor ?profesor ."
                + "    ?profesor a iz:Osoba ;"
                + "        iz:ime ?imeProfesora ."
                + "}";
        Query query = QueryFactory.create(queryString) ;
        try {
            QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);

            ResultSet results = qexec.execSelect() ;
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution() ;
                Resource resource = solution.getResource("profesor");
                Literal literal = solution.getLiteral("imeProfesora");
                System.out.println(resource.getURI());
                System.out.println(literal.getString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
