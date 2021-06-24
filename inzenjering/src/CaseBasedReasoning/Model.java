package CaseBasedReasoning;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Model implements CaseComponent{

	//Name,Risk,Severity,Scope,Impact,Skills Required,Prerequisites,Mitigations
	
	private String name;
	private String risk;
	private String scope;
	private String severity;
	private String impact;
	private String skills;
	private String prerequisites;
	private String mitigations;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getImpact() {
		return impact;
	}
	public void setImpact(String impact) {
		this.impact = impact;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}
	public String getMitigations() {
		return mitigations;
	}
	public void setMitigations(String mitigations) {
		this.mitigations = mitigations;
	}
	public Model(String name, String risk, String scope, String severity, String impact, String skills,
			String prerequisites, String mitigations) {
		super();
		this.name = name;
		this.risk = risk;
		this.scope = scope;
		this.severity = severity;
		this.impact = impact;
		this.skills = skills;
		this.prerequisites = prerequisites;
		this.mitigations = mitigations;
	}
	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Model [name=" + name + ", risk=" + risk + ", scope=" + scope + ", severity=" + severity + ", impact="
				+ impact + ", skills=" + skills + ", prerequisites=" + prerequisites + ", mitigations=" + mitigations
				+ "]";
	}
	@Override
	public Attribute getIdAttribute() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	
	
	
	
	
}
