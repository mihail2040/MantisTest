package com.test.Dem.BDDMantis.Helper;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.test.Dem.BDDMantis.Issue;
import com.test.Dem.BDDMantis.User;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * Created by Максим on 29.05.2017.
 */
public class ResourceLoader {

    public static Map<String, User> users;

    public static Map<String, Issue> issues;

    private static final String DATA_USERS_JSON = "data/users.json";

    private static final String DATA_ISSUES_JSON = "data/issues.json";

    static {
        loadUsers();
        loadIssues();
    }

    @SneakyThrows
    private static void loadIssues() {
        String rawData = getRawData(DATA_ISSUES_JSON);
        issues = new Gson().fromJson(rawData, new TypeToken<Map<String, Issue>>(){}.getType());
    }

    @SneakyThrows
    private static void loadUsers() {
        String rawData = getRawData(DATA_USERS_JSON);
        users = new Gson().fromJson(rawData, new TypeToken<Map<String, User>>(){}.getType());
    }

    private static String getRawData(String dataUserJson) throws IOException {
        URL resource = ResourceLoader.class.getClassLoader().getResource(dataUserJson);
        return IOUtils.toString(resource, "utf-8");
    }

}
