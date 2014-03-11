package com.trusthoarder.signer.application;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import com.trusthoarder.signer.R;

public class KeyActivity extends Activity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView( R.layout.key);

    Intent intent = getIntent();
    String keyid = intent.getStringExtra(SearchResultsActivity.KEYID);

    TextView keyidText = (TextView)findViewById(R.id.keyid);
    keyidText.setText(keyid);
  }

  public void approve(View view) {
    Intent intent = new Intent(this, QRActivity.class);
    startActivity(intent);
  }
}
