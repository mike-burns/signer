package com.mike_burns.signer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.WriterException;

public class QRActivity extends Activity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    buildQRCode("hello, world");
    setContentView(R.layout.qr);
  }

  private void buildQRCode(String message) {
    QRCodeWriter writer = new QRCodeWriter();
    try {
      BitMatrix output = writer.encode(message, BarcodeFormat.valueOf("QR_CODE"), 20, 20);
      output.getWidth();
    } catch (WriterException e) {
      String whatever = "fail?";
    }
  }
}
