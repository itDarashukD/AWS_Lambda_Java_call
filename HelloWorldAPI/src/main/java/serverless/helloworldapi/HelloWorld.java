package serverless.helloworldapi;

/**
 * Hello World with REST API
 * //the handler needs to be added to AVS L :serverless.helloworldapi.HelloWorld	(import package+class)
 *
 * just create an API and put link to browser
 */

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class HelloWorld implements RequestStreamHandler {

    JSONParser parser = new JSONParser();

    public void handleRequest(InputStream inputStream,OutputStream outputStream,Context context) throws IOException {

        LambdaLogger logger = context.getLogger();
        logger.log("Loading Java Lambda handler of ProxyWithStream");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject responseJson = new JSONObject();
        String name = "";

        try {
	   JSONObject event = (JSONObject) parser.parse(reader);
	   if (event.get("queryStringParameters") != null) {
	       JSONObject qps = (JSONObject) event.get("queryStringParameters");
	       if (qps.get("name") != null) {
		  name = (String) qps.get("name");
	       }
	   }

	   String greeting = "Hello " + name + "!";

	   JSONObject responseBody = new JSONObject();
	   responseBody.put("message", greeting);

	   JSONObject headerJson = new JSONObject();
	   responseJson.put("isBase64Encoded", false);
	   responseJson.put("statusCode", 200);
	   responseJson.put("body", responseBody.toString());

        } catch (ParseException pex) {
	   responseJson.put("statusCode", "400");
	   responseJson.put("exception", pex);
        }

        logger.log(responseJson.toJSONString());
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseJson.toJSONString());
        writer.close();
    }


}