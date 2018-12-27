package service.AAALOGGER.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	FileWriter fichero = null;
	PrintWriter pw = null;
	String wfdName;
	String wfdVersion;
	String instanceId;
	String label;
	
	public Logger(){}
	
	public Logger(String wfdName, String wfdVersion, String instanceId, String label) {
		this.wfdName = wfdName;
		this.wfdVersion = wfdVersion;
		this.instanceId = instanceId;
		this.label = label;
	}

	public void init(String name) throws IOException{

		//RUTA LAB 213
		fichero = new FileWriter("home/wsuser/web/Log/"+name+".txt", true);
		
		pw = new PrintWriter(fichero);
	}
	
	public void close() throws IOException{
		fichero.close();
	}
	
	
	
	public void FATAL(String body){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        
		pw.println(df.format(date) +"_" + wfdName + "_" +wfdVersion+ "_" +instanceId+ "_" +label+" FATAL "+ body);
	}
	
	
	public void ERROR(String body){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        
        pw.println(df.format(date) +"_" + wfdName + "_" +wfdVersion+ "_" +instanceId+"_"+label+" ERROR "+ body);
	}
	
	public void WARN(String body){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        
        pw.println(df.format(date) +"_" + wfdName + "_" +wfdVersion+ "_" +instanceId+"_"+label+" WARN "+ body);
	}
	
	
	public void INFO(String body){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        
        pw.println(df.format(date) +"_" + wfdName + "_" +wfdVersion+ "_" +instanceId+"_"+label+" INFO "+ body);
	}
	
	public void FINE(String body){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        
        pw.println(df.format(date) +"_" + wfdName + "_" +wfdVersion+ "_" +instanceId+"_"+label+" FINE "+ body);
	}
	
	public void FINER(String body){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        
        pw.println(df.format(date) +"_" + wfdName + "_" +wfdVersion+ "_" +instanceId+"_"+label+" FINER "+ body);
	}
	
	public void FINEST(String body){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        
        pw.println(df.format(date) +"_" + wfdName + "_" +wfdVersion+ "_" +instanceId+"_"+label+" FINEST "+ body);
	}
	
}
