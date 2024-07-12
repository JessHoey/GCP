package gcfv2;

import java.io.BufferedWriter;
import java.util.logging.Logger;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;

public class HelloHttpFunction implements HttpFunction {

private static final Logger logger = Logger.getLogger(HelloHttpFunction.class.getName());

@Override
public void service(HttpRequest request, HttpResponse response) throws Exception {
String method = request.getMethod();
BufferedWriter writer = response.getWriter();

if ("GET".equals(method)) {
handleGet(request, writer);
} else if ("POST".equals(method)) {
handlePost(request, writer);
} else if ("DELETE".equals(method)) {
handleDelete(request, writer);
} else {
writer.write("Method not supported: " + method);
}
}

private void handleGet(HttpRequest request, BufferedWriter writer) throws Exception {
writer.write("GET method called");
}

private void handlePost(HttpRequest request, BufferedWriter writer) throws Exception {
writer.write("POST method called");
}

private void handleDelete(HttpRequest request, BufferedWriter writer) throws Exception {
writer.write("DELETE method called");
}
}