package sg.edu.rp.c346.id22027500.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewdbs;
    TextView textViewocbc;
    TextView textViewuob;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewdbs = findViewById(R.id.tvdbs);
        textViewocbc = findViewById(R.id.tvocbc);
        textViewuob = findViewById(R.id.tvuob);

        registerForContextMenu(textViewdbs);
        registerForContextMenu(textViewocbc);
        registerForContextMenu(textViewuob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo
            menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");

        if (v == textViewdbs) {
            wordClicked = "Dbs";
        } else if (v == textViewocbc) {
            wordClicked = "OCBC";
        } else {
            wordClicked = "UOB";

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) {
                Intent intentweb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intentweb);
            } else if (item.getItemId() == 1) {
                String tel = "18001111111";
                long num = Long.parseLong(tel);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + num));
                startActivity(intentCall);
            }
        } else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) {
                Intent intentweb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentweb);
            } else if (item.getItemId() == 1) {
                String tel = "18003633333";
                long num = Long.parseLong(tel);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + num));
                startActivity(intentCall);
            }
        } else if (wordClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 0) {
                Intent intentweb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentweb);
            } else if (item.getItemId() == 1) {
                String tel = "18002222121";
                long num = Long.parseLong(tel);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + num));
                startActivity(intentCall);
            }
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            textViewdbs.setText("DBS");
            textViewuob.setText("UOB");
            textViewocbc.setText("OCBC");
        } else if (id == R.id.ChineseSelection) {
            textViewdbs.setText("星展银行");
            textViewocbc.setText("华侨银行");
            textViewuob.setText("大华银行");
        }
        return super.onOptionsItemSelected(item);
    }
}












