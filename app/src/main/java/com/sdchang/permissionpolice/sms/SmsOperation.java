package com.sdchang.permissionpolice.sms;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.SmsManager;
import com.sdchang.permissionpolice.ProxyFunction;
import com.sdchang.permissionpolice.ProxyOperation;
import com.sdchang.permissionpolice.R;
import com.sdchang.permissionpolice.lib.request.RequestParams;
import com.sdchang.permissionpolice.lib.request.sms.SmsRequest;

/**
 *
 */
public class SmsOperation {
    private static final ProxyOperation[] operations = new ProxyOperation[]{
            new ProxyOperation(SmsRequest.SEND_DATA_MESSAGE,
                    R.string.dialogTitle_smsSendDataMessage, 4, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    SmsManager mgr = SmsManager.getDefault();
                    mgr.sendDataMessage(request.string0(), request.string1(), request.short0(), request
                                    .byteArray0(),
                            request.pendingIntent0(), request.pendingIntent1());
                }
            }),
            new ProxyOperation(SmsRequest.SEND_MULTIMEDIA_MESSAGE,
                    R.string.dialogTitle_smsSendMultimediaMessage, 21, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    if (VERSION.SDK_INT >= 21) {
                        SmsManager mgr = SmsManager.getDefault();
                        mgr.sendMultimediaMessage(null, request.uri0(), request.string0(), request.bundle0(),
                                request.pendingIntent0());
                    }
                }
            }),
            new ProxyOperation(SmsRequest.SEND_MULTIPART_TEXT_MESSAGE,
                    R.string.dialogTitle_smsSendMultipartTextMessage, 4, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    SmsManager mgr = SmsManager.getDefault();
                    mgr.sendMultipartTextMessage(request.string0(), request.string1(), request
                                    .arrayListOfStrings0(),
                            request.arrayListOfPendingIntents0(), request.arrayListOfPendingIntents1());
                }
            }),
            new ProxyOperation(SmsRequest.SEND_TEXT_MESSAGE,
                    R.string.dialogTitle_smsSendTextMessage, 4, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    SmsManager mgr = SmsManager.getDefault();
                    mgr.sendTextMessage(request.string0(), request.string1(), request.string2(),
                            request.pendingIntent0(), request.pendingIntent1());
                }
            }),
    };

    public static ProxyOperation getOperation(String opCode) {
        for (ProxyOperation operation : operations) {
            if (operation.mOpCode.equals(opCode)) {
                return operation;
            }
        }
        return null;
    }
}
