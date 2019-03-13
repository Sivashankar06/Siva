package hobby.siva.smsapplication.util;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 12/03/19
 */
public class PermissionChecker {

    public static boolean checkPermission(Activity actContext, String permission, int requestCode) {
        if(isPermissionRationale(actContext, permission)) {
            ActivityCompat.requestPermissions(actContext, new String[] { permission }, requestCode);
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPermissionAvailable(Activity actContext, String permission) {
        return !isPermissionCheckRequired() || (ContextCompat.checkSelfPermission(actContext, permission) == PackageManager.PERMISSION_GRANTED);
    }

    public static boolean isPermissionRationale(Activity context, String permission){
        return ActivityCompat.shouldShowRequestPermissionRationale(context, permission);
    }

    private static boolean isPermissionCheckRequired() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }
}