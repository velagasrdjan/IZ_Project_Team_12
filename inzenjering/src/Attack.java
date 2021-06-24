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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImpact() {
		return impact;
	}


	public void setImpact(String impact) {
		this.impact = impact;
	}


	public String getMitigations() {
		return mitigations;
	}


	public void setMitigations(String mitigations) {
		this.mitigations = mitigations;
	}


	public String getPrerequisites() {
		return prerequisites;
	}


	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}


	public String getRisk() {
		return risk;
	}


	public void setRisk(String risk) {
		this.risk = risk;
	}


	public String getScope() {
		return scope;
	}


	public void setScope(String scope) {
		this.scope = scope;
	}


	public String getSeverity() {
		return severity;
	}


	public void setSeverity(String severity) {
		this.severity = severity;
	}


	public String getSkills_required() {
		return skills_required;
	}


	public void setSkills_required(String skills_required) {
		this.skills_required = skills_required;
	}





	public Attack() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}
