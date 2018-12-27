package service.AAALOGGER;

import java.beans.Transient;

import org.json.JSONObject;

import service.AAALOGGER.util.Logger;

import com.avaya.app.entity.Instance;
import com.avaya.app.entity.NodeInstance;
import com.roobroo.bpm.model.BpmNode;

public class LoggerExecution extends NodeInstance {

	private static final long serialVersionUID = 1L;
	private LoggerModel model;
	
	public LoggerExecution(Instance instance, BpmNode node) {
		super(instance, node);
		if ((node instanceof LoggerModel)) {
			this.model = ((LoggerModel) node);
		} else {
			throw new IllegalStateException(
					"Error: node is not a ReadDBModel node.");
		}
	}

	public Object execute() throws Exception {
		JSONObject json = new JSONObject();
		
	    String wfdName = this.instance.getWfdSvar().getId().getWfdName();
	    String wfdVersion = this.instance.getWfdSvar().getId().getWfdVersion();
	    String instanceId = this.instance.instanceId();
	    String label = getNode().getName();
		String name = (String)get("name");
		if ((name == null) || (name.isEmpty())) {
			name = getReadDBModel().getLogName();
		}
	    Logger logger = new Logger(wfdName, wfdVersion, instanceId, label);
	    
		try {
			logger.init(name);
			String body = (String)get("LogMessage");
			if ((body == null) || (body.isEmpty())) {
				body = getReadDBModel().getLogMessage();
			}
			
			if(getReadDBModel().getNivel().equals("FATAL")){
				logger.FATAL(body);
			}
			if(getReadDBModel().getNivel().equals("ERROR")){
				logger.ERROR(body);
			}
			if(getReadDBModel().getNivel().equals("WARN")){
				logger.WARN(body);
			}
			if(getReadDBModel().getNivel().equals("INFO")){
				logger.INFO(body);
			}
			if(getReadDBModel().getNivel().equals("FINE")){
				logger.FINE(body);
			}
			if(getReadDBModel().getNivel().equals("FINER")){
				logger.FINER(body);
			}
			if(getReadDBModel().getNivel().equals("FINEST")){
				logger.FINEST(body);
			}
		    
			json.put("status", NodeInstance.Status.SUCCESS.toString());
			// Se usa para obtener el nombre del task ej. AAALogger1 (label)
//			json.put("getNode.getName", getNode().getName());
			
		} catch (Exception e) {
			json.put("error", e.toString());
			logger.close();
			return json;
		}
		logger.close();
		return json;
	}
	
	
	@Transient
	public LoggerModel getReadDBModel() {
		if (this.model == null) {
			this.model = ((LoggerModel) getNode());
		}
		return this.model;
	}
}
