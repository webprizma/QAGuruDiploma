package mobile.helpers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class WildberriesApp {
    public static File getApp() {
        String appUrl = "https://d-01.winudf.com/b/APK/Y29tLndpbGRiZXJyaWVzLnJ1XzYwNTE4Xzc3ZWIwOTc1?_fn=V2lsZGJlcnJpZXNfdjQuOC4wMDAwX2Fwa3B1cmUuY29tLmFwaw&_p=Y29tLndpbGRiZXJyaWVzLnJ1&am=dLeQekWhn1ktL8xDnssfag&at=1662321160&download_id=1011403369106310&k=d0098e0ad8005b26430e54dd9000da4f63165914&r=https%3A%2F%2Fapkpure.com%2Fru%2Fwildberries%2Fcom.wildberries.ru";
        String appPath = "src/test/resources/apps/Wildberries_v4.8.0000_apkpure.com.apk";

        File app = new File(appPath);

        if(!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            }
            catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app;
    }


    public static String getAppPackage() {
        return "com.wildberries.ru";
    }

    public static String getAppActivity() {
        return "ru.wildberries.SplashActivity";
    }
}
