package serverless.helloworld_invoke;

import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;

public class App {

    public static void main( String[] args ) {

        final HelloWorldFunction helloWorld = LambdaInvokerFactory.builder()
        		 .lambdaClient(AWSLambdaClientBuilder.defaultClient())
        		 .build(HelloWorldFunction.class);

        HelloWorldInput input = new HelloWorldInput("it's input : Hey form Java class App");

        final HelloWorldOutput helloWorldOutput = helloWorld.sayHello(input); //call to AWS
        String response = helloWorldOutput.getMessage();			//response from AWS
        System.out.println( response );

    }

}
