package service.AAALOGGER;

import java.util.List;

import com.roobroo.bpm.model.BpmNode;
import com.roobroo.bpm.util.WFUtil;

public class LoggerModel extends BpmNode {

	private static final long serialVersionUID = 1L;

	public LoggerModel(String name, String id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}

	private String nivel;
	private String logMessage;
	private String logName;

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}

	@Override
	public boolean validateProperties(List<String> w, List<String> e) {
		boolean isValid = true;
		if ((!WFUtil.validateMapping(w, e, getDataInputAssociations(),
				"LogMessage"))
				&& (!WFUtil.validateEmptyProperty(logMessage, "LogMessage", e))) {
			isValid = false;

		}
		if ((!WFUtil.validateMapping(w, e, getDataInputAssociations(), "Nivel"))
				&& (!WFUtil.validateEmptyProperty(nivel, "Nivel", e))) {
			isValid = false;

		}

		return super.validateProperties(w, e) && isValid;

	}

}
