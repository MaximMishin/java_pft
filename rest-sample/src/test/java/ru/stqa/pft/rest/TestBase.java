package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;

import java.util.List;

public class TestBase {

  @BeforeClass
  public void init() {
    RestAssured.authentication = RestAssured
            .basic("288f44776e7bec4bf44fdfeb1e646490", "");
  }


  public boolean isIssueOpen(int issueId) {
    String json = RestAssured.get("http://bugify.stqa.ru/api/issues/" + issueId + ".json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    List<Issue> word = new Gson().fromJson(issues, new TypeToken<List<Issue>>(){}.getType());
    System.out.println(word.get(0).getState_name());

    if (!word.get(0).getState_name().equals("Closed")) {
      return true;
    }
    return false;
  }

  public void skipIfNotFixed(int issueId) {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}