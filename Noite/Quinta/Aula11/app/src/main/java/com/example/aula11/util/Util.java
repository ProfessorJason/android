package com.example.aula11.util;

import android.content.Context;
import android.widget.Toast;

public abstract class Util {

    public static void exibirToast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
