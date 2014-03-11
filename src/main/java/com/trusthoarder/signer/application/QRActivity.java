package com.trusthoarder.signer.application;

import com.trusthoarder.signer.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.Toast;
import android.widget.ImageView;

import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.WriterException;

public class QRActivity extends Activity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.qr);

    Bitmap qrCode = buildQRCode("hello, world");

    ImageView qrCodeIV = (ImageView)findViewById(R.id.qr_code);
    qrCodeIV.setImageBitmap(qrCode);
  }

  private Bitmap buildQRCode(String message) {
    int width = 400, height = 400;
    QRCodeWriter writer = new QRCodeWriter();
    Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

    try {
      BitMatrix output = writer.encode(
          message, BarcodeFormat.valueOf("QR_CODE"), width, height);

      for (int x = 0; x < width; x++)
        for (int y = 0; y < height; y++)
          bmp.setPixel(x, y, output.get(x,y) ? Color.BLACK : Color.WHITE);

    } catch (WriterException e) {
      Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
    }

    return bmp;
  }
}
