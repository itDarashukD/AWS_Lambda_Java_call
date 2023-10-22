package serverless.helloworld_invoke;

public class HelloWorldInput {
    String name;
    
    HelloWorldInput() {
    	//empty
    }
    
    HelloWorldInput(String name) {
    	this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}