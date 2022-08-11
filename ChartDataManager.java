import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class ChartDataManager extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException{
		try {
			response.setCharacterEncoding("utf-8");
     		 	ArrayList<Object> list = new ArrayList<Object>(); //Load this ArrayList with the data you need
			Writer writer = response.getWriter();
			JsonObject chartData = new JsonObject();
      			JsonArray labels = new JsonArray();
      			JsonArray datasets = new JsonArray();
     			JsonObject dataset = new JsonObject();
      			JsonArray data = new JsonArray();
      			for(Object object : list){  //Use this for to push the values
       				labels.add(object.getLabel()); //Insert columns into labels
        			data.add(object.getData());    //Inser rows into data
      			}
      			String nameOfData = "", lineColor = "";
      			dataset.add("data", data);
		  	dataset.addProperty("label", nameOfData);
		  	dataset.addProperty("borderColor", lineColor);
		 	dataset.addProperty("fill", false);
      			//If you want to make a comparative chart, you'll need more than one dataset
		  	datasets.add(dataset);
      			chartData.add("labels", labels);
		  	chartData.add("datasets", datasets);
      			writer.write(chartData.toString();
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
