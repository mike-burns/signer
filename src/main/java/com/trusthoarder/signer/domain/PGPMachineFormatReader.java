package com.trusthoarder.signer.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PGPMachineFormatReader {
  public List<PublicKeyMeta> read( BufferedReader content ) throws IOException {
    List<PublicKeyMeta> keys = new ArrayList<>();
    PublicKeyMeta currentKey = null;

    String line;
    while ( (line = content.readLine()) != null ) {
      String[] parts = line.split( ":", -1 );
      if ( parts.length < 1 ) {
        continue;
      }
      String type = parts[0];
      if ( type.equals( "pub" ) ) {
        if ( currentKey != null ) {
          keys.add( currentKey );
        }
        currentKey = new PublicKeyMeta(
          Long.decode( String.format( "#%s", parts[1] ) ),
          // Default to keyId as friendly name.
          parts[1] );
      }
      else if ( type.equals( "uid" ) && currentKey != null ) {
        currentKey = new PublicKeyMeta( currentKey.keyId(), parts[1] );
      }
    }
    if ( currentKey != null ) {
      keys.add( currentKey );
    }
    return keys;
  }

  private long parseLong( String part ) {
    return part == null || part.length() == 0 ? -1 : Long.parseLong( part );
  }

  private int parseInt( String part ) {
    return part == null || part.length() == 0 ? -1 : Integer.parseInt( part );
  }


}
