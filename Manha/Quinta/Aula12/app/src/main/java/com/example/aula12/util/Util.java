package com.example.aula12.util;

import android.content.Context;
import android.widget.Toast;

public class Util {

    public static void exibirToast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
