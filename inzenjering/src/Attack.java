public class Attack {
    public String name;
    public String impact;
    public String mitigations;
    public String prerequisites;
    public String risk;
    public String scope;
    public String severity;
    public String skills_required;


    public Attack(String name, String impact, String mitigations, String prerequisites, String risk, String scope, String severity, String skills_required) {
        this.name = name;
        this.impact = impact;
        this.mitigations = mitigations;
        this.prerequisites = prerequisites;
        this.risk = risk;
        this.scope = scope;
        this.severity = severity;
        this.skills_required = skills_required;
    }
}
