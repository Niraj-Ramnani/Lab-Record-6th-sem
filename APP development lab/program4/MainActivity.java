package com.example.program4;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Xml;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.xmlpull.v1.XmlPullParser;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private List<String> titles = new ArrayList<>();
    private String rssUrl = "https://rss.nytimes.com/services/xml/rss/nyt/World.xml"; // RSS Feed URL

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        new FetchFeed().execute(rssUrl);
    }

    private class FetchFeed extends AsyncTask<String, Void, List<String>> {
        @Override
        protected List<String> doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5000); // Set timeout
                conn.setReadTimeout(5000);

                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStream is = conn.getInputStream();
                    return parseXML(is);
                } else {
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<String> result) {
            if (result != null && !result.isEmpty()) {
                titles = result;
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, titles);
                lv.setAdapter(adapter);
            } else {
                Toast.makeText(MainActivity.this, "Failed to load RSS feed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private List<String> parseXML(InputStream is) throws Exception {
        List<String> items = new ArrayList<>();
        XmlPullParser p = Xml.newPullParser();
        p.setInput(is, null);
        boolean insideItem = false;
        int eType;

        while ((eType = p.next()) != XmlPullParser.END_DOCUMENT) {
            if (eType == XmlPullParser.START_TAG) {
                if (p.getName().equalsIgnoreCase("item")) {
                    insideItem = true;
                } else if (insideItem && p.getName().equalsIgnoreCase("title")) {
                    items.add(p.nextText());
                }
            } else if (eType == XmlPullParser.END_TAG && p.getName().equalsIgnoreCase("item")) {
                insideItem = false;
            }
        }
        return items;
    }
}
