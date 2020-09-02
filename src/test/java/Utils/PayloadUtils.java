package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayloadUtils { // requestBody == Payload

    public static String getPetPayload(int id, String name, String status){
        return "{\n" +
                "  \"id\": "+id+",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \""+status+"\"\n" +
                "}";
    }

    public static String putMethod(String name,String job){
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";
    }

    public static String generateStringFromResource(String path) throws IOException{

        String petPayload=new String(Files.readAllBytes(Paths.get(path)));
        return petPayload;
    }


    public static String getJiraIssuePayload(String summary,String description,String issuetype){
        return "{\n" +
                "    \"fields\":{\n" +
                "        \"project\":{\n" +
                "            \"key\":\"TECH\"\n" +
                "        },\n" +
                "        \"summary\":\""+summary+"\",\n" +
                "        \"description\":\""+description+"\",\n" +
                "        \"issuetype\":{\n" +
                "            \"name\":\""+issuetype+"\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }
//    public static String getJSessionCookie() throws URISyntaxException, IOException {
//        HttpClient client= HttpClientBuilder.create().build();
//        URIBuilder uriBuilder=new URIBuilder();
//        uriBuilder.setScheme("http").setHost("localhost").setPort(8080).setPath("rest/auth/1/session");
//        HttpPost post=new HttpPost(uriBuilder.build());
//        post.setHeader("Content-Type","application/json");
//        post.setHeader("Accept","application/json");
//        HttpEntity entity= new StringEntity(Utils.PayloadUtil.getCookieAuthPayload());
//        post.setEntity(entity);
//        HttpResponse response=client.execute(post);
//        ObjectMapper objectMapper=new ObjectMapper();
//        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());
//        PojoClass jiraCookiePojo=objectMapper.readValue(response.getEntity().getContent(),PojoClass.class);
//        String cookieName=jiraCookiePojo.getSession().get("name");
//        String cookieValue=jiraCookiePojo.getSession().get("value");
//        return String.format("%s=%s",cookieName,cookieValue);
//    }

}
