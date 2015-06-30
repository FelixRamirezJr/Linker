package edu.myschool.android.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.Toast;


/**
 * Created by hp8440p on 1/1/2015.
 */
public class ShareActivity extends Activity implements
        ShareActionProvider.OnShareTargetSelectedListener, TextWatcher {
    private ShareActionProvider share=null;
    private Intent shareIntent=new Intent(Intent.ACTION_SEND);
    private EditText editor=null;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        shareIntent.setType("text/plain");
        editor=(EditText)findViewById(R.id.editor);
        editor.addTextChangedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);

        MenuItem item = menu.findItem(R.id.share);
        share = (ShareActionProvider) item.getActionProvider();


        return(super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onShareTargetSelected(ShareActionProvider source,
                                         Intent intent) {
        Toast.makeText(this, intent.getComponent().toString(),
                Toast.LENGTH_LONG).show();

        return(false);
    }

    @Override
    public void afterTextChanged(Editable s) {
        shareIntent.putExtra(Intent.EXTRA_TEXT, s.toString());
        share.setShareIntent(shareIntent);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
        // ignored
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before,
                              int count) {
        // ignored
    }
}

