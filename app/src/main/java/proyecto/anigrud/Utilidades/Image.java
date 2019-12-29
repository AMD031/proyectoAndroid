package proyecto.anigrud.Utilidades;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

import proyecto.anigrud.R;

public class Image {

    public static String base64 (ImageView imageView){
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageInByte = baos.toByteArray();
        String foto = Base64.encodeToString(imageInByte, Base64.DEFAULT);
        return  foto;
    }

    public static Bitmap bitmap (String mBase64string){
        byte[] decodedString = Base64.decode(mBase64string, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }





}
