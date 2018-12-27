package service.AAALOGGER;

import java.util.ArrayList;
import java.util.List;

public class FillerUtil {
	
	private static FillerUtil instance = null;
	
	public static FillerUtil getInstance()
	  {
	    if (instance == null) {
	      synchronized (FillerUtil.class)
	      {
	        if (instance == null) {
	          instance = new FillerUtil();
	        }
	      }
	    }
	    return instance;
	  }
	
	public List<String> comboNivel()
	  {
	    List<String> contentTypeList = new ArrayList();
	    contentTypeList.add("Seleccionar nivel");
	    contentTypeList.add("FATAL");
	    contentTypeList.add("ERROR");
	    contentTypeList.add("WARN");
	    contentTypeList.add("INFO");
	    contentTypeList.add("FINE");
	    contentTypeList.add("FINER");
	    contentTypeList.add("FINEST");
	    return contentTypeList;
	  }


}
