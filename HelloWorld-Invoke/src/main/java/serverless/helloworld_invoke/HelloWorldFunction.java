package serverless.helloworld_invoke;

import com.amazonaws.services.lambda.invoke.LambdaFunction;

public interface HelloWorldFunction {

  @LambdaFunction(functionName="lambda-java") //name of created Lambda function in AWS
  HelloWorldOutput sayHello(HelloWorldInput input);  //sayHello() in code of L in AWS

}