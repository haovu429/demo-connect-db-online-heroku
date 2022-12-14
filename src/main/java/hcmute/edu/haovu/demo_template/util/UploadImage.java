package hcmute.edu.haovu.demo_template.util;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;


import javax.servlet.http.Part;
import java.io.InputStreamReader;
import java.util.Map;

public class UploadImage {
    public static Map uploadAvatarImage(String imageName,String folderPath, Part file) {
        Cloudinary cloudinary = CloudinaryUtil.getCloudinary();

        try {
            byte[] sourceBytes = IOUtils.toByteArray(file.getInputStream());
            //byte[] image = Base64.encodeBase64();
            //String encodedString = new String(image);

            Base64 base64 = new Base64();
            String encodedString = base64.encodeToString(sourceBytes);
            System.out.println(encodedString);
//            File file1 = new File("")

            // Upload the image
            Map params1 =
                    ObjectUtils.asMap(
                            "folder",
                            folderPath,
                            "public_id",
                            imageName,
                            "use_filename",
                            true,
                            "unique_filename",
                            false,
                            "overwrite",
                            true);

            Map result = cloudinary.uploader().upload("data:image/png;base64," + encodedString, params1);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map deleteAvatarImage(String imageName) {
        Cloudinary cloudinary = CloudinaryUtil.getCloudinary();

        try {
            // Destroy the image
            Map params1 = ObjectUtils.asMap("resource_type", "image", "type", "upload", "invalidate", true);

            Map result = cloudinary.uploader().destroy(Constant.STORAGE_IMAGE_LOCATION + "/" + imageName, params1);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
