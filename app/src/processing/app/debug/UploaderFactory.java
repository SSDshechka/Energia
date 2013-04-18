package processing.app.debug;

import java.util.Map;
import java.util.regex.Pattern;

public class UploaderFactory {

  private static final Pattern IPV4_ADDRESS = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");

  public Uploader newUploader(TargetBoard board, String port) {
    if ("true".equals(board.getPreferences().get("upload.via_http")) && IPV4_ADDRESS.matcher(port).find()) {
      return new HttpUploader(port);
    }

    return new BasicUploader();
  }

}
