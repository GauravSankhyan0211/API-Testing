package AllRequests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class APIRequest {
	
	String accessToken  = "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";
	
	@Test(enabled = false)
	public void Authentication() {
		given().header("Authorization", "Bearer " + accessToken).
		get("https://api.github.com/user/repos").then().log().all();
		
	}
	
	
	@Test(enabled = true)
	public void createRepositoryForAuthenticatedUser() {
		
	    JSONObject js = new JSONObject();
	    js.put("name","Hello-World2");
	    js.put("description", "This is your first repo!");
	    js.put("homepage","https://github.com");
	    js.put("private",false);
	    js.put("is_template",true);
	    given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(js.toJSONString())
	    .when().post("https://api.github.com/user/repos").then() .log().all();
	    
		}
	
	@Test(enabled = true)
	public void UpdateaRepository() {
		
		JSONObject js = new JSONObject();
		js.put("name", "Hello-Gaurav-Sharma");
		js.put("description", "This is  first repository");
		js.put("homepage", "https://github.com");
		js.put("private", true);
		js.put("has_issues", true);
		js.put("has_projects", true);
		js.put("has_wiki", true);	
		given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(js.toJSONString()).when()
		.patch("https://api.github.com/repos/GauravSankhyan0211/patchrepo").then().log().all();
		
	}
	
	@Test(enabled = false)
	public void deletearepo() {
		given().header("Authorization", "Bearer " + accessToken).
		delete("https://api.github.com/repos/GauravSankhyan0211/For_deleting").then().log().all();
			
	}
		
	@Test(enabled = false)
	public void getarepo () {
		given().header("Authorization", "Bearer " + accessToken).
		get("https://api.github.com/repos/GauravSankhyan0211/Gaurav-").then().log().all();
			
	}
	
	@Test(enabled = false)
	public void listRepoForAUser() {
		given().header("Authorization", "Bearer " + accessToken).
		get("https://api.github.com/users/GauravSankhyan0211/repos").then().log().all();
		
	}
	
	@Test(enabled = false)
	public void ListRepoLanguage() {
		given().header("Authorization", "Bearer " + accessToken).
		get("https://api.github.com/repos/GauravSankhyan0211/Gaurav-/languages").then().log().all();
			
	}
	
	@Test(enabled = false)
	public void ListPublicRepo() {
		given().header("Authorization", "Bearer " + accessToken).
		get("https://api.github.com/repositories").then().log().all();	
		
	}
	
	@Test(enabled = false)
	public void createOrUpdateFileContent(){
		
		JSONObject js = new JSONObject();
		js.put("message", "Hello All ");
		JSONObject committer = new JSONObject();
        committer.put("name", " Gaurav Sankhyan");
        committer.put("email", "gauravsankhyan@github.com");
        js.put("committer", committer);
		js.put("content", "bXkgbmV3IGZpbGUgY29udGVudHM=");
		given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(js.toJSONString()).when()
		.put("https://api.github.com/repos/GauravSankhyan0211/API_Project3/contents/PATH").then().log().all();
	
	}
	
	@Test(enabled = false)
	public void deleteAFile () {
		
		JSONObject js = new JSONObject();
		js.put("message","my commit message");
		JSONObject deleter = new JSONObject();
		deleter.put("name", " Gaurav Sankhyan");
		deleter.put("email", "gauravsankhyan@github.com");  
	    js.put("committer", deleter);
	    js.put("sha","0d5a690c8fad5e605a6e8766295d9d459d65de42");	
		given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(js.toJSONString()).when().
		delete("https://api.github.com/repos/GauravSankhyan0211/API_Project3/contents/PATH").then().log().all();	
		
	}
	
	@Test(enabled = false)
	public void listRepoTag () {
		
		given().header("Authorization", "Bearer " + accessToken).
		get("https://api.github.com/repos/GauravSankhyan0211/Hello-Gaurav-Sankhyan").then().log().all();
		
	}
	
	@Test(enabled = false)
	public void creatAnAutolinkReferenceForRepo () {
		
		JSONObject js = new JSONObject();
		  js.put("key_prefix", "Bill-");
		  js.put("url_template", "https://example.com/TICKET?query=<num>");
		  js.put("is_alphanumeric", true);
		given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(js.toJSONString()).when().
		post("https://api.github.com/repos/GauravSankhyan0211/createlink2/autolinks").then().log().all();
		
	}
	
	@Test(enabled = false)
	public void  getAllRepoTopic() {
		
		given().header("Authorization", "Bearer " + accessToken).
		get("https://api.github.com/repos/GauravSankhyan0211/API_Project/topics").then().log().all();
		
	}
	
	@Test(enabled = false)
	public void getAnAutolinkReferenceForARepo () {
		
		given().header("Authorization", "Bearer " + accessToken).
		get("https://api.github.com/repos/GauravSankhyan0211/createlink2/autolinks/4220091").then().log().all();	
		
	}
	
	@Test(enabled = false)
	public void deleteFromAnAutolinkReferenceForARepo() {
		
		
		given().header("Authorization", "Bearer " + accessToken).
		delete("https://api.github.com/repos/GauravSankhyan0211/createlink2/autolinks/4220091").then().log().all();	
		
	}
	
	@Test(enabled = false)
	public void getARepo() {
		
		given().header("Authorization", "Bearer " + accessToken).
		get("https://api.github.com/repos/GauravSankhyan0211/Api_project2").then().log().all();	
		
	}
	
	@Test(enabled = true)
	public void replaceRepoTopics() {
		
		JSONObject js = new JSONObject();
		List<String> name = List.of("gaurav", "atom", "electron", "api");
		js.put("names", name);
		given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
		.body(js.toJSONString()).when().put("https://api.github.com/repos/GauravSankhyan0211/API_Project/topics")
		.then().log().all();
		
	}

	
}

