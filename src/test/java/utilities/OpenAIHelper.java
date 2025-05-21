package utilities;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;
import io.github.cdimascio.dotenv.Dotenv;

public class OpenAIHelper {

    public static String GetLocatorsForPageAsJson(String pagesource) {

        Dotenv env = Dotenv.load();
        String apikey = env.get("OPENAI_API_KEY");

        String prompt = """ 
                    Return only a JSON array of locators from the page source %s,
                    provided the locator for the element described in
                    { locatorName: 'name of the locator',
                    locatorType: 'css|xpath|id|name|linkText|partialLinkText'
                    locatorValue: 'value' }
                """;

        OpenAIClient client = OpenAIOkHttpClient.builder()
                .apiKey(apikey)
                .build();

        ResponseCreateParams params = ResponseCreateParams.builder()
                .input(String.format(prompt, pagesource))
                .model(ChatModel.GPT_4_1)
                .build();

        System.out.println(params);

        Response response = client.responses().create(params);

        return response.toString();

    }
}
