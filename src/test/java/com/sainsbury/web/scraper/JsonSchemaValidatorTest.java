package com.sainsbury.web.scraper;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.google.common.base.Joiner;

/**
 * 
 * This test class tests the json against the schema
 * 
 * @author ARaut
 *
 */
public abstract class JsonSchemaValidatorTest {

	private String schemaText;
	
	protected JsonSchemaValidatorTest(String schema) {
		
		try {
			
			schemaText = readFile(schema);
			
		} catch(Exception ioe) {
			fail(ioe.getMessage());
		}
	}	
	
	protected void assertValidJson(String json) throws Exception  {
			
		JsonNode schemaNode = JsonLoader.fromString(schemaText);
		JsonNode data = JsonLoader.fromString(json);  
		JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
		JsonSchema schema = factory.getJsonSchema(schemaNode);
		ProcessingReport report = schema.validate(data);
		
		Iterator<ProcessingMessage> iter = report.iterator();
		String failures = Joiner.on('\n').join(iter);
        Assert.assertTrue(failures, report.isSuccess());
	}
	
	protected String readFile(String fileName) throws IOException{
		String json = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream(fileName),"UTF-8");
		return json;
	}
}

