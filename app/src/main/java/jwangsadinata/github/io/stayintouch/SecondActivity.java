package jwangsadinata.github.io.stayintouch;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private static final String NAME_KEY = "NAME_KEY";

    private int photoId;
    private String emailAddress = "";
    private String websiteLink = "";
    private String linkedinId = "";
    private String facebookId = "";
    private String githubId = "";
    private String twitterId = "";
    private String tumblrId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final String name = getIntent().getExtras().getString(NAME_KEY);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        toolbar.setSubtitle("");

        final Button btnMail = (Button) findViewById(R.id.btnMail);
        final Button btnWebsite = (Button) findViewById(R.id.btnWebsite);
        final Button btnLinkedIn = (Button) findViewById(R.id.btnLinkedin);
        final Button btnFacebook = (Button) findViewById(R.id.btnFacebook);
        final Button btnGithub = (Button) findViewById(R.id.btnGithub);
        final Button btnTwitter = (Button) findViewById(R.id.btnTwitter);
        final Button btnTumblr = (Button) findViewById(R.id.btnTumblr);

        TextView tvCardViewName = (TextView) findViewById(R.id.tvCardViewName);
        ImageView ivPhoto = (ImageView) findViewById(R.id.ivPhoto);

        switch (name) {
            case "Joe Koshakow":
                photoId = R.drawable.jkoshakow;
                emailAddress = "jkoshakow@wesleyan.edu";
                linkedinId = "joekoshakow";
                facebookId = "koshy44";
                githubId = "jkosh44";
                twitterId = "jkosh44";
                break;
            case "Kendell Byrd":
                photoId = R.drawable.kbyrd;
                emailAddress = "kbyrd1@swarthmore.edu";
                linkedinId = "kendell-byrd-b5a7ba81";
                facebookId = "kendell.byrd.2265";
                twitterId = "flylikeabyrd22";
                break;
            case "Péter Ekler":
                photoId = R.drawable.peekler;
                emailAddress = "ekler.peter@aut.bme.hu";
                websiteLink = "https://www.aut.bme.hu/en/Staff/tyrael";
                linkedinId = "peterekler";
                githubId = "peekler";
                break;
            case "Gyula Y. Katona":
                photoId = R.drawable.gyulaykatona;
                emailAddress = "kiskat@cs.bme.hu";
                websiteLink = "http://www.cs.bme.hu/~kiskat/enghomepage.html";
                linkedinId = "gyula-y-katona-1542a119";
                break;
            case "Ákos Kocsány":
                photoId = R.drawable.akoscany;
                emailAddress = "akos.kocsany@gmail.com";
                linkedinId = "akos-kocsany-9a5aa256";
                facebookId = "akosk1";
                break;
            case "Jason Wangsadinata":
                photoId = R.drawable.jwangsadinata;
                emailAddress = "jason.christian19@gmail.com";
                linkedinId = "jwangsadinata";
                facebookId = "jcwangsadinata";
                githubId = "jwangsadinata";
                twitterId = "jcwangsadinata";
                tumblrId = "publicstaticfinaldestination";
                break;
            default:
                photoId = R.drawable.stayintouch_icon;
                break;
        }

        btnWebsite.setText(websiteLink);
        btnLinkedIn.setText("    " + linkedinId);
        btnFacebook.setText("    " + facebookId);
        btnGithub.setText("    " + githubId);
        btnTwitter.setText("    " + twitterId);
        btnTumblr.setText("        " + tumblrId);

        ivPhoto.setImageResource(photoId);
        tvCardViewName.setText(name);

        setVisibility(btnWebsite, btnLinkedIn, btnFacebook, btnGithub, btnTwitter, btnTumblr);

        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emailAddress.equals("")) {
                    sendEmail(name, emailAddress);
                } else {
                    Toast.makeText(SecondActivity.this, "Email address not found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite(websiteLink);
            }
        });

        btnLinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkedin(linkedinId);
            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFacebook(facebookId);
            }
        });

        btnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGithub(githubId);
            }
        });

        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTwitter(twitterId);
            }
        });

        btnTumblr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTumblr(tumblrId);
            }
        });
    }

    private void setVisibility(Button btnWebsite, Button btnLinkedIn, Button btnFacebook, Button btnGithub, Button btnTwitter, Button btnTumblr) {
        if (!websiteLink.equals("")) {
            btnWebsite.setVisibility(View.VISIBLE);
        }
        if (!linkedinId.equals("")) {
            btnLinkedIn.setVisibility(View.VISIBLE);
        }
        if (!facebookId.equals("")) {
            btnFacebook.setVisibility(View.VISIBLE);
        }
        if (!githubId.equals("")) {
            btnGithub.setVisibility(View.VISIBLE);
        }
        if (!twitterId.equals("")) {
            btnTwitter.setVisibility(View.VISIBLE);
        }
        if (!tumblrId.equals("")) {
            btnTumblr.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_search:
                Intent toSearch = new Intent(SecondActivity.this, SearchActivity.class);
                startActivity(toSearch);
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openLinkedin(String username) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/" + username));
            final PackageManager packageManager = this.getPackageManager();
            final List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            if (list.isEmpty()) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/profile/view?id=" + username));
            }
            startActivity(intent);
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/" + username)));
            String errorMessage = (e.getMessage() == null) ? "Message is empty" : e.getMessage();
            Log.e("LinkedInAppNotFound", errorMessage);
        }
    }

    private void sendEmail(String username, String email) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL,
                new String[]{email});
        i.putExtra(Intent.EXTRA_SUBJECT,
                "AIT StayInTouch App");
        i.putExtra(Intent.EXTRA_TEXT,
                "Hi " + username + ", how have you been?");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this,
                    "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void openFacebook(final String username) {
        try {
            Intent followIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/" + username));
            startActivity(followIntent);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent followIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/" + username));
                    startActivity(followIntent);
                }
            }, 1000 * 2);
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + username)));
            String errorMessage = (e.getMessage() == null) ? "Message is empty" : e.getMessage();
            Log.e("FacebookAppNotFound", errorMessage);
        }
    }

    private void openTwitter(String username) {
        Intent intent = null;
        try {
            // get the Twitter app if possible
            this.getPackageManager().getPackageInfo("com.twitter.android", 0);
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=" + username));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        } catch (Exception e) {
            // no Twitter app, revert to browser
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/" + username));
        }
        this.startActivity(intent);
    }

    private void openGithub(String username) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/" + username));
        startActivity(intent);
    }

    private void openTumblr(String username) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tumblr.com/blog/" + username));
        startActivity(intent);
    }

    private void openWebsite(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}