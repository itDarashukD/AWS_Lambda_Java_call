package serverless.helloworld;

import com.amazonaws.services.lambda.runtime.Context;
//it's code of Lambda --> install and  upload to AWS the jar
//add the handler to aws : serverless.helloworld.HelloWorld::sayHello
//mvn package clean install, upload jar to aws


public class HelloWorld {
    public HelloWorldOutput sayHello(HelloWorldInput input, Context ctx) {
        HelloWorldOutput output = new HelloWorldOutput();
        output.setMessage("Hello " + input.getName() + "! (Java rocks!)");

        return output;
    }
}
