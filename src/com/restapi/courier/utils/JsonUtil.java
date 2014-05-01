package com.restapi.courier.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.restapi.courier.dto.Consignment;

public class JsonUtil {
	
	 public  String createJsonString(Object object) throws IOException {
	  Writer writer = new StringWriter();
	  JsonFactory factory = new JsonFactory();
	  JsonGenerator generator = factory.createJsonGenerator(writer);
	  generator.setCodec(new ObjectMapper());
	  generator.writeObject(object);
	  generator.close();
	  return writer.toString();
	 }
	 

}
