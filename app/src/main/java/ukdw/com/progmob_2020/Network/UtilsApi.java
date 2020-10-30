package ukdw.com.progmob_2020.Network;

import android.content.Context;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class UtilsApi {
    public static String base64Encode(EditText ninmik, EditText password) {
        String auth = ninmik + ":" + password;
        return Base64.encodeToString(auth.getBytes(), Base64.NO_WRAP);
    }

    public static void hideSoftKey(View view) {
        if (view.getContext() != null) {
            InputMethodManager iml = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (iml != null) {
                iml.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
