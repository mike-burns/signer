package com.mike_burns.signer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class SigningActivity extends Activity {
  public final static String SEARCH_STRING = "com.mike_burns.signer.SEARCH_STRING";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.search);
  }

  public void search(View view) {
    Intent intent = new Intent(this, SearchResultsActivity.class);

    EditText editText = (EditText) findViewById(R.id.search_string);
    String message = editText.getText().toString();
    intent.putExtra(SEARCH_STRING, message);

    startActivity(intent);
  }
}