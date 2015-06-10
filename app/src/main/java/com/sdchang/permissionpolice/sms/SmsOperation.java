package com.sdchang.permissionpolice.sms;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.telephony.SmsManager;
import com.sdchang.permissionpolice.R;
import com.sdchang.permissionpolice.lib.request.sms.SmsRequest;

/**
 *
 */
class SmsOperation {
    static final SmsOperation[] operations = new SmsOperation[]{
            new SmsOperation(SmsRequest.SEND_DATA_MESSAGE,
                    R.string.dialogTitle_smsSendDataMessage, new SmsFunction() {
                @Override
                public void execute(SmsManager sms, SmsRequest request, Bundle response) {
                    sms.sendDataMessage(request.string0(), request.string1(), request.short0(), request.byteArray0(),
                            request.pendingIntent0(), request.pendingIntent1());
                }
            }),
            new SmsOperation(SmsRequest.SEND_MULTIMEDIA_MESSAGE,
                    R.string.dialogTitle_smsSendMultimediaMessage, new SmsFunction() {
                @Override
                public void execute(SmsManager sms, SmsRequest request, Bundle response) {
                    if (VERSION.SDK_INT >= 21) {
                        sms.sendMultimediaMessage(null, request.uri0(), request.string0(), request.bundle0(),
                                request.pendingIntent0());
                    }
                }
            }),
            new SmsOperation(SmsRequest.SEND_MULTIPART_TEXT_MESSAGE,
                    R.string.dialogTitle_smsSendMultipartTextMessage, new SmsFunction() {
                @Override
                public void execute(SmsManager sms, SmsRequest request, Bundle response) {
                    sms.sendMultipartTextMessage(request.string0(), request.string1(), request.arrayListOfStrings0(),
                            request.arrayListOfPendingIntents0(), request.arrayListOfPendingIntents1());
                }
            }),
            new SmsOperation(SmsRequest.SEND_TEXT_MESSAGE,
                    R.string.dialogTitle_smsSendTextMessage, new SmsFunction() {
                @Override
                public void execute(SmsManager sms, SmsRequest request, Bundle response) {
                    sms.sendTextMessage(request.string0(), request.string1(), request.string2(),
                            request.pendingIntent0(), request.pendingIntent1());
                }
            }),
    };

    public final String mOpCode;
    @StringRes public final int mDialogTitle;
    public final SmsFunction mFunction;

    public SmsOperation(String opCode,
                        int dialogTitle,
                        SmsFunction function) {
        mOpCode = opCode;
        mDialogTitle = dialogTitle;
        mFunction = function;
    }
}