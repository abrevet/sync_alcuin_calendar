package fr.adam.sync_calendar;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.regex.Pattern;

public class Calendar {

    public Calendar() {

    }

    public String get_User_Id() throws IOException, InterruptedException {
        Utils u = new Utils();
        HttpResponse response = u.request("https://esaip.alcuin.com/OpDotNet/Context/context.jsx");
     //   Pattern p = Pattern.compile("\\w+[0-9])");
     //   p.matcher(response.toString());
        return 1;
    }
}
